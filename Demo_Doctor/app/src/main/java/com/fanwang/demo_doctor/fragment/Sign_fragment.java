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
import android.widget.Button;

import com.fanwang.demo_doctor.R;
import com.fanwang.demo_doctor.activity.DaiRenfu;
import com.fanwang.demo_doctor.activity.Qr_code;
import com.fanwang.demo_doctor.adapter.Sign_fragment_Adapter;
import com.fanwang.demo_doctor.commonality.Popuplace_Fragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by edison on 2018/6/5.
 */

public class Sign_fragment extends Popuplace_Fragment implements Sign_fragment_Adapter.OnclickItems {

    @BindView(R.id.iv_home_saoyisao)
    Button ivHomeSaoyisao;
    @BindView(R.id.rcy_sign)
    RecyclerView rcySign;
    Unbinder unbinder;
    private Sign_fragment_Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sign_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    private void initData() {
        DividerItemDecoration divider = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.recyclerview_item_a));
        rcySign.addItemDecoration(divider);

        adapter = new Sign_fragment_Adapter(getContext());
        rcySign.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        rcySign.setAdapter(adapter);
        adapter.SetOnclick_Items(this);
    }

    private void initView() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //点击事件
    @Override
    public void SetOnclick(View view, int position) {
        startActivity(new Intent(getContext(), DaiRenfu.class));
    }

    @OnClick({R.id.iv_home_saoyisao})
    public void OnclickItem(View view){
        switch (view.getId()){
            case R.id.iv_home_saoyisao:
                startActivity(new Intent(getContext(), Qr_code.class));
                break;
        }
    }
}
