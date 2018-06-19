package com.fanwang.demo_doctor.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.fanwang.demo_doctor.R;

/**
 * Created by edison on 2018/6/5.
 */

public class My_bank_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private int[] data = new int[6];
    private int mSelectedPos = -1;//保存当前选中的position 重点！

    private OnclickItem onclickItem;
    private OnclickItem_But_delet delet;


    public interface OnclickItem {
        void SetOnclickItems(int position, View view);
    }

    public interface OnclickItem_But_delet {
        void SetOnclickItem_But_delet(int position, View view);
    }

    public void GetOnclickItems(OnclickItem onclickItem) {
        this.onclickItem = onclickItem;
    }
    public void GetOnclickItem_But_delet(OnclickItem_But_delet onclickItem) {
        this.delet = onclickItem;
    }

    public My_bank_Adapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        for (int i = 0; i < data.length; i++) {
            data[i] = 1 + i;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.my_bank_adapter, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclickItem.SetOnclickItems((Integer) view.getTag(), view);
            }
        });
        holder.button_delet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delet.SetOnclickItem_But_delet((Integer) v.getTag(), v);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.textView.setText("农业银行" + data[position]);
        viewHolder.checkBox.setChecked(mSelectedPos == position);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSelectedPos != position) {
                    viewHolder.checkBox.setChecked(true);
                }
                if (mSelectedPos != -1) {
                    notifyItemChanged(mSelectedPos, 0);
                }
                mSelectedPos = position;
            }
        });
        viewHolder.button_delet.setTag(position);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        CheckBox checkBox;
        Button button_delet;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_yinghang);
            checkBox = itemView.findViewById(R.id.ck_add_bank);
            button_delet = itemView.findViewById(R.id.but_delet);
        }
    }
}
