package com.fanwang.demo_doctor.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.afollestad.materialdialogs.MaterialDialog;
import com.fanwang.demo_doctor.R;
import com.fanwang.demo_doctor.commonality.Populace_Activity;
import com.fanwang.demo_doctor.commonality.TitleBackFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by edison on 2018/6/19.
 */

public class Bank_Add_New extends Populace_Activity {

    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.old_password)
    EditText oldPassword;
    @BindView(R.id.new_password)
    EditText newPassword;
    @BindView(R.id.ok_password)
    EditText okPassword;
    @BindView(R.id.submit_bank_add)
    Button submitBankAdd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bank_add_new);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        TitleBackFragment titleBackFragment = new TitleBackFragment().newInstance("新增银行卡", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.submit_bank_add})
    public void SetOncclick(View view) {

        switch (view.getId()) {
            case R.id.submit_bank_add:
                final MaterialDialog dialog = new MaterialDialog.Builder(this)
                        .customView(R.layout.dialog_add_bank, false)
                        .build();
                dialog.show();
                View ok = dialog.findViewById(R.id.but_ok);
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                break;
        }
    }
}
