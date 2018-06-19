package com.fanwang.demo_doctor.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.fanwang.demo_doctor.R;
import com.fanwang.demo_doctor.adapter.MyPagerAdapter;
import com.fanwang.demo_doctor.commonality.Populace_Activity;
import com.fanwang.demo_doctor.commonality.TitleBackFragment;
import com.fanwang.demo_doctor.fragment.home.Information_A;
import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Information extends Populace_Activity {
    @BindView(R.id.st_information)
    SegmentTabLayout stInformation;
    @BindView(R.id.st_viewpager)
    ViewPager stViewpager;

    private TitleBackFragment titleBackFragment;
    private MyPagerAdapter adapter;
    private ArrayList<Fragment> mList = new ArrayList<>();
    String[] data = new String[]{"患者消息", "系统消息"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("消息中心", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {
        for (int i = 0; i < data.length; i++) {
            mList.add(new Information_A().getParameter(data[i]));
        }
        adapter = new MyPagerAdapter(getSupportFragmentManager(), mList, data);
        stViewpager.setAdapter(adapter);
        stInformation.setTabData(data);

        stInformation.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                stViewpager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        stViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                stInformation.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
