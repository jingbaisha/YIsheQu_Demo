package com.fanwang.demo_doctor.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fanwang.demo_doctor.R;
import com.fanwang.demo_doctor.activity.All_reservation;
import com.fanwang.demo_doctor.activity.Individual_Service;
import com.fanwang.demo_doctor.activity.Information;
import com.fanwang.demo_doctor.activity.Service_packge;
import com.fanwang.demo_doctor.adapter.My_serve_Adapter;
import com.fanwang.demo_doctor.commonality.Popuplace_Fragment;
import com.fanwang.demo_doctor.commonality.RecycleViewDivider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by edison on 2018/6/5.
 */

public class Serve_fragment extends Popuplace_Fragment {

    @BindView(R.id.iv_online)
    ImageView ivOnline;
    @BindView(R.id.Linear_online)
    LinearLayout LinearOnline;
    @BindView(R.id.iv_yuyue)
    ImageView ivYuyue;
    @BindView(R.id.Linear_My_appointment)
    LinearLayout LinearMyAppointment;
    @BindView(R.id.iv_service_packge)
    ImageView ivServicePackge;
    @BindView(R.id.Linear_My_service_package)
    LinearLayout LinearMyServicePackage;
    @BindView(R.id.tv_outpatient)
    TextView tvOutpatient;
    @BindView(R.id.tv_open_serve)
    TextView tvOpenServe;
    @BindView(R.id.tv_serve)
    TextView tvServe;
    @BindView(R.id.rcv_serve)
    RecyclerView rcyserve;
    Unbinder unbinder;
    private My_serve_Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_serve_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    private void initData() {
//        //添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.recyclerview_item));
        rcyserve.addItemDecoration(divider);

//        rcyserve.addItemDecoration(new RecycleViewDivider(
//                getContext(), LinearLayoutManager.VERTICAL, 10, getResources().getColor(R.color.gray_add_a)));

        adapter = new My_serve_Adapter(getContext());
        rcyserve.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        rcyserve.setAdapter(adapter);
    }

    private void initView() {
        tvOutpatient.setSelected(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    @OnClick({R.id.tv_outpatient,R.id.tv_open_serve,R.id.tv_serve,R.id.Linear_online,
            R.id.Linear_My_appointment,R.id.Linear_My_service_package})
    public void Onclick(View view){
        switch (view.getId()){
            case R.id.tv_outpatient:
                init(1);
                break;
            case R.id.tv_open_serve:
                init(2);
                break;
            case R.id.tv_serve:
                init(3);
                break;
                //在线服务
            case R.id.Linear_online:
                startActivity(new Intent(getContext(), Individual_Service.class));
                break;
            case R.id.Linear_My_appointment:
                startActivity(new Intent(getContext(), All_reservation.class));
                break;

            case R.id.Linear_My_service_package:
                startActivity(new Intent(getContext(),Service_packge.class));
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
