package com.fanwang.demo_doctor.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fanwang.demo_doctor.R;

public class Personal_Adapter_Top extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private int[] data = new int[6];

    private Service_Adapter.OnclickItem onclickItem;

    public interface OnclickItem {
        void SetOnclickItems(int position, View view);
    }

    public void GetOnclickItems(Service_Adapter.OnclickItem onclickItem) {
        this.onclickItem = onclickItem;
    }

    public Personal_Adapter_Top(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        for (int i = 0; i < data.length; i++) {
            data[i] = 1 + i;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.personal_data_adapter_top, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickItem.SetOnclickItems((int) v.getTag(), v);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.textView.setText("许三多" + data[position]);
        viewHolder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_personal_name_a);
        }
    }

}
