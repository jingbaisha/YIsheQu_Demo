package com.fanwang.demo_doctor.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class MyLIstView extends ListView{

    public MyLIstView(Context context) {
        super(context);
    }

    public MyLIstView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLIstView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
