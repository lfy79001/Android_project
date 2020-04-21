package com.example.taobaounion5.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.taobaounion5.R;
import com.example.taobaounion5.base.BaseFragment;
import com.example.taobaounion5.ui.fragment.HomeFragment;
import com.example.taobaounion5.ui.fragment.RedPacketFragment;
import com.example.taobaounion5.ui.fragment.SearchFragment;
import com.example.taobaounion5.ui.fragment.SelectedFragment;
import com.example.taobaounion5.utils.LogUtils;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @BindView(R.id.main_navigation_bar)
    public BottomNavigationView mNavigationView;
    private SearchFragment searchFrament;
    private SelectedFragment selectedFragment;
    private RedPacketFragment redPacketFragment;
    private HomeFragment homeFragment;
    private FragmentManager mFm;
    private Unbinder mBind;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBind = ButterKnife.bind(this);
        initFragments();
        initListener();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mBind != null) {
            mBind.unbind();
        }
    }

    private void initFragments() {
        mFm = getSupportFragmentManager();
        homeFragment = new HomeFragment();
        redPacketFragment = new RedPacketFragment();
        selectedFragment = new SelectedFragment();
        searchFrament = new SearchFragment();
        switchFragment(homeFragment);
    }

    private void initListener() {
        mNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.d(TAG,"title -- >" + item.getTitle() + "id -- >" + item.getItemId());
                if(item.getItemId() == R.id.home){
                    LogUtils.d(this, "切换到首页");
                    switchFragment(homeFragment);
                }else if(item.getItemId() == R.id.selected){
                    LogUtils.d(this, "切换到精选");
                    switchFragment(selectedFragment);
                }else if(item.getItemId() == R.id.red_p){
                    LogUtils.d(this, "切换到特惠");
                    switchFragment(redPacketFragment);
                }else if(item.getItemId() == R.id.search){
                    LogUtils.d(this, "切换到搜索");
                    switchFragment(searchFrament);
                }
                return true;
            }
        });
    }

    private void switchFragment(BaseFragment target) {
        FragmentTransaction fragmentTransaction = mFm.beginTransaction();
        fragmentTransaction.replace(R.id.main_page_container, target);
        fragmentTransaction.commit();
    }

    private void initView() {
        HomeFragment homeFragment = new HomeFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.main_page_container,homeFragment);
        transaction.commit();
    }
}
