package com.fanwang.demo_doctor.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;

import com.fanwang.demo_doctor.R;
import com.fanwang.demo_doctor.commonality.Populace_Activity;
import com.fanwang.demo_doctor.commonality.TitleBackFragment;
import com.fanwang.demo_doctor.fragment.My_Order_Fragment_a;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Individual_Service extends Populace_Activity {

    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.stl_tab_signed)
    SlidingTabLayout stlTabSigned;
    @BindView(R.id.stl_tab_vp)
    ViewPager stlTabVp;

    private String[] data = {"在售", "下架", "审核中"};
    private ArrayList<Fragment> mList = new ArrayList<>();
    private TitleBackFragment titleBackFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.individual_service);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("个人服务", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {

        for (int i = 0; i < data.length; i++) {
            mList.add(new My_Order_Fragment_a().getParameter(data[i]));
        }
        stlTabVp.setAdapter(new MyViewpager(getSupportFragmentManager()));
        stlTabSigned.setViewPager(stlTabVp);
    }

    public class MyViewpager extends FragmentPagerAdapter {

        public MyViewpager(FragmentManager fm) {
            super(fm);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return data[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mList.get(position);
        }

        @Override
        public int getCount() {
            return data.length;
        }
    }
}
