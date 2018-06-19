package com.fanwang.demo_doctor.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.fanwang.demo_doctor.R;
import com.fanwang.demo_doctor.commonality.Populace_Activity;
import com.fanwang.demo_doctor.commonality.TitleBackFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by edison on 2018/6/19.
 */

public class Forger_the_Password extends Populace_Activity {


    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.login_username)
    EditText loginUsername;
    @BindView(R.id.get_code_btn)
    Button getCodeBtn;
    @BindView(R.id.login_password)
    EditText loginPassword;
    @BindView(R.id.login_password_queren)
    EditText loginPasswordQueren;
    @BindView(R.id.save_btn)
    Button saveBtn;
    private TimeCount timeCount;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forger_the_password);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        TitleBackFragment titleBackFragment = new TitleBackFragment().newInstance("找回密码", "#23b1a5");
        addTitleFragment(titleBackFragment);
        timeCount = new TimeCount(60000, 1000);
    }

    @Override
    public void initData() {

    }

    //点击事件
    @OnClick({R.id.get_code_btn})
    public void OnclickItems(View view) {
        switch (view.getId()) {
            case R.id.get_code_btn:
                timeCount.start();
                break;
        }
    }

    class TimeCount extends CountDownTimer {

        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            getCodeBtn.setBackgroundColor(Color.parseColor("#999999"));
            getCodeBtn.setClickable(false);
            getCodeBtn.setText("("+millisUntilFinished / 1000 +") 秒后可重发");
        }

        @Override
        public void onFinish() {
            getCodeBtn.setClickable(true);
            getCodeBtn.setText("重新获取验证码");
            getCodeBtn.setBackgroundColor(Color.parseColor("#23b1a5"));
        }
    }
}
