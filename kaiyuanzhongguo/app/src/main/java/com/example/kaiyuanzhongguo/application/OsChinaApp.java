package com.example.kaiyuanzhongguo.application;

import android.app.Application;

import com.itheima.retrofitutils.ItheimaHttp;

public class OsChinaApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ItheimaHttp.init(this,"https://www.oschina.net/");
    }
}
