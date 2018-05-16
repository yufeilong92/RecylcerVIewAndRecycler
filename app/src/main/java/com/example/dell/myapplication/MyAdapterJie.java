package com.example.dell.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: Adapter.java
 * @Package com.example.dell.myapplication
 * @Description: todo
 * @author: YFL
 * @date: 2018/5/16 23:07
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018/5/16 星期三
 * 注意：本内容仅限于学川教育有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class MyAdapterJie extends RecyclerView.Adapter<MyAdapterJie.ViewHolder> implements View.OnClickListener {

    private final List<SelectVo> mSelect;
    private final int posit;
    private Context mContext;
    private List<Vo> mData;
    private final LayoutInflater inflater;

    public MyAdapterJie(Context mContext, List<Vo> mData, int position, List<SelectVo> mSelect) {
        this.mContext = mContext;
        this.mData = mData;
        this.mSelect = mSelect;
        this.posit = position;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public void onClick(View v) {

    }

    public interface onItemListener {
        public void onItemListener(Vo vo, int poistion);
    }

    private onItemListener itemListener;

    public void setItemListener(onItemListener itemListener) {
        this.itemListener = itemListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.itet_jie, null);
        ViewHolder holder = new ViewHolder(inflate);
        inflate.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final Vo vo = mData.get(position);
        holder.mTvJie.setText(vo.getSex());
        SelectVo selectVo = mSelect.get(posit);
        itemSelect itemSelect = selectVo.getData().get(position);
        if (itemSelect.isSelect()) {
            holder.mChb.setChecked(true);
        } else {
            holder.mChb.setChecked(false);
        }
        holder.mChb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemListener != null) {
                    itemListener.onItemListener(vo, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public CheckBox mChb;
        public TextView mTvJie;

        public ViewHolder(View itemView) {
            super(itemView);
            this.mChb = (CheckBox) itemView.findViewById(R.id.chb);
            this.mTvJie = (TextView) itemView.findViewById(R.id.tv_jie);
        }
    }


}
