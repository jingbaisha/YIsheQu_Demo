package com.fanwang.demo_doctor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fanwang.demo_doctor.R;


/**
 * Created by chaoyue on 2018/6/7.
 */

public class Details_a_GridView extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private String[] name={"身份证","医师执业证","工作证","个人证件"};

    public Details_a_GridView(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return name.length;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.personal_data_adapter, parent, false);
            viewHolder.textView = convertView.findViewById(R.id.tv_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(name[position]);
        return convertView;
    }

    class ViewHolder {
        TextView textView;
    }
}
