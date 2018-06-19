package com.fanwang.demo_doctor.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fanwang.demo_doctor.R;

/**
 * Created by edison on 2018/6/5.
 */

public class My_Fragment_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private int[] imge = {R.drawable.grzxzl, R.drawable.grzxjh, R.drawable.grzxjinbi, R.drawable.grzxjinbi, R.drawable.grzxjinbi,
            R.drawable.grzxzhuce, R.drawable.grzxjinggao, R.drawable.grzxxitong, R.drawable.grzxtouxiang};
    private String[] data = {"我的资料", "我的工作计划", "我的收入", "我的银行卡","我的支付密码","邀请注册", "投诉建议", "系统设置", "关于我们"};

    private OnclickItem onclickItem;

    public interface OnclickItem {
        void SetOnclickItems(int position, View view);
    }

    public void GetOnclickItems(OnclickItem onclickItem) {
        this.onclickItem = onclickItem;
    }

    public My_Fragment_Adapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.my_fragment_a, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclickItem.SetOnclickItems((Integer) view.getTag(),view);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.imageView.setBackgroundResource(imge[position]);
        viewHolder.name.setText(data[position]);
        viewHolder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_myserve);
            name = itemView.findViewById(R.id.tv_name_myserve);
        }
    }
}
