package com.fanwang.demo_doctor.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.fanwang.demo_doctor.R;

/**
 * Created by edison on 2018/6/5.
 */

public class Add_bank_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private int[] data=new int[6];
    private int mSelectedPos=-1;//保存当前选中的position 重点！

    private OnclickItem onclickItem;

    public interface OnclickItem {
        void SetOnclickItems(int position, View view);
    }

    public void GetOnclickItems(OnclickItem onclickItem) {
        this.onclickItem = onclickItem;
    }

    public Add_bank_Adapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        for (int i = 0; i < data.length; i++) {
            data[i]=1+i;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.add_bank_adapter, parent, false);
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
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.textView.setText("农业银行"+data[position]);
        viewHolder.checkBox.setChecked(mSelectedPos==position);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSelectedPos!=position){
                  viewHolder.checkBox.setChecked(true);
                }
                if (mSelectedPos!=-1){
                    notifyItemChanged(mSelectedPos,0);
                }
                mSelectedPos=position;
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        CheckBox checkBox;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv_yinghang);
            checkBox=itemView.findViewById(R.id.ck_add_bank);
        }
    }
}
