package com.example.taobaounion5.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


import com.example.taobaounion5.R;
import com.example.taobaounion5.base.BaseFragment;
import com.example.taobaounion5.model.domain.Categories;
import com.example.taobaounion5.presenter.IHomePresenter;
import com.example.taobaounion5.presenter.impl.HomePresenterImpl;
import com.example.taobaounion5.ui.adapter.HomePagerAdapter;
import com.example.taobaounion5.utils.LogUtils;
import com.example.taobaounion5.view.IHomeCallback;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;


public class HomeFragment extends BaseFragment implements IHomeCallback {

    @BindView(R.id.home_indicator)
    public TabLayout mTabLayout;
    private IHomePresenter homePresenter;
    @BindView(R.id.home_pager)
    public ViewPager homePager;
    private HomePagerAdapter mHomePagerAdapter;


    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View rootView) {
        mTabLayout.setupWithViewPager(homePager);
        //给ViewPager设置适配器
        mHomePagerAdapter = new HomePagerAdapter(getChildFragmentManager());
        //设置适配器
        homePager.setAdapter(mHomePagerAdapter);
    }

    @Override
    protected void initPresenter() {
        // 创建Presenter
        homePresenter = new HomePresenterImpl();
        homePresenter.registerCallback(this);
    }

    @Override
    protected void loadData() {
        // 加载数据
        homePresenter.getCategories();
    }

    @Override
    public void onCategoriesloaded(Categories categories) {
        LogUtils.d(this, "onCategoriesLoaded...");
        //加载的数据就会从这里回来
        if (mHomePagerAdapter != null) {
            mHomePagerAdapter.setCategories(categories);
        }
    }
    @Override
    protected void release() {
        //取消回调注册
        if(homePresenter != null){
            homePresenter.unregisterCallback(this);
        }
    }
}
