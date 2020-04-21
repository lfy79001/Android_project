package com.example.taobaounion5.presenter;

import com.example.taobaounion5.view.IHomeCallback;

public interface IHomePresenter {
    /**
     * 获取商品分类
     * */
    void getCategories();

    /**
     * 注册UI通知接口
     * */
    void registerCallback(IHomeCallback callback);

    /**
     * 取消UI通知的接口
     * */
    void unregisterCallback(IHomeCallback callback);
}
