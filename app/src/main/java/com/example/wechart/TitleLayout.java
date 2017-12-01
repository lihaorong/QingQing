package com.example.wechart;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;



/**
 * Created by Administrator on 2017/11/29.
 */

public class TitleLayout extends LinearLayout {
    public TitleLayout(Context context , AttributeSet attrs){
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.title_bar,this);
        Button btn_search = (Button)findViewById(R.id.title_btn_search);

        btn_search.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getContext(),searchActivity.class);
                Toast.makeText(getContext(),"搜索用户",Toast.LENGTH_SHORT).show();
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getContext().startActivity(intent);
            }
        });
    }
}
