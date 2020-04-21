package com.example.xlhhlocation;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.AMapLocationQualityReport;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.WalkRouteResult;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    private MainActivity mActivity;
    private Context mContext;

    private Button idBtnStart;
    private TextView idTvTime;
    private MapView idMv;
    private AMap mAMap;

    private AMapLocationClient locationClient = null;
    private AMapLocationClientOption locationOption = null;

    private LatLng mStartLatLng;
    private LatLng mPreLatLng;

    private long mStartLongTime;
    private long mPreAlertLongTime;
    private long mPreNoMoveTime;

    // 当前轨迹点图案
    private Marker marker = null;
    // 存放所有坐标的数组
    private ArrayList<LatLng> latlngPathList = new ArrayList<>();

    private MediaPlayer mediaPlayer;

    private CarLocationBean mCarLocationBean;


    public void sendSms(String msgContent) {
        SmsManager smsManager = SmsManager.getDefault ();
        ArrayList<String> list = smsManager.divideMessage (msgContent);
        for (int i = 0; i < list.size (); i++) {
            smsManager.sendTextMessage ("18035822525", null, list.get (i), null, null);
        }
    }

    private Handler mHander = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            setCountTime(mStartLongTime);
            switch (msg.what) {
                case 0X03:
                    CarLocationBean carLocationBean = (CarLocationBean) msg.obj;
                    if (carLocationBean == null) {
                        return;
                    }
                    mCarLocationBean = carLocationBean;
                    float distanse = carLocationBean.getDistanse();
                    if (distanse >= 1f) {
                        Log.e(TAG, "handleMessage: 汽车移动中");
                        //表示车已经移动了
                        //超过4个小时，给出提醒
                        mPreNoMoveTime = System.currentTimeMillis();
                        if (System.currentTimeMillis() - mPreAlertLongTime >= 4 * 60 * 60 * 1000) {
                            Toast.makeText(mContext, "你已连续行驶4个小时，请勿疲劳驾驶，注意休息！！！", Toast.LENGTH_SHORT).show();
                            StringBuffer sb = new StringBuffer("您的亲人已疲劳驾驶，存在安全风险，目前位置为");
                            sb.append(TextUtils.isEmpty(carLocationBean.getAMapLocation().getAddress())?"暂时未知":carLocationBean.getAMapLocation().getAddress());
                            sb.append("，地址经度/纬度：");
                            sb.append(carLocationBean.getAMapLocation().getLongitude());
                            sb.append(" / ");
                            sb.append(carLocationBean.getAMapLocation().getLatitude());
                            sb.append("，请注意及时联系提醒。");
                            sendSms(sb.toString());

                            if (mediaPlayer != null) {
                                mediaPlayer.reset();
                                //获得播放源访问入口
                                AssetFileDescriptor afd = getResources().openRawResourceFd(R.raw.nuu2); // 注意这里的区别
                                //给MediaPlayer设置播放源
                                try {
                                    mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                                    //设置准备就绪状态监听
                                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                        @Override
                                        public void onPrepared(MediaPlayer mp) {
                                            // 准备结束，开始播放
                                            mediaPlayer.start();
                                            mPreAlertLongTime = System.currentTimeMillis();
                                        }
                                    });
                                    //准备播放
                                    mediaPlayer.prepareAsync();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    } else {
                        //未移动的话，要考虑十分钟内停止计时定位
                        if (System.currentTimeMillis() - mPreNoMoveTime >= 10 * 60 * 1000) {
                            Toast.makeText(mContext, "超过十分钟未移动，停止定位，如需要的话，点击开始！！！", Toast.LENGTH_SHORT).show();
                            endCal();
                        }
                    }
                    break;
            }
        }
    };

    private void setCountTime(long preTime) {
        long diffTime = System.currentTimeMillis() - preTime;
        String dayStr = String.valueOf(DateUtil.getDiffTime(diffTime, 0));
//        dayStr = setStrTwoLen(dayStr);
        String hourStr = String.valueOf(DateUtil.getDiffTime(diffTime, 1));
        hourStr = setStrTwoLen(hourStr);
        String minStr = String.valueOf(DateUtil.getDiffTime(diffTime, 2));
        minStr = setStrTwoLen(minStr);
        String secStr = String.valueOf(DateUtil.getDiffTime(diffTime, 3));
        secStr = setStrTwoLen(secStr);
        idTvTime.setText("累计时间：" + dayStr + "  " + hourStr + ":" + minStr + ":" + secStr);
    }

    private String setStrTwoLen(String dayStr) {
        dayStr = dayStr.length() == 1 ? "0" + dayStr : dayStr;
        return dayStr;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        mContext = this;
        setContentView(R.layout.activity_main);

        ((Button) findViewById(R.id.id_btn_bluetooth)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyMainActivity.class);
                if (mCarLocationBean != null) {
                    intent.putExtra("location", mCarLocationBean);
                }
                startActivity (intent);
            }
        });

        idBtnStart = (Button) findViewById(R.id.id_btn_start);
        idTvTime = (TextView) findViewById(R.id.id_tv_time);
        idMv = (MapView) findViewById(R.id.id_mv);
        idBtnStart.setOnClickListener(this);
        idMv.onCreate(savedInstanceState);// 此方法必须重写

        mediaPlayer = new MediaPlayer();
        int checkCallPhonePermission = ContextCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE);
        if (checkCallPhonePermission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 1000);
        } else {
            //初始化定位
            initLocation();
        }
        initMap();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1000:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //初始化定位
                    initLocation();
                } else {
                    Toast.makeText(mContext, "请在设置中开启定位权限", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        }
    }

    private void initMap() {
        if (mAMap == null) {
            mAMap = idMv.getMap();
            mAMap.getUiSettings().setRotateGesturesEnabled(false);
            mAMap.getUiSettings().setZoomControlsEnabled(false);
            mAMap.getUiSettings().setLogoBottomMargin(-100);
        }
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onResume() {
        super.onResume();
        idMv.onResume();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onPause() {
        super.onPause();
        idMv.onPause();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        idMv.onSaveInstanceState(outState);
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (idMv != null) {
            idMv.onDestroy();
        }
        destroyLocation();
    }


    /**
     * 初始化定位
     *
     * @author hongming.wang
     * @since 2.8.0
     */
    private void initLocation() {
        //初始化client
        locationClient = new AMapLocationClient(this.getApplicationContext());
        locationOption = getDefaultOption();
        //设置定位参数
        locationClient.setLocationOption(locationOption);
        // 设置定位监听
        locationClient.setLocationListener(locationListener);
        //启动定位
        locationClient.startLocation();
    }

    /**
     * 默认的定位参数
     *
     * @author hongming.wang
     * @since 2.8.0
     */
    private AMapLocationClientOption getDefaultOption() {
        AMapLocationClientOption mOption = new AMapLocationClientOption();
        mOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);//可选，设置定位模式，可选的模式有高精度、仅设备、仅网络。默认为高精度模式
        mOption.setGpsFirst(false);//可选，设置是否gps优先，只在高精度模式下有效。默认关闭
        mOption.setHttpTimeOut(30000);//可选，设置网络请求超时时间。默认为30秒。在仅设备模式下无效
        mOption.setInterval(0);//可选，设置定位间隔。默认为2秒
        mOption.setNeedAddress(true);//可选，设置是否返回逆地理地址信息。默认是true
        mOption.setOnceLocation(true);//可选，设置是否单次定位。默认是false
        mOption.setOnceLocationLatest(false);//可选，设置是否等待wifi刷新，默认为false.如果设置为true,会自动变为单次定位，持续定位时不要使用
        AMapLocationClientOption.setLocationProtocol(AMapLocationClientOption.AMapLocationProtocol.HTTP);//可选， 设置网络请求的协议。可选HTTP或者HTTPS。默认为HTTP
        mOption.setSensorEnable(false);//可选，设置是否使用传感器。默认是false
        mOption.setWifiScan(true); //可选，设置是否开启wifi扫描。默认为true，如果设置为false会同时停止主动刷新，停止以后完全依赖于系统刷新，定位位置可能存在误差
        mOption.setLocationCacheEnable(true); //可选，设置是否使用缓存定位，默认为true
        mOption.setGeoLanguage(AMapLocationClientOption.GeoLanguage.DEFAULT);//可选，设置逆地理信息的语言，默认值为默认语言（根据所在地区选择语言）
        return mOption;
    }

    /**
     * 定位监听
     */
    AMapLocationListener locationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation location) {
            if (null != location) {

                StringBuffer sb = new StringBuffer();
                //errCode等于0代表定位成功，其他的为定位失败，具体的可以参照官网定位错误码说明
                if (location.getErrorCode() == 0) {
                    sb.append("定位成功" + "\n");
                    sb.append("定位类型: " + location.getLocationType() + "\n");
                    sb.append("经    度    : " + location.getLongitude() + "\n");
                    sb.append("纬    度    : " + location.getLatitude() + "\n");
                    sb.append("精    度    : " + location.getAccuracy() + "米" + "\n");
                    sb.append("提供者    : " + location.getProvider() + "\n");

                    sb.append("速    度    : " + location.getSpeed() + "米/秒" + "\n");
                    sb.append("角    度    : " + location.getBearing() + "\n");
                    // 获取当前提供定位服务的卫星个数
                    sb.append("星    数    : " + location.getSatellites() + "\n");
                    sb.append("国    家    : " + location.getCountry() + "\n");
                    sb.append("省            : " + location.getProvince() + "\n");
                    sb.append("市            : " + location.getCity() + "\n");
                    sb.append("城市编码 : " + location.getCityCode() + "\n");
                    sb.append("区            : " + location.getDistrict() + "\n");
                    sb.append("区域 码   : " + location.getAdCode() + "\n");
                    sb.append("地    址    : " + location.getAddress() + "\n");
                    sb.append("兴趣点    : " + location.getPoiName() + "\n");
                    //定位完成的时间
                    sb.append("定位时间: " + DateUtil.formatUTC(location.getTime(), "yyyy-MM-dd HH:mm:ss") + "\n");
                    LatLng curLatlng = new LatLng(location.getLatitude(), location.getLongitude());
                    //路线集合为空且初始化定位为空，第一次定位
                    if (latlngPathList.size() == 0 && mStartLatLng == null) {
                        Log.e(TAG, "onLocationChanged: 第一次定位");
                        CarLocationBean carLocationBean = new CarLocationBean();
                        carLocationBean.setDistanse(0f);
                        carLocationBean.setAMapLocation(location);
                        mCarLocationBean = carLocationBean;
                        mStartLatLng = curLatlng;
                        //默认定位
                        MarkerOptions markerOptions = new MarkerOptions()
                                .position(mStartLatLng)
                                .icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.gps_point)))
                                .anchor(0.5f, 0.5f);
                        mAMap.addMarker(markerOptions);
                        mAMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mStartLatLng, 16));// 设置指定的可视区域地图
                    } else if (mStartLatLng != null) {
                        //点击开始操作了
                        // 加入坐标
                        if (mPreLatLng != null) {
                            mActivity.getDriverRouteDistanse(mPreLatLng, curLatlng, location);
                        }
                        latlngPathList.add(curLatlng);
                        drawLine();
                    }
                    mPreLatLng = curLatlng;
                } else {
                    //定位失败
                    sb.append("定位失败" + "\n");
                    sb.append("错误码:" + location.getErrorCode() + "\n");
                    sb.append("错误信息:" + location.getErrorInfo() + "\n");
                    sb.append("错误描述:" + location.getLocationDetail() + "\n");
                }
                sb.append("***定位质量报告***").append("\n");
                sb.append("* WIFI开关：").append(location.getLocationQualityReport().isWifiAble() ? "开启" : "关闭").append("\n");
                sb.append("* GPS状态：").append(getGPSStatusString(location.getLocationQualityReport().getGPSStatus())).append("\n");
                sb.append("* GPS星数：").append(location.getLocationQualityReport().getGPSSatellites()).append("\n");
                sb.append("* 网络类型：" + location.getLocationQualityReport().getNetworkType()).append("\n");
                sb.append("* 网络耗时：" + location.getLocationQualityReport().getNetUseTime()).append("\n");
                sb.append("****************").append("\n");
                //定位之后的回调时间
                sb.append("回调时间: " + DateUtil.formatUTC(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss") + "\n");
                //解析定位结果，
                String result = sb.toString();
                Log.e(TAG, "onLocationChanged: result==" + result);
            } else {
                Log.e(TAG, "onLocationChanged: 定位失败，loc is null");
            }
        }
    };


    /**
     * 获取GPS状态的字符串
     *
     * @param statusCode GPS状态码
     * @return
     */
    private String getGPSStatusString(int statusCode) {
        String str = "";
        switch (statusCode) {
            case AMapLocationQualityReport.GPS_STATUS_OK:
                str = "GPS状态正常";
                break;
            case AMapLocationQualityReport.GPS_STATUS_NOGPSPROVIDER:
                str = "手机中没有GPS Provider，无法进行GPS定位";
                break;
            case AMapLocationQualityReport.GPS_STATUS_OFF:
                str = "GPS关闭，建议开启GPS，提高定位质量";
                break;
            case AMapLocationQualityReport.GPS_STATUS_MODE_SAVING:
                str = "选择的定位模式中不包含GPS定位，建议选择包含GPS定位的模式，提高定位质量";
                break;
            case AMapLocationQualityReport.GPS_STATUS_NOGPSPERMISSION:
                str = "没有GPS定位权限，建议开启gps定位权限";
                break;
        }
        return str;
    }


    // 根据控件的选择，重新设置定位参数
    private void resetOption() {
        if (latlngPathList.size() > 0) latlngPathList.clear();
        //设置是否开启wifi扫描，如果设置为false时同时会停止主动刷新，停止以后完全依赖于系统刷新，定位位置可能存在误差
        // 设置发送定位请求的时间间隔,最小值为1000，如果小于1000，按照1000算
        locationOption.setInterval(2000);//可选，设置定位间隔。默认为2秒
        locationOption.setOnceLocation(false);//可选，设置是否单次定位。默认是false
    }

    /**
     * 开始定位
     *
     * @author hongming.wang
     * @since 2.8.0
     */
    private void startLocation() {
        //根据控件的选择，重新设置定位参数
        resetOption();
        // 设置定位参数
        locationClient.setLocationOption(locationOption);
        // 启动定位
        locationClient.startLocation();
    }

    /**
     * 停止定位
     *
     * @author hongming.wang
     * @since 2.8.0
     */
    private void stopLocation() {
        // 停止定位
        locationClient.stopLocation();
    }

    /**
     * 销毁定位
     *
     * @author hongming.wang
     * @since 2.8.0
     */
    private void destroyLocation() {
        if (null != locationClient) {
            /**
             * 如果AMapLocationClient是在当前Activity实例化的，
             * 在Activity的onDestroy中一定要执行AMapLocationClient的onDestroy
             */
            locationClient.onDestroy();
            locationClient = null;
            locationOption = null;
        }
    }

    @Override
    public void onClick(View view) {
        String textStr = idBtnStart.getText().toString().trim();
        if (textStr.equals("开始驾驶")) {
            //开始操作
            mStartLongTime = System.currentTimeMillis();
            mPreNoMoveTime = mPreAlertLongTime = mStartLongTime;
            startLocation();
            idBtnStart.setText("结束驾驶");
        } else if (textStr.equals("结束驾驶")) {
            //结束操作
            endCal();
        }
    }

    private void endCal() {
        if (latlngPathList.size() > 0) latlngPathList.clear();
        mStartLongTime = System.currentTimeMillis();
        mPreNoMoveTime = mPreAlertLongTime = mStartLongTime;
        mPreLatLng = null;
        if (mediaPlayer != null) {
            Log.e(TAG, "endCal: 释放资源");
            mediaPlayer.release();
        }
        stopLocation();
        idBtnStart.setText("开始驾驶");
        setCountTime(mStartLongTime);
    }

    private void drawLine() {
        for (int i = 0; i < latlngPathList.size(); i++) {
            LatLng latLng = latlngPathList.get(i);
            Log.e(TAG, i + "===i===drawLine: latLng===" + latLng.toString());
        }
        mAMap.clear();
        if (marker != null) {
            marker.destroy();
        }
        // 添加汽车的位置
        MarkerOptions markerOptions = new MarkerOptions()
                .position(latlngPathList.get(latlngPathList.size() - 1))
                .title("现在的位置")
                .snippet(" ")
                .icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.car)))
                .anchor(0.5f, 0.5f);
        marker = mAMap.addMarker(markerOptions);
        // 增加起点开始
        mAMap.addMarker(new MarkerOptions()
                .position(latlngPathList.get(0))
                .title("起点")
                .icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.start))));
        // 增加起点结束
        if (latlngPathList.size() > 1) {
            PolylineOptions polylineOptions = (new PolylineOptions())
                    .addAll(latlngPathList)
                    .color(Color.rgb(9, 129, 240))
                    .width(6.0f);
            mAMap.addPolyline(polylineOptions);
            //终点的位置
//            mAMap.addMarker(new MarkerOptions()
//                    .position(latlngPathList.get(latlngPathList.size() - 1))
//                    .title("终点")
//                    .icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.end))));
        }
    }


    /**
     * 获取汽车的距离,不是直线距离，依次判断汽车是否在动
     *
     * @param startLatlng
     * @param endLatlng
     */
    private void getDriverRouteDistanse(final LatLng startLatlng, final LatLng endLatlng, final AMapLocation aMapLocation) {
        Log.e(TAG, "getDriverRouteDistanse: startLatlng==" + startLatlng.toString());
        Log.e(TAG, "getDriverRouteDistanse: endLatlng==" + endLatlng.toString());
        if (TextUtils.equals(startLatlng.toString(), endLatlng.toString())) {
            Message msg = mHander.obtainMessage();
            CarLocationBean carLocationBean = new CarLocationBean();
            carLocationBean.setDistanse(0f);
            carLocationBean.setAMapLocation(aMapLocation);
            msg.obj = carLocationBean;
            msg.what = 0X03;
            mHander.sendMessage(msg);
            return;
        }
        RouteSearch routeSearch = new RouteSearch(mContext);
        //模拟起始点与目的经纬度（如：深圳市）
        RouteSearch.FromAndTo fromAndTo = new RouteSearch.FromAndTo(new LatLonPoint(startLatlng.latitude, startLatlng.longitude), new LatLonPoint(endLatlng.latitude, endLatlng.longitude));
        //驾车：第一个参数表示fromAndTo包含路径规划的起点和终点，drivingMode表示驾车模式(支持20种模式  -在PathPlanningStrategy类中定义)
        //第三个参数表示途经点（最多支持16个），第四个参数表示避让区域（最多支持32个），第五个参数表示避让道路
        //模式链接：http://lbs.amap.com/api/android-navi-sdk/guide/route-plan/drive-route-plan
        // fromAndTo包含路径规划的起点和终点，drivingMode表示驾车模式
        // 第三个参数表示途经点（最多支持16个），第四个参数表示避让区域（最多支持32个），第五个参数表示避让道路
        RouteSearch.DriveRouteQuery query = new RouteSearch.DriveRouteQuery(fromAndTo, RouteSearch.DrivingDefault, null, null, "");
        routeSearch.calculateDriveRouteAsyn(query);
        routeSearch.setRouteSearchListener(new RouteSearch.OnRouteSearchListener() {
            @Override
            public void onBusRouteSearched(BusRouteResult busRouteResult, int errorCode) {

            }

            @Override
            public void onDriveRouteSearched(DriveRouteResult driveRouteResult, int errorCode) {
                if (errorCode == AMapException.CODE_AMAP_SUCCESS) {
                    //这里我们认为10米 就是移动，私家车很少有十米的
                    float distanse = driveRouteResult.getPaths().get(0).getDistance();
                    Log.e(TAG, "onDriveRouteSearched: distanse==" + distanse);
                    Message msg = mHander.obtainMessage();
                    CarLocationBean carLocationBean = new CarLocationBean();
                    carLocationBean.setDistanse(distanse);
                    carLocationBean.setAMapLocation(aMapLocation);
                    msg.what = 0X03;
                    mHander.sendMessage(msg);
                } else {
                    Toast.makeText(mContext, "距离就算失败", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onWalkRouteSearched(WalkRouteResult walkRouteResult, int errorCode) {

            }

            @Override
            public void onRideRouteSearched(RideRouteResult rideRouteResult, int errorCode) {

            }
        });
    }
}
