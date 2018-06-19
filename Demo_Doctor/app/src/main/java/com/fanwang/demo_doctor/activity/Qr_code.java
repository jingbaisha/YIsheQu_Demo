package com.fanwang.demo_doctor.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.fanwang.demo_doctor.R;
import com.fanwang.demo_doctor.commonality.Populace_Activity;
import com.fanwang.demo_doctor.commonality.TitleBackFragment;

/**
 * Created by Administrator on 2018/6/19.
 */

public class Qr_code extends Populace_Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qr_code);
        initView();
        initData();
    }

    @Override
    public void initView() {
        TitleBackFragment titleBackFragment = new TitleBackFragment().newInstance("二维码名片", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {

    }
}
