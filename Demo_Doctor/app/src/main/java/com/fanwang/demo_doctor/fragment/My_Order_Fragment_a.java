package com.fanwang.demo_doctor.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fanwang.demo_doctor.R;
import com.fanwang.demo_doctor.adapter.Individual_Adapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by edison on 2018/5/31.
 */

public class My_Order_Fragment_a extends Fragment implements Individual_Adapter.OnclickItems {
    Unbinder unbinder;
    @BindView(R.id.tv_my_order)
    RecyclerView tvMyOrder;
    private String title;
    private Individual_Adapter adapter;

    public My_Order_Fragment_a getParameter(String title) {
        My_Order_Fragment_a data = new My_Order_Fragment_a();
        data.title = title;
        return data;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_order_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        //添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.recyclerview_individual));
        tvMyOrder.addItemDecoration(divider);

        adapter = new Individual_Adapter(getContext(),title);
        adapter.SetOnclick_Items(this);
        tvMyOrder.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        tvMyOrder.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    //回掉点击事件
    @Override
    public void SetOnclick(View view, int position) {

    }
}
