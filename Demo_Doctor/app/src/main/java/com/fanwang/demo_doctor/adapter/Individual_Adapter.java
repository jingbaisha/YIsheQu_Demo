package com.fanwang.demo_doctor.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fanwang.demo_doctor.R;

/**
 * Created by edison on 2018/6/6.
 */

public class Individual_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private int[] data = new int[10];
    public OnclickItems onclickItems;
    private String title;

    public interface OnclickItems {
        void SetOnclick(View view, int position);
    }

    public void SetOnclick_Items(OnclickItems onclickItems) {
        this.onclickItems=onclickItems;
    }


    public Individual_Adapter(Context context, String title) {
        this.context = context;
        this.title=title;
        inflater = LayoutInflater.from(context);
        for (int i = 0; i < data.length; i++) {
            data[i] = 1 + i;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.individual_adapter, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickItems.SetOnclick(v, (Integer) v.getTag());
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.tv_name.setText("外科上门"+data[position]);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv_name=itemView.findViewById(R.id.tv_name);
        }
    }
}
