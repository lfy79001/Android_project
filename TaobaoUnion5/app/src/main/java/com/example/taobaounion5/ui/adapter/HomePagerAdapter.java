package com.example.taobaounion5.ui.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.example.taobaounion5.model.domain.Categories;
import com.example.taobaounion5.ui.fragment.HomePagerFragment;
import com.example.taobaounion5.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class HomePagerAdapter extends FragmentPagerAdapter {

    private List<Categories.DataBean> categoryList = new ArrayList<>();

    public HomePagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return categoryList.get(position).getTitle();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        LogUtils.d(this, "getItem 0 --->" + position);
        HomePagerFragment homePagerFragment = new HomePagerFragment();
        return homePagerFragment;
    }

    @Override
    public int getCount() {

        return categoryList.size();
    }

    public void setCategories(Categories categories) {
        categoryList.clear();
        LogUtils.d(this, "size ---->" + this.categoryList.size());
        List<Categories.DataBean> data = categories.getData();
        this.categoryList.addAll(data);
        notifyDataSetChanged();
    }

}
