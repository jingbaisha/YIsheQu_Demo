package com.fanwang.demo_doctor.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fanwang.demo_doctor.R;
import com.fanwang.demo_doctor.activity.About_we;
import com.fanwang.demo_doctor.activity.Complaint_Advice;
import com.fanwang.demo_doctor.activity.My_bank_card;
import com.fanwang.demo_doctor.activity.Payment_password;
import com.fanwang.demo_doctor.activity.Person_plan;
import com.fanwang.demo_doctor.activity.Personal_Data;
import com.fanwang.demo_doctor.activity.System_settings;
import com.fanwang.demo_doctor.activity.Work_Plan;
import com.fanwang.demo_doctor.adapter.My_Fragment_Adapter;
import com.fanwang.demo_doctor.adapter.Service_Adapter;
import com.fanwang.demo_doctor.commonality.Popuplace_Fragment;
import com.fanwang.demo_doctor.commonality.RecycleViewDivider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by edison on 2018/6/5.
 */

public class My_fragment extends Popuplace_Fragment implements Service_Adapter.OnclickItem, My_Fragment_Adapter.OnclickItem {

    @BindView(R.id.iv_home_saoyisao)
    ImageView ivHomeSaoyisao;
    @BindView(R.id.button)
    TextView button;
    @BindView(R.id.rcy_my)
    RecyclerView rcyMy;
    Unbinder unbinder;
    private My_Fragment_Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initdata();
        return view;
    }

    private void initdata() {
        rcyMy.addItemDecoration(new RecycleViewDivider(getContext(), LinearLayoutManager.VERTICAL, 2, getResources().getColor(R.color.gray_add_a)));
        rcyMy.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        adapter = new My_Fragment_Adapter(getContext());
        rcyMy.setAdapter(adapter);
        adapter.GetOnclickItems(this);
    }

    private void initView() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void SetOnclickItems(int position, View view) {
        switch (position) {
            case 0:
                //我的资料
                startActivity(new Intent(getContext(), Personal_Data.class));
                break;
            case 1:
                //我的工作计划
                startActivity(new Intent(getContext(), Work_Plan.class));
                break;
            case 2:
                //我的收入
                startActivity(new Intent(getContext(), Person_plan.class));
                break;
            case 3:
                //我的银行
                startActivity(new Intent(getContext(), My_bank_card.class));
                break;
            case 4:
                //我的支付密码
                startActivity(new Intent(getContext(), Payment_password.class));
                break;
                //邀请注册
            case 5:
                break;
                //投诉建议
            case 6:
                startActivity(new Intent(getContext(),Complaint_Advice.class));
                break;
            case 7:
                startActivity(new Intent(getContext(), System_settings.class));
                break;
            case 8:
                startActivity(new Intent(getContext(), About_we.class));
                break;

        }

    }
}
