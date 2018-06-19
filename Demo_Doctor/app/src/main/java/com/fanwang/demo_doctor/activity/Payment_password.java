package com.fanwang.demo_doctor.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;


import com.fanwang.demo_doctor.R;
import com.fanwang.demo_doctor.commonality.Populace_Activity;
import com.fanwang.demo_doctor.commonality.TitleBackFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by edison on 2018/6/15.
 */

public class Payment_password extends Populace_Activity {

    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.old_password)
    EditText oldPassword;
    @BindView(R.id.new_password)
    EditText newPassword;
    @BindView(R.id.ok_password)
    EditText okPassword;
    @BindView(R.id.submit)
    Button submit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_password);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    @Override
    public void initView() {
        TitleBackFragment titleBackFragment = new TitleBackFragment().newInstance("修改密码", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {

    }
}
