package com.example.xlhhlocation;

import android.Manifest;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class MyMainActivity extends AppCompatActivity implements View.OnClickListener {

    private final int REQUEST_ENABLE_BT = 0xa01;
    private final int PERMISSION_REQUEST_COARSE_LOCATION = 1000;

    private String TAG = "zhangphil";

    private Button bt_openBluetooth;
    private Button bt_closeBluetooth;
    private Button bt_findDevice;
    private Button bt_connect;
    private Button bt_send;
    private ListView lv_device;
    private TextView tv_temp;
    private EditText edv_send;

    //private BluetoothSocket socket;
    //private BluetoothDevice device;

    private ArrayAdapter<String> mAdapter;
    private BluetoothAdapter mBluetoothAdapter;

    private ConnectThread connectThread = null;
    private ConnectedThread connectedThread = null;

    private CarLocationBean mCarLocationBean;


    // 广播接收发现蓝牙设备
    private BroadcastReceiver mReceiver = new BroadcastReceiver () {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction ();

            if (BluetoothAdapter.ACTION_DISCOVERY_STARTED.equals (action)) {
                Log.d (TAG, "开始扫描...");
            }

            if (BluetoothDevice.ACTION_FOUND.equals (action)) {
                BluetoothDevice device = intent.getParcelableExtra (BluetoothDevice.EXTRA_DEVICE);
                if (device != null) {
                    // 添加到ListView的Adapter。
                    String name = device.getName ();
                    String address = device.getAddress ();

                    mAdapter.add ("设备名:" + name + "\n设备地址:" + address);
                    mAdapter.notifyDataSetChanged ();

                }
            }

            if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals (action)) {
                Log.d (TAG, "扫描结束.");
            }
/*
            List<String> devices = new ArrayList<String>();
            Set<BluetoothDevice> bondedDevices = mBluetoothAdapter.getBondedDevices();
            for (BluetoothDevice device : bondedDevices) {
                Log.i(TAG, device.getName ());
                if (device.getName ().equals ("HC-05")) {
                    Log.i(TAG, "##########################  HC-05 #####################");
                    connectThread = new ConnectThread (device);
                    connectThread.start();
                    break;
                }
                //Toast.makeText(this, "连接成功", Toast.LENGTH_SHORT).show();
                //break;
            }
        */
        }
    };

    private void request_permission() {
        // 拍照及文件权限申请
        if (ContextCompat.checkSelfPermission (MyMainActivity.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            // 权限还没有授予，进行申请
            ActivityCompat.requestPermissions (MyMainActivity.this,
                    new String[]{Manifest.permission.SEND_SMS}, 3000);
        } else {
            ;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main_my);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (this.checkSelfPermission (Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    || this.checkSelfPermission (Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions (new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.SEND_SMS}, PERMISSION_REQUEST_COARSE_LOCATION);
            }

            if (this.checkSelfPermission (Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions (new String[]{Manifest.permission.SEND_SMS
                }, PERMISSION_REQUEST_COARSE_LOCATION);
            }

            //request_permission();

        }

        Intent intent = getIntent();
        if (intent != null) {
            mCarLocationBean = intent.getParcelableExtra("location");
            Log.e(TAG, "onCreate: mCarLocationBean==" + mCarLocationBean.getAMapLocation().getAddress() );
        }

        // 注册广播接收器。
        // 接收蓝牙发现
        IntentFilter filterFound = new IntentFilter (BluetoothDevice.ACTION_FOUND);

        registerReceiver (mReceiver, filterFound);

        IntentFilter filterStart = new IntentFilter (BluetoothAdapter.ACTION_DISCOVERY_STARTED);

        registerReceiver (mReceiver, filterStart);

        IntentFilter filterFinish = new IntentFilter (BluetoothAdapter.ACTION_DISCOVERY_FINISHED);

        registerReceiver (mReceiver, filterFinish);

        bt_openBluetooth = (Button)

                findViewById (R.id.open_bluetooth);

        bt_closeBluetooth = (Button)

                findViewById (R.id.close_bluetooth);

        bt_findDevice = (Button)

                findViewById (R.id.find_devices);

        bt_connect = (Button)

                findViewById (R.id.bt_connect);

        bt_send = (Button)

                findViewById (R.id.send);

        lv_device = (ListView)

                findViewById (R.id.devices_list);

        tv_temp = (TextView)

                findViewById (R.id.tv_temp);

        edv_send = (EditText)

                findViewById (R.id.edv);

        bt_openBluetooth.setOnClickListener (this);
        bt_closeBluetooth.setOnClickListener (this);
        bt_findDevice.setOnClickListener (this);
        bt_connect.setOnClickListener (this);
        bt_send.setOnClickListener (this);

        mAdapter = new ArrayAdapter<> (this, android.R.layout.simple_list_item_1, android.R.id.text1);
        lv_device.setAdapter (mAdapter);

        tv_temp.setMovementMethod (ScrollingMovementMethod.getInstance ());
    }

    public void onClick(View view) {
        switch (view.getId ()) {
            case R.id.open_bluetooth:
                init ();
                //if(!BluetoothAdapter.isEnabled())
                break;

            case R.id.close_bluetooth:
                cancelDiscovery ();
                closeBluetooth ();
                Toast.makeText (this, "蓝牙已关闭", Toast.LENGTH_SHORT).show ();
                break;

            case R.id.find_devices:
                //discovery();
                break;

            case R.id.bt_connect:

                // 查询配对设备 建立连接，只能连接第一个配对的设备

                List<String> devices = new ArrayList<String> ();
                Set<BluetoothDevice> bondedDevices = mBluetoothAdapter.getBondedDevices ();
                for (BluetoothDevice device : bondedDevices) {
                    Log.i (TAG, device.getName ());

                    if (device.getName ().equals ("HC-05")) {
                        connectThread = new ConnectThread (device);
                        connectThread.start ();
                    }
                    //Toast.makeText(this, "连接成功", Toast.LENGTH_SHORT).show();
                    break;
                }

                break;

            case R.id.send:
                String str;
                str = edv_send.getText ().toString () + "@#";
                Toast.makeText (this, str, Toast.LENGTH_SHORT).show ();

                if (mBluetoothAdapter == null || !mBluetoothAdapter.isEnabled ()) {
                    Toast.makeText (this, "蓝牙未开启", Toast.LENGTH_SHORT).show ();
                    break;
                }
                if (connectedThread == null) {
                    Toast.makeText (this, "未连接设备", Toast.LENGTH_SHORT).show ();
                    break;
                }

                connectedThread.write (str.getBytes ());

                break;
        }
    }

    // 初始化蓝牙设备
    private void init() {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter ();

        // 检查设备是否支持蓝牙设备
        if (mBluetoothAdapter == null) {
            Log.d (TAG, "设备不支持蓝牙");

            // 不支持蓝牙，退出。
            return;
        }

        // 如果用户的设备没有开启蓝牙，则弹出开启蓝牙设备的对话框，让用户开启蓝牙
        if (!mBluetoothAdapter.isEnabled ()) {
            Log.d (TAG, "请求用户打开蓝牙");

            Toast.makeText (this, "打开蓝牙成功", Toast.LENGTH_SHORT).show ();
            Intent enableBtIntent = new Intent (BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult (enableBtIntent, REQUEST_ENABLE_BT);
            // 接下去，在onActivityResult回调判断
        } else {
            discovery ();
        }
    }

    //关闭蓝牙
    private void closeBluetooth() {
        mBluetoothAdapter.disable ();
    }

    // 启动蓝牙发现...
    private void discovery() {
        if (mBluetoothAdapter == null) {
            init ();
        }
        mBluetoothAdapter.startDiscovery ();
    }

    //取消扫描
    private void cancelDiscovery() {
        if (!(mBluetoothAdapter == null)) {
            mBluetoothAdapter.cancelDiscovery ();
        }
    }

    //连接蓝牙
    public class ConnectThread extends Thread {
        private final String MY_UUID = "00001101-0000-1000-8000-00805F9B34FB";
        private final BluetoothSocket socket;
        private final BluetoothDevice device;

        public ConnectThread(BluetoothDevice device) {
            this.device = device;
            BluetoothSocket tmp = null;

            try {
                tmp = device.createRfcommSocketToServiceRecord (UUID.fromString (MY_UUID));
            } catch (IOException e) {
                e.printStackTrace ();
            }
            this.socket = tmp;
        }

        public void run() {
            mBluetoothAdapter.cancelDiscovery ();
            try {
                socket.connect ();
                connectedThread = new ConnectedThread (socket);
                connectedThread.start ();
            } catch (IOException e) {
                try {
                    socket.close ();
                } catch (IOException ee) {
                    ee.printStackTrace ();
                }
                return;
            }
            //manageConnectedSocket(socket);
        }

        public void cancel() {
            try {
                socket.close ();
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }
    }

    private Handler handler = new Handler () {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage (msg);
            switch (msg.what) {
                case 1:
                    Bundle bundle = null;
                    bundle = msg.getData ();
                    String recv = bundle.getString ("recv");
                    tv_temp.setText (recv);
                    break;
            }
        }

        @Override
        public void dispatchMessage(Message msg) {
            super.dispatchMessage (msg);
        }
    };

    //收发数据
    public class ConnectedThread extends Thread {
        BluetoothSocket socket;
        private final InputStream inputStream;
        private final OutputStream outputStream;

        public ConnectedThread(BluetoothSocket socket) {
            this.socket = socket;
            InputStream input = null;
            OutputStream output = null;

            try {
                input = socket.getInputStream ();
                output = socket.getOutputStream ();
            } catch (IOException e) {
                e.printStackTrace ();
            }
            this.inputStream = input;
            this.outputStream = output;
        }

        public void run() {
            StringBuilder recvText = new StringBuilder ();
            byte[] buff = new byte[1024];
            int bytes;

            while (true) {
                try {
                    bytes = inputStream.read (buff);
                    String str = new String (buff, "ISO-8859-1");
                    str = str.substring (0, bytes);

//                    if (!str.endsWith("#")) {
//                        recvText.append(str);
//                        continue;
//                    }

                    recvText.append (str); // 去除'#'

                    Bundle bundle = new Bundle ();
                    Message msg = new Message ();
                    bundle.putString ("recv", recvText.toString ());
                    msg.what = 1;
                    msg.setData (bundle);
//                    msg.obj = String.valueOf(buff);
                    handler.sendMessage (msg);

                    teshu (str);

                } catch (IOException e) {
                    e.printStackTrace ();
                    break;
                }
            }
        }

        public void write(byte[] bytes) {
            try {
                outputStream.write (bytes);
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }

        public void cancel() {
            try {
                socket.close ();
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }

    }

    public void teshu(String msg) {
        Log.i ("ccc", "[" + msg + "]");
        if (msg.equals ("20")) {
            showInputDialog ();
        } else if (msg.contains ("drunk")) {
            playMusic ();
            StringBuffer sb = new StringBuffer("您的亲人喝醉了，并试图在位置为");
            sb.append(TextUtils.isEmpty(mCarLocationBean.getAMapLocation().getAddress())?"暂时未知":mCarLocationBean.getAMapLocation().getAddress());
            sb.append("，地址经度/纬度：");
            sb.append(mCarLocationBean.getAMapLocation().getLongitude());
            sb.append(" / ");
            sb.append(mCarLocationBean.getAMapLocation().getLatitude());
            sb.append("的地址酒驾，快去制止他！！！！");
            sendSms(sb.toString());
        }
    }

    public void sendSms(String msgContent) {
        SmsManager smsManager = SmsManager.getDefault ();
        ArrayList<String> list = smsManager.divideMessage (msgContent);
        for (int i = 0; i < list.size (); i++) {
            smsManager.sendTextMessage ("18035822525", null, list.get (i), null, null);
        }
    }

    private MediaPlayer mediaPlayer;

    public void playMusic() {
        releaseMusic ();
        mediaPlayer = MediaPlayer.create (this, R.raw.nuu2);
        mediaPlayer.setLooping (false);
        mediaPlayer.start ();
    }

    public void releaseMusic() {
        try {
            mediaPlayer.stop ();
            mediaPlayer.release ();
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

    private void showInputDialog() {
        /*@setView 装入一个EditView
         */
        final EditText editText = new EditText (MyMainActivity.this);
        AlertDialog.Builder inputDialog =
                new AlertDialog.Builder (MyMainActivity.this);
        inputDialog.setTitle ("").setView (editText);
        inputDialog.setPositiveButton ("确定",
                new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText (MyMainActivity.this,
                                editText.getText ().toString (),
                                Toast.LENGTH_SHORT).show ();
                        String str = editText.getText ().toString ();
                        if (str.equals ("")) {
                            Toast.makeText (MyMainActivity.this,
                                    "输入数据不能为空",
                                    Toast.LENGTH_SHORT).show ();
                            return;
                        }

                        try {
                            int number = Integer.parseInt (str);
                            if (number < 0 || number > 299) {
                                Toast.makeText (MyMainActivity.this,
                                        "输入数据范围非法",
                                        Toast.LENGTH_SHORT).show ();
                                return;
                            }
                        } catch (Exception e) {
                            Toast.makeText (MyMainActivity.this,
                                    "输入数据非法",
                                    Toast.LENGTH_SHORT).show ();
                            return;
                        }

                        connectedThread.write (str.getBytes ());//到这就把数据发送出去了
                    }
                }).show ();
    }

    /**
     * // 可选方法，非必需
     * // 此方法使自身的蓝牙设备可以被其他蓝牙设备扫描到，
     * // 注意时间阈值。0 - 3600 秒。
     * // 通常设置时间为120秒。
     * <p>
     * private void enable_discovery() {
     * Intent discoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
     * <p>
     * // 第二个参数可设置的范围是0~3600秒，在此时间区间（窗口期）内可被发现
     * // 任何不在此区间的值都将被自动设置成120秒。
     * discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 3600);
     * <p>
     * startActivity(discoverableIntent);
     * }
     */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult (requestCode, resultCode, data);

        if (requestCode == REQUEST_ENABLE_BT) {
            if (resultCode == RESULT_OK) {
                Log.d (TAG, "打开蓝牙成功！");
                discovery ();
            }

            if (resultCode == RESULT_CANCELED) {
                Log.d (TAG, "放弃打开蓝牙！");
            }

        } else {
            Log.d (TAG, "蓝牙异常！");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy ();
        unregisterReceiver (mReceiver);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_COARSE_LOCATION:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                }

                break;
        }
    }
}
