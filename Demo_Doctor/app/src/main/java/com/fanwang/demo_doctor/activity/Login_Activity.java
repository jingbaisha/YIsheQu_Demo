package com.fanwang.demo_doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fanwang.demo_doctor.R;
import com.fanwang.demo_doctor.commonality.Populace_Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by edison on 2018/5/23.
 */

public class Login_Activity extends Populace_Activity {


    @BindView(R.id.login_username)
    EditText loginUsername;
    @BindView(R.id.login_password)
    EditText loginPassword;
    @BindView(R.id.login_btn)
    Button loginBtn;
    @BindView(R.id.tv_New_user_registration)
    TextView tvNewUserRegistration;
    @BindView(R.id.tv_forget_the_password)
    TextView tvForgetThePassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    //点击事件
    @OnClick({R.id.tv_New_user_registration, R.id.tv_forget_the_password})
    public void OnclickItems(View view) {
        switch (view.getId()) {
            case R.id.tv_New_user_registration:
                startActivity(new Intent(Login_Activity.this, Register_Activity.class));
                break;
            case R.id.tv_forget_the_password:
                startActivity(new Intent(Login_Activity.this, Forger_the_Password.class));
                break;
        }
    }
}
