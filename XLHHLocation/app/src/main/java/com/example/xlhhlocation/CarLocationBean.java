package com.example.xlhhlocation;


import android.os.Parcel;
import android.os.Parcelable;

import com.amap.api.location.AMapLocation;

/**
 * 为了处理我们的逻辑封装的一个对象
 *  车辆行驶的距离 、 车辆当前的location信息
 *
 *
 * @time 2019/7/27 9:51
 * @version
 */
public class CarLocationBean implements Parcelable {

    private float distanse;
    private AMapLocation aMapLocation;

    public CarLocationBean() {
    }

    protected CarLocationBean(Parcel in) {
        distanse = in.readFloat();
        aMapLocation = in.readParcelable(AMapLocation.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(distanse);
        dest.writeParcelable(aMapLocation, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CarLocationBean> CREATOR = new Creator<CarLocationBean>() {
        @Override
        public CarLocationBean createFromParcel(Parcel in) {
            return new CarLocationBean(in);
        }

        @Override
        public CarLocationBean[] newArray(int size) {
            return new CarLocationBean[size];
        }
    };

    public float getDistanse() {
        return distanse;
    }

    public void setDistanse(float distanse) {
        this.distanse = distanse;
    }

    public AMapLocation getAMapLocation() {
        return aMapLocation;
    }

    public void setAMapLocation(AMapLocation aMapLocation) {
        this.aMapLocation = aMapLocation;
    }

    @Override
    public String toString() {
        return "CarLocationBean{" +
                "distanse=" + distanse +
                ", aMapLocation=" + aMapLocation +
                '}';
    }
}
