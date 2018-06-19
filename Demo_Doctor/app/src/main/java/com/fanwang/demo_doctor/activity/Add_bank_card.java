package com.fanwang.demo_doctor.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.fanwang.demo_doctor.R;
import com.fanwang.demo_doctor.adapter.Add_bank_Adapter;
import com.fanwang.demo_doctor.commonality.Populace_Activity;
import com.fanwang.demo_doctor.commonality.TitleBackFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Add_bank_card extends Populace_Activity implements Add_bank_Adapter.OnclickItem {

    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.rcy_add_bank)
    RecyclerView rcyAddBank;

    private Add_bank_Adapter adapter;

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
    }

    @Override
    public void initData() {
        rcyAddBank.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new Add_bank_Adapter(this);
        rcyAddBank.setAdapter(adapter);
        adapter.GetOnclickItems(this);
    }

    @Override
    public void SetOnclickItems(int position, View view) {

    }
}
