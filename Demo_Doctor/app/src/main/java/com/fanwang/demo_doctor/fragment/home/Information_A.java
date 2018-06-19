package com.fanwang.demo_doctor.fragment.home;

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

import com.afollestad.materialdialogs.MaterialDialog;
import com.fanwang.demo_doctor.R;
import com.fanwang.demo_doctor.activity.Information_Items;
import com.fanwang.demo_doctor.activity.Leave_Massage;
import com.fanwang.demo_doctor.adapter.Inforemation_Adapter;
import com.fanwang.demo_doctor.commonality.Popuplace_Fragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Information_A extends Popuplace_Fragment implements Inforemation_Adapter.OnclickItems, Inforemation_Adapter.Onclick_Long_Items {

    @BindView(R.id.rcy_home_information)
    RecyclerView rcyHomeInformation;
    Unbinder unbinder;
    private Inforemation_Adapter adapter;
    private String title;

    public Information_A getParameter(String title) {
        Information_A data = new Information_A();
        data.title = title;
        return data;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.information_fragment,container,false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    private void initData() {
        //添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.recyclerview_item_a));
        rcyHomeInformation.addItemDecoration(divider);

        adapter = new Inforemation_Adapter(getContext(),title);
        rcyHomeInformation.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        rcyHomeInformation.setAdapter(adapter);
        adapter.SetOnclick_Items(this);
        adapter.SteOn_Long_Click_Items(this);
    }

    private void initView() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //回调接口
    @Override
    public void SetOnclick(View view, int position) {
        if (title.equals("系统消息")){
            startActivity(new Intent(getContext(), Information_Items.class));
        }else {
            startActivity(new Intent(getContext(), Leave_Massage.class));
        }
    }

    @Override
    public void OnItems_Long_Onclick(View view, int position) {
        final MaterialDialog dialog = new MaterialDialog.Builder(getContext())
                .customView(R.layout.dialog_information, false)
                .build();
        dialog.show();
        View but_ok = dialog.findViewById(R.id.but_ok);
        View quuxiao = dialog.findViewById(R.id.bt_quxiao);
        but_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        quuxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}
