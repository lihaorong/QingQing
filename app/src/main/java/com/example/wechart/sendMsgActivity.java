package com.example.wechart;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class sendMsgActivity extends AppCompatActivity {
    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecycleView;
    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_msg);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }
        //状态栏透明
        if(Build.VERSION.SDK_INT>=21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            |View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            );getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        initMsgs();

        inputText=(EditText)findViewById(R.id.et_sent_msg);
        send=(Button)findViewById(R.id.send);
        msgRecycleView=(RecyclerView)findViewById(R.id.recycler_view);

        Button BackToMain = (Button)findViewById(R.id.send_msg_return_main);
        BackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
//                Intent intentToMain = new Intent(sendMsgActivity.this,MainActivity.class);
//                startActivity(intentToMain);
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecycleView.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        msgRecycleView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if(!"".equals(content)){
                    Msg msg  = new Msg(content,Msg.TYPE_SENT);
                    msgList.add(msg);
                    //有新消息时候刷新RecycleVIew的显示
                    adapter.notifyItemInserted(msgList.size()-1);
                    //将画面的显示定位到最后一行
                    msgRecycleView.scrollToPosition(msgList.size()-1);
                    //消息已经发出 清空输入栏
                    inputText.setText("");
                }
            }
        });

    }
    private void initMsgs(){
        Msg msg1 = new Msg("Hello guy",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("Hos is going",Msg.TYPE_RECEIVED);
        msgList.add(msg2);
        Msg msg3 = new Msg("This is Stone-yu",Msg.TYPE_SENT);
        msgList.add(msg3);
    }
}
