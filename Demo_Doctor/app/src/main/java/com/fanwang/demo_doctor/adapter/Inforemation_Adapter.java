package com.fanwang.demo_doctor.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fanwang.demo_doctor.R;

/**
 * Created by edison on 2018/6/6.
 */

public class Inforemation_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private int[] data = new int[10];
    public OnclickItems onclickItems;
    private Onclick_Long_Items onclick_long_items;
    private String title;

    public interface OnclickItems {
        void SetOnclick(View view, int position);
    }

    //点击回调
    public interface Onclick_Items_Itmes {
        void OnItems_Onclick_Items(View view, int position);
    }
    public interface Onclick_Long_Items{
        void OnItems_Long_Onclick(View view,int position);
    }
    public void SetOnclick_Items(OnclickItems onclickItems) {
        this.onclickItems=onclickItems;
    }

    public void SteOn_Long_Click_Items(Onclick_Long_Items onclick_items){
        this.onclick_long_items=onclick_items;
    }

    public Inforemation_Adapter(Context context,String title) {
        this.context = context;
        this.title=title;
        inflater = LayoutInflater.from(context);
        for (int i = 0; i < data.length; i++) {
            data[i] = 1 + i;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.information_fragment_adapter, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickItems.SetOnclick(v, (Integer) v.getTag());
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                onclick_long_items.OnItems_Long_Onclick(view, (Integer) view.getTag());
                return true;
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        if (title.equals("患者消息")){
            viewHolder.tv_name.setText("chaoyue"+data[position]);
        }else {
            viewHolder.tv_name.setText("系统消息"+data[position]);
            viewHolder.linearLayout.setVisibility(View.GONE);
        }
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        LinearLayout linearLayout;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv_name=itemView.findViewById(R.id.tv_name);
            linearLayout=itemView.findViewById(R.id.tv_linear_all);
        }
    }
}
