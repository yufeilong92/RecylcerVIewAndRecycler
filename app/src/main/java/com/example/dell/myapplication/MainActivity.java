package com.example.dell.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<listVo> list;
    private RecyclerView mRlvContent;
    private LinearLayout mLlRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        List<listVo> list = new ArrayList<>();
        int a = 50;
        for (int i = 0; i < a; i++) {
            listVo listVo = new listVo();
            listVo.setId("" + i);
            listVo.setName("小明" + i);
            int b = 5;
            ArrayList<Vo> objects = new ArrayList<>();
            for (int j = 0; j < b; j++) {
                Vo vo = new Vo();
                vo.setId("" + j);
                vo.setName("小鹏");
                if (j % 2 == 0) {
                    vo.setSex("男");
                } else {
                    vo.setSex("女");
                }
                objects.add(vo);
            }
            listVo.setDatebean(objects);
            list.add(listVo);
        }
        bindAdapter(list);
    }

    private void bindAdapter(List<listVo> list) {
        GridLayoutManager manager = new GridLayoutManager(this, 1);
        manager.setOrientation(GridLayoutManager.VERTICAL);
        mRlvContent.setLayoutManager(manager);
        MyAdapter myAdapter = new MyAdapter(this,list);
        mRlvContent.setAdapter(myAdapter);

    }

    private void initView() {
        mRlvContent = (RecyclerView) findViewById(R.id.rlv_content);
        mLlRoot = (LinearLayout) findViewById(R.id.ll_root);
    }
}
