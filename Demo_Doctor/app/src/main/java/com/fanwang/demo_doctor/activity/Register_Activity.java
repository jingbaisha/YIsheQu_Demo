package com.fanwang.demo_doctor.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.fanwang.demo_doctor.MainActivity;
import com.fanwang.demo_doctor.R;
import com.fanwang.demo_doctor.commonality.Populace_Activity;
import com.fanwang.demo_doctor.commonality.TitleBackFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by edison on 2018/5/23.
 * 注册
 */

public class Register_Activity extends Populace_Activity {

    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.login_username)
    EditText loginUsername;
    @BindView(R.id.login_password)
    EditText loginPassword;
    @BindView(R.id.login_password_queren)
    EditText loginPasswordQueren;
    @BindView(R.id.get_code)
    Button mGetcode;
    @BindView(R.id.register_btn)
    Button registerBtn;

    private TitleBackFragment titleBackFragment;
    private TimeCount timeCount;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("", "注册", "", "#23b1a5");
        addTitleFragment(titleBackFragment);
        timeCount = new TimeCount(60000, 1000);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.register_btn,R.id.get_code})
    public void register_btn(View view) {
        switch (view.getId()) {
            case R.id.register_btn:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.get_code:
                timeCount.start();
                break;
        }
    }

    class TimeCount extends CountDownTimer{

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
            mGetcode.setBackgroundColor(Color.parseColor("#999999"));
            mGetcode.setClickable(false);
            mGetcode.setText("("+millisUntilFinished / 1000 +") 秒后可重发");
        }

        @Override
        public void onFinish() {
            mGetcode.setClickable(true);
            mGetcode.setText("重新获取验证码");
            mGetcode.setBackgroundColor(Color.parseColor("#23b1a5"));
        }
    }
}
