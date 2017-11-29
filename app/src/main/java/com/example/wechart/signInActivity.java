package com.example.wechart;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signInActivity extends AppCompatActivity {
    private EditText editTextUserName;
    private  EditText editTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        //隐藏标题栏
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
        //设置注册界面的跳转
        Button BtnSignInRegister = (Button)this.findViewById(R.id.btn_register);
        BtnSignInRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(signInActivity.this,RegisterActivity.class);
                Toast.makeText(signInActivity.this, "欢迎注册", Toast.LENGTH_SHORT).show();
                startActivityForResult(intent,1);
        //

            }
        });

        Button BtnSignIn = (Button)findViewById(R.id.btn_signin);
        final EditText signUserName = (EditText)findViewById(R.id.username_text);
        final EditText signPassword = (EditText)findViewById(R.id.password_text);
        BtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if("".equals(signUserName.getText().toString())||"".equals(signPassword.getText().toString())) {
                    Toast.makeText(signInActivity.this, "请正确输入账号和密码", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intentSignIn = new Intent(signInActivity.this, MainActivity.class);
                    startActivity(intentSignIn);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    editTextPassword=(EditText)findViewById(R.id.password_text);
                    editTextUserName=(EditText)findViewById(R.id.username_text);
                    String userName = data.getStringExtra("returnUserName");
                    String passWord = data.getStringExtra("returnPassword");
                    editTextUserName.setText(userName);
                    editTextPassword.setText(passWord);

                }break;
            default:
        }
    }
}
