package com.fanwang.demo_doctor.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.fanwang.demo_doctor.R;


/**
 * Created by chaoyue on 2018/6/7.
 */

public class Personal_data_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;

    private LayoutInflater inflater;
    public int currentType = DATA_RCY;

    //第一部分
    private static final int DATA_RCY = 0;

    //第二部分
    private static final int CERTIFICATE = 1;

    public Personal_data_Adapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case DATA_RCY:
                currentType = DATA_RCY;
                break;
            case CERTIFICATE:
                currentType = CERTIFICATE;
                break;
        }
        return currentType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == DATA_RCY) {
            return new MyViewHolder(inflater.inflate(R.layout.personal_data_top, parent, false));
        } else if (viewType == CERTIFICATE) {
            return new MyViewHolder_one(inflater.inflate(R.layout.personal_data_bottom, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == DATA_RCY) {
            MyViewHolder myViewHolder = (MyViewHolder) holder;
            myViewHolder.setData();
        } else if (getItemViewType(position) == CERTIFICATE) {
            MyViewHolder_one myViewHolder_one = (MyViewHolder_one) holder;
            myViewHolder_one.setData();
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        public MyViewHolder(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.rcy_personal_data_top);
        }

        public void setData() {
            Personal_Adapter_Top adapter = new Personal_Adapter_Top(context);
            recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
            recyclerView.setAdapter(adapter);
        }
    }

    class MyViewHolder_one extends RecyclerView.ViewHolder {
        GridView gridView;

        public MyViewHolder_one(View itemView) {
            super(itemView);
            gridView = itemView.findViewById(R.id.my_gd);
        }

        public void setData() {
            Details_a_GridView adapter = new Details_a_GridView(context);
            gridView.setAdapter(adapter);
        }
    }

}
