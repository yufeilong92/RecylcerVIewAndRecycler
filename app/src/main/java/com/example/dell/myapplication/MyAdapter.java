package com.example.dell.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
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
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context mContext;
    private List<listVo> mData;
    private final LayoutInflater mInflater;
    public static List<SelectVo> mSelect = new ArrayList<>();

    public MyAdapter(Context mContext, List<listVo> mData) {
        this.mContext = mContext;
        this.mData = mData;
        mInflater = LayoutInflater.from(mContext);
        init(mData);
    }

    private void init(List<listVo> mData) {
        if (mSelect.size() > 0) {
            mSelect.clear();
        }
        for (int i = 0; i < mData.size(); i++) {
            listVo vo = mData.get(i);
            SelectVo selectVo = new SelectVo();
            selectVo.setParenid(i+"");
            ArrayList<itemSelect> list = new ArrayList<>();
            for (int i1 = 0; i1 < vo.getDatebean().size(); i1++) {
                itemSelect itemSelect = new itemSelect();
                itemSelect.setId(i1 + "");
                itemSelect.setSelect(false);
                list.add(itemSelect);
            }
            selectVo.setData(list);
            mSelect.add(selectVo);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        listVo vo = (listVo) mData.get(position);
        holder.mTv.setText(vo.getName());
        bindViewAdapter(holder, vo.getDatebean(), position);
    }

    private void bindViewAdapter(ViewHolder holder, List<Vo> datebean, final int positionp) {
        GridLayoutManager manager = new GridLayoutManager(mContext, 1);
        manager.setOrientation(GridLayoutManager.VERTICAL);
        holder.mRlvJie.setLayoutManager(manager);
        MyAdapterJie myAdapter = new MyAdapterJie(mContext, datebean, positionp, mSelect);
        holder.mRlvJie.setAdapter(myAdapter);
        myAdapter.setItemListener(new MyAdapterJie.onItemListener() {
            @Override
            public void onItemListener(Vo vo, int poistion) {
                init(mData);
                SelectVo vo1 = mSelect.get(positionp);
                itemSelect itemSelect = vo1.getData().get(poistion);
                itemSelect.setSelect(true);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTv;
        public RecyclerView mRlvJie;

        public ViewHolder(View itemView) {
            super(itemView);
            this.mTv = (TextView) itemView.findViewById(R.id.tv);
            this.mRlvJie = (RecyclerView) itemView.findViewById(R.id.rlv_jie);

        }
    }

}
