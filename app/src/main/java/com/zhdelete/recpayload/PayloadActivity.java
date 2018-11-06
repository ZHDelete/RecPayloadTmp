package com.zhdelete.recpayload;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import java.util.ArrayList;
import java.util.List;

/**
 * author      :  ZHDelete
 * date        :  2018/5/2
 * description :
 * <p>
 * RecyclerView 局部更新
 * https://blog.csdn.net/qqidai/article/details/68484918
 */
public class PayloadActivity extends AppCompatActivity {

    RecyclerView payloadRc;
    Button payloadBtn;
    Button notifyBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rc_payload);

        payloadRc = findViewById(R.id.rc_view);

        final List<String> datas = new ArrayList<>(15);
        for (int i = 0; i < 15; i++) {
            datas.add("data - " + i);
        }
        final PayloadAdapter adapter = new PayloadAdapter(this, datas);
        payloadRc.setLayoutManager(new LinearLayoutManager(this));
        payloadRc.setAdapter(adapter);


        findViewById(R.id.payloadBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.notifyItemChanged(2, "payload2");

            }
        });


        findViewById(R.id.payload_range_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.notifyItemRangeChanged(3, 2, "payload3");
            }
        });

        findViewById(R.id.notifyBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.notifyItemChanged(2);
            }
        });

        findViewById(R.id.notifyAllBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datas.clear();
                for (int i = 0; i < 15; i++) {
                    datas.add(" new - data - " + i);
                }
                Log.d(IStatic.TAG, "notify all ");
                adapter.notifyDataSetChanged();
            }
        });
    }
}
