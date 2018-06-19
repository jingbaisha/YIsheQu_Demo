package com.fanwang.demo_doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fanwang.demo_doctor.R;
import com.fanwang.demo_doctor.commonality.Populace_Activity;
import com.fanwang.demo_doctor.commonality.TitleBackFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Withdraw_deposit extends Populace_Activity {

    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.my_indent)
    LinearLayout myIndent;
    @BindView(R.id.rl_one)
    RelativeLayout rlOne;
    @BindView(R.id.linear)
    LinearLayout linear;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.rl_yinghangka)
    RelativeLayout rlYinghangka;
    @BindView(R.id.btn_tixian)
    Button btnTixian;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.withdraw_deposit);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        TitleBackFragment titleBackFragment = new TitleBackFragment().newInstance("提现", "#23b1a5");
        addTitleFragment(titleBackFragment);

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.rl_yinghangka, R.id.btn_tixian})
    public void Onclick(View view) {
        switch (view.getId()) {
            case R.id.rl_yinghangka:
                startActivity(new Intent(this, Add_bank_card.class));
                break;
            case R.id.btn_tixian:

                break;
        }
    }
}
