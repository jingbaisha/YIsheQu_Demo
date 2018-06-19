package com.fanwang.demo_doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.fanwang.demo_doctor.R;
import com.fanwang.demo_doctor.adapter.Service_Adapter;
import com.fanwang.demo_doctor.commonality.Populace_Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Service_packge extends Populace_Activity implements Service_Adapter.OnclickItem {

    @BindView(R.id.rcy_health_fragment)
    RecyclerView rcyHealthFragment;
    @BindView(R.id.iv_back)
    ImageButton ivBack;
    @BindView(R.id.iv_home_genghuan)
    Button ivHomeGenghuan;
    private Service_Adapter service_adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_packge_fragment);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        //添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this, R.drawable.recyclerview_item_b));
        rcyHealthFragment.addItemDecoration(divider);

        service_adapter = new Service_Adapter(this);
        rcyHealthFragment.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcyHealthFragment.setAdapter(service_adapter);
        service_adapter.GetOnclickItems(this);
    }

    //回调接口  点击事件
    @Override
    public void SetOnclickItems(int position, View view) {

    }

    @OnClick({R.id.iv_back, R.id.iv_home_genghuan})
    public void Onclick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_home_genghuan:
                startActivity(new Intent(this, Add_Service_Package.class));
                break;
        }
    }
}
