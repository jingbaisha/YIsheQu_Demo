package com.fanwang.demo_doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.fanwang.demo_doctor.R;
import com.fanwang.demo_doctor.adapter.Personal_data_Adapter;
import com.fanwang.demo_doctor.commonality.Populace_Activity;
import com.fanwang.demo_doctor.commonality.TitleBackFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Personal_Data extends Populace_Activity {

    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.again_btn)
    Button againBtn;
    @BindView(R.id.rcy_personal_data)
    RecyclerView rcyPersonalData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_data);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        TitleBackFragment titleBackFragment = new TitleBackFragment().newInstance("个人资料", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        Personal_data_Adapter adapter = new Personal_data_Adapter(this);
        rcyPersonalData.setLayoutManager(linearLayoutManager);
        rcyPersonalData.setAdapter(adapter);
    }

    @OnClick({R.id.again_btn})
    public void Onclick(View view) {
        switch (view.getId()) {
            case R.id.again_btn:
                startActivity(new Intent(this, Qualification.class));
                break;
        }
    }
}
