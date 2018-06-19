package com.fanwang.demo_doctor.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.afollestad.materialdialogs.MaterialDialog;
import com.fanwang.demo_doctor.R;
import com.fanwang.demo_doctor.adapter.Add_bank_Adapter;
import com.fanwang.demo_doctor.adapter.My_bank_Adapter;
import com.fanwang.demo_doctor.commonality.Populace_Activity;
import com.fanwang.demo_doctor.commonality.TitleBackFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class My_bank_card extends Populace_Activity implements Add_bank_Adapter.OnclickItem, My_bank_Adapter.OnclickItem, My_bank_Adapter.OnclickItem_But_delet {

    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.rcy_add_bank)
    RecyclerView rcyAddBank;

    private My_bank_Adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_bank);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        TitleBackFragment titleBackFragment = new TitleBackFragment().newInstance("", "我的收入", "新增", "#23b1a5");
        addTitleFragment(titleBackFragment);
        titleBackFragment.setTitleOnClikListener(new TitleBackFragment.TitleOnClikListener() {
            @Override
            public void onClikRight() {
                startActivity(new Intent(My_bank_card.this, Bank_Add_New.class));
            }

            @Override
            public void onClikMiddle() {

            }

            @Override
            public void onClikLeft() {

            }
        });
    }

    @Override
    public void initData() {
        rcyAddBank.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new My_bank_Adapter(My_bank_card.this);
        rcyAddBank.setAdapter(adapter);
        adapter.GetOnclickItems(this);
        adapter.GetOnclickItem_But_delet(this);
    }

    @Override
    public void SetOnclickItems(int position, View view) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    //删除
    @Override
    public void SetOnclickItem_But_delet(int position, View view) {
        final MaterialDialog dialog = new MaterialDialog.Builder(this)
                .customView(R.layout.dialog_a, false)
                .build();
        dialog.show();
        View ok = dialog.findViewById(R.id.but_ok);
        View quxiao = dialog.findViewById(R.id.but_quxiao);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}
