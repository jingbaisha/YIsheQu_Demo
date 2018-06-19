package com.fanwang.demo_doctor.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fanwang.demo_doctor.R;
import com.fanwang.demo_doctor.adapter.My_serve_Adapter;
import com.fanwang.demo_doctor.commonality.Populace_Activity;
import com.fanwang.demo_doctor.commonality.TitleBackFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class All_reservation extends Populace_Activity {
    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.tv_outpatient)
    TextView tvOutpatient;
    @BindView(R.id.tv_open_serve)
    TextView tvOpenServe;
    @BindView(R.id.tv_serve)
    TextView tvServe;
    @BindView(R.id.rcv_serve)
    RecyclerView rcvServe;
    private TitleBackFragment titleBackFragment;
    private My_serve_Adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_reservation);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("", "全部预约", "", "#23b1a5");
        addTitleFragment(titleBackFragment);
        tvOutpatient.setSelected(true);
    }

    @Override
    public void initData() {
        adapter = new My_serve_Adapter(this);
        rcvServe.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcvServe.setAdapter(adapter);
    }

    @OnClick({R.id.tv_outpatient, R.id.tv_open_serve, R.id.tv_serve})
    public void Onclick(View view) {
        switch (view.getId()) {
            case R.id.tv_outpatient:
                init(1);
                break;
            case R.id.tv_open_serve:
                init(2);
                break;
            case R.id.tv_serve:
                init(3);
                break;
        }

    }

    private void init(int i) {
        if (i==1){
            tvOutpatient.setSelected(true);
        }else {
            tvOutpatient.setSelected(false);
        }
        if (i==2){
            tvOpenServe.setSelected(true);
        }else {
            tvOpenServe.setSelected(false);
        }
        if (i==3){
            tvServe.setSelected(true);
        }else {
            tvServe.setSelected(false);
        }
    }
}
