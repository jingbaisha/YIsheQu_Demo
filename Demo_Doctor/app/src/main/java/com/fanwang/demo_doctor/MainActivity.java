package com.fanwang.demo_doctor;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fanwang.demo_doctor.fragment.Home_fragment;
import com.fanwang.demo_doctor.fragment.My_fragment;
import com.fanwang.demo_doctor.fragment.Serve_fragment;
import com.fanwang.demo_doctor.fragment.Sign_fragment;
import com.jauker.widget.BadgeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fl_home)
    FrameLayout flHome;
    @BindView(R.id.iv_lin_home)
    ImageView ivLinHome;
    @BindView(R.id.tv_home)
    TextView tvHome;
    @BindView(R.id.lin_home)
    LinearLayout linHome;
    @BindView(R.id.iv_a)
    ImageView ivA;
    @BindView(R.id.tv_family)
    TextView tvFamily;
    @BindView(R.id.lin_a)
    LinearLayout linA;
    @BindView(R.id.iv_b)
    ImageView ivB;
    @BindView(R.id.tv_servre)
    TextView tvServre;
    @BindView(R.id.lin_b)
    LinearLayout linB;
    @BindView(R.id.iv_c)
    ImageView ivC;
    @BindView(R.id.tv_my)
    TextView tvMy;
    @BindView(R.id.lin_c)
    LinearLayout linC;

    private Home_fragment home_fragment;
    private Sign_fragment sign_fragment;
    private Serve_fragment serve_fragment;
    private My_fragment my_fragment;
    private FragmentManager supportFragmentManager;
    private FragmentTransaction fragmentTransaction;
    private BadgeView badgeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initData() {
        supportFragmentManager = getSupportFragmentManager();
    }

    private void initView() {
        //底部按钮
        badgeView = new BadgeView(this);
        badgeView.setTargetView(linA);
        badgeView.setBadgeCount(4);

        ivLinHome.setBackgroundResource(R.drawable.home_13);
        tvHome.setSelected(true);
        fragmentTransaction = supportFragmentManager.beginTransaction();
        if (home_fragment == null) {
            home_fragment = new Home_fragment();
            fragmentTransaction.add(R.id.fl_home, home_fragment);
        }
        fragmentTransaction.show(home_fragment);
        fragmentTransaction.commit();
    }

    @OnClick({R.id.lin_home, R.id.lin_a, R.id.lin_b, R.id.lin_c})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lin_home:
                initShow(1);
                break;
            case R.id.lin_a:
                initShow(2);
                break;
            case R.id.lin_b:
                initShow(3);
                break;
            case R.id.lin_c:
                initShow(4);
                break;
        }
    }

    private void initShow(int i) {
        if (i == 1) {
            ivLinHome.setBackgroundResource(R.drawable.home_13);
            tvHome.setSelected(true);
        } else {
            ivLinHome.setBackgroundResource(R.drawable.qyjt_05);
            tvHome.setSelected(false);
        }
        if (i == 2) {
            ivA.setBackgroundResource(R.drawable.qyjt_06);
            tvFamily.setSelected(true);
        } else {
            ivA.setBackgroundResource(R.drawable.home_14);
            tvFamily.setSelected(false);
        }
        if (i == 3) {
            ivB.setBackgroundResource(R.drawable.fw_08);
            tvServre.setSelected(true);
        } else {
            ivB.setBackgroundResource(R.drawable.home_15);
            tvServre.setSelected(false);
        }
        if (i == 4) {
            ivC.setBackgroundResource(R.drawable.wode_900);
            tvMy.setSelected(true);
        } else {
            ivC.setBackgroundResource(R.drawable.fw_11);
            tvMy.setSelected(false);
        }

        fragmentTransaction = supportFragmentManager.beginTransaction();
        showorhit();
        switch (i) {
            case 1:
                if (home_fragment == null) {
                    home_fragment = new Home_fragment();
                    fragmentTransaction.add(R.id.fl_home, home_fragment);
                } else {
                    fragmentTransaction.show(home_fragment);
                }
                break;

            case 2:
                if (sign_fragment == null) {
                    sign_fragment = new Sign_fragment();
                    fragmentTransaction.add(R.id.fl_home, sign_fragment);
                } else {
                    fragmentTransaction.show(sign_fragment);
                }
                break;
            case 3:
                if (serve_fragment == null) {
                    serve_fragment = new Serve_fragment();
                    fragmentTransaction.add(R.id.fl_home, serve_fragment);
                } else {
                    fragmentTransaction.show(serve_fragment);
                }
                break;
            case 4:
                if (my_fragment == null) {
                    my_fragment = new My_fragment();
                    fragmentTransaction.add(R.id.fl_home, my_fragment);
                } else {
                    fragmentTransaction.show(my_fragment);
                }
        }
        fragmentTransaction.commit();
    }

    private void showorhit() {
        if (home_fragment != null) {
            fragmentTransaction.hide(home_fragment);
        }
        if (sign_fragment != null) {
            fragmentTransaction.hide(sign_fragment);
        }
        if (serve_fragment != null) {
            fragmentTransaction.hide(serve_fragment);
        }
        if (my_fragment != null) {
            fragmentTransaction.hide(my_fragment);
        }
    }
}
