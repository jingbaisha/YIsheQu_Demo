package com.fanwang.demo_doctor.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fanwang.demo_doctor.R;
import com.fanwang.demo_doctor.activity.Carousel_Items;
import com.fanwang.demo_doctor.activity.Health_Promotion_fragment_a;
import com.fanwang.demo_doctor.activity.Health_promotion_Activity;
import com.fanwang.demo_doctor.activity.Information;
import com.fanwang.demo_doctor.activity.School_Diaocha;
import com.fanwang.demo_doctor.activity.Work_Plan;
import com.fanwang.demo_doctor.adapter.Home_Lv;
import com.fanwang.demo_doctor.commonality.Popuplace_Fragment;
import com.fanwang.demo_doctor.custom.MyLIstView;
import com.jauker.widget.BadgeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * Created by edison on 2018/6/5.
 */

public class Home_fragment extends Popuplace_Fragment implements  BGABanner.Delegate, AdapterView.OnItemClickListener {

    @BindView(R.id.iv_home_saoyisao)
    ImageView ivHomeSaoyisao;
    @BindView(R.id.banner_fresco_demo_content)
    BGABanner bannerFrescoDemoContent;
    @BindView(R.id.iv_yuyue)
    ImageView ivYuyue;
    @BindView(R.id.Linear_My_appointment)
    LinearLayout LinearMyAppointment;
    @BindView(R.id.iv_message)
    ImageView ivMessage;
    @BindView(R.id.linear_xiaoxi)
    LinearLayout linearXiaoxi;
    @BindView(R.id.message_btn)
    TextView messageBtn;
    @BindView(R.id.iv_show_left)
    ImageView ivShowLeft;
    @BindView(R.id.lin_lay_jkzs)
    LinearLayout linLayJkzs;
    @BindView(R.id.iv_show_right)
    ImageView ivShowRight;
    @BindView(R.id.lin_jkxw)
    LinearLayout linJkxw;
    @BindView(R.id.lin_layout_stop)
    LinearLayout linLayoutStop;
    @BindView(R.id.lv_home)
    MyLIstView lvHome;
    @BindView(R.id.iv_show_more)
    LinearLayout ivShowMore;
    @BindView(R.id.linear_work)
    LinearLayout linearWork;
    @BindView(R.id.linear_school)
    LinearLayout linearSchool;

    private Home_Lv adapter;
    private BadgeView badgeView;
    Unbinder unbinder;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    private void initData() {
        badgeView = new BadgeView(getContext());
        badgeView.setTargetView(badgeView);
        badgeView.setBadgeCount(4);

        badgeView = new BadgeView(getContext());
        badgeView.setTargetView(ivMessage);
        badgeView.setBadgeCount(5);

        badgeView = new BadgeView(getContext());
        badgeView.setTargetView(messageBtn);
        badgeView.setBadgeCount(5);



        bannerFrescoDemoContent.setData(null, ImageView.ScaleType.CENTER_CROP,
                R.drawable.uoko_guide_background_1,
                R.drawable.uoko_guide_background_2,
                R.drawable.uoko_guide_background_3);
        adapter = new Home_Lv(getContext());
        lvHome.setAdapter(adapter);
        lvHome.setOnItemClickListener(this);
    }

    private void initView() {
        bannerFrescoDemoContent.setDelegate(this);
    }

    @OnClick({R.id.linear_work,R.id.linear_school,R.id.message_btn,
            R.id.lin_lay_jkzs,R.id.lin_jkxw,R.id.iv_show_more,R.id.iv_show_left,
            R.id.iv_show_right,R.id.Linear_My_appointment})
    public void OnItemsOnclick(View view) {
        switch (view.getId()){
            case R.id.linear_work:
                startActivity(new Intent(getContext(), Work_Plan.class));
                break;
            case R.id.linear_school:
                startActivity(new Intent(getContext(), School_Diaocha.class));
                break;
            case R.id.message_btn:
                startActivity(new Intent(getContext(), Information.class));
                break;
            case R.id.lin_lay_jkzs:
                initOnclick(1);
                break;
            case R.id.lin_jkxw:
                initOnclick(2);
                break;
                //更多信息
            case R.id.iv_show_more:
                startActivity(new Intent(getContext(),Health_promotion_Activity.class));
                break;
                //工作计划
        }
    }

    private void initOnclick(int i) {
        if (i == 1) {
            ivShowLeft.setVisibility(View.VISIBLE);
        } else {
            ivShowLeft.setVisibility(View.GONE);
        }

        if (i == 2) {
            ivShowRight.setVisibility(View.VISIBLE);
        } else {
            ivShowRight.setVisibility(View.GONE);
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onBannerItemClick(BGABanner banner, View itemView, @Nullable Object model, int position) {
        startActivity(new Intent(getContext(), Carousel_Items.class));
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        startActivity(new Intent(getContext(), Health_Promotion_fragment_a.class));
    }
}
