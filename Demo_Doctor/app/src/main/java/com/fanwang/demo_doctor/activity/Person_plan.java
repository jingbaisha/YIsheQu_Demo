package com.fanwang.demo_doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fanwang.demo_doctor.R;
import com.fanwang.demo_doctor.commonality.Populace_Activity;
import com.fanwang.demo_doctor.commonality.TitleBackFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Person_plan extends Populace_Activity {

    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.btn_tixian)
    Button btnTixian;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_plan);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        TitleBackFragment titleBackFragment = new TitleBackFragment().newInstance("", "我的收入", "提现记录", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.btn_tixian})
    public void Onclick(View view) {
        switch (view.getId()) {
            case R.id.btn_tixian:
                startActivity(new Intent(this, Withdraw_deposit.class));
                break;
        }
    }
}
