package com.fanwang.demo_doctor.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fanwang.demo_doctor.R;

/**
 * Created by edison on 2018/6/5.
 */

public class Sign_fragment_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private LayoutInflater inflater;
    private int[] ss=new int[20];
    public OnclickItems onclickItems;

    public interface OnclickItems {
        void SetOnclick(View view, int position);
    }

    public void SetOnclick_Items(OnclickItems onclickItems) {
        this.onclickItems=onclickItems;
    }

    public Sign_fragment_Adapter(Context context) {
        this.context = context;
        inflater=LayoutInflater.from(context);
        for (int i = 0; i <ss.length; i++) {
            ss[i]=1+i;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.sign_fragment_adapter, parent, false);
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
        MyViewHolder viewHolder= (MyViewHolder) holder;
        viewHolder.textView.setText(ss[position]+" ");
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return ss.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv_ren);
        }
    }
}
