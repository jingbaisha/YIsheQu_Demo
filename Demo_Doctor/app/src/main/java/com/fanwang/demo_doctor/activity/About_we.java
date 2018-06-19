package com.fanwang.demo_doctor.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.fanwang.demo_doctor.R;
import com.fanwang.demo_doctor.commonality.Populace_Activity;
import com.fanwang.demo_doctor.commonality.TitleBackFragment;

public class About_we extends Populace_Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_we);
        initView();
        initData();
    }

    @Override
    public void initView() {
        TitleBackFragment titleBackFragment = new TitleBackFragment().newInstance("关于我们", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {

    }
}
