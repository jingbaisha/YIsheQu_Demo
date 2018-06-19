package com.fanwang.demo_doctor.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.fanwang.demo_doctor.R;
import com.fanwang.demo_doctor.commonality.Populace_Activity;
import com.fanwang.demo_doctor.commonality.TitleBackFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by edison on 2018/6/11.
 */

public class School_Diaocha extends Populace_Activity {
    @BindView(R.id.my_indent)
    LinearLayout myIndent;
    private TitleBackFragment titleBackFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school_diaocha);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("校园健康", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {

    }

    @OnClick({})
    public void OnItemsOnclick(View view){
        switch (view.getId()){

        }
    }

}
