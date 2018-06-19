package com.fanwang.demo_doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.fanwang.demo_doctor.R;
import com.fanwang.demo_doctor.commonality.Populace_Activity;
import com.fanwang.demo_doctor.commonality.TitleBackFragment;
import com.fanwang.demo_doctor.custom.ButtonM;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by edison on 2018/6/15.
 */

public class DaiRenfu extends Populace_Activity {

    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.bt_a)
    ButtonM btA;
    @BindView(R.id.but_one)
    ButtonM butOne;
    @BindView(R.id.but_two)
    ButtonM butTwo;
    @BindView(R.id.but_threes)
    ButtonM butThrees;
    @BindView(R.id.login_tijiao)
    Button loginTijiao;
    private TitleBackFragment titleBackFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dairen_download);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("选择服务对象", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.but_one, R.id.but_two, R.id.but_threes})
    public void OnclickItem(View view) {
        switch (view.getId()) {
            case R.id.but_one:
            case R.id.but_two:
            case R.id.but_threes:
                startActivity(new Intent(this, Health_record.class));
                break;
        }
    }
}
