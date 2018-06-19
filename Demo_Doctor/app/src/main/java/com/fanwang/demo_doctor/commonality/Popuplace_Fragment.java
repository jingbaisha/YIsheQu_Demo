package com.fanwang.demo_doctor.commonality;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.fanwang.demo_doctor.R;


/**
 * Created by chaoyue on 2018/5/19.
 */

public class Popuplace_Fragment extends Fragment {


    /**
     * 功能说明：加入titlefragment到布局中
     * </p>作者：ts
     * 创建日期:2014-10-13
     * 参数：
     *
     * @param fragment 需要加入的fragment
     */
    final public void addTitleFragment(Fragment fragment) {
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.title_fragment_content, fragment);
        ft.commitAllowingStateLoss();
    }
}
