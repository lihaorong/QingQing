package com.example.wechart;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private EditText editTextUserName;
    private  EditText editTextPassword;
    private String StringUserName;
    private String StringPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
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
        Button BtnRegister = (Button)findViewById(R.id.register_btn_confirm);
        editTextUserName = (EditText)findViewById(R.id.register_username_text);
        editTextPassword = (EditText)findViewById(R.id.register_password_text);
        editTextPassword.setTypeface(Typeface.DEFAULT);
        editTextPassword.setTransformationMethod(new PasswordTransformationMethod());
        BtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringUserName = editTextUserName.getText().toString();
                StringPassword = editTextPassword.getText().toString();
                if("".equals(StringUserName)){
                    Toast.makeText(RegisterActivity.this,"用户名不能为空",Toast.LENGTH_SHORT).show();
                }else if("".equals(StringPassword)){
                    Toast.makeText(RegisterActivity.this,"密码不能为空",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(RegisterActivity.this, "注册成功,点击登录", Toast.LENGTH_SHORT).show();
                    //注册一个intent存放数据
                    Intent intentSignin = new Intent();
                    intentSignin.putExtra("returnUserName", StringUserName);
                    intentSignin.putExtra("returnPassword", StringPassword);
                    setResult(RESULT_OK, intentSignin);
                    finish();
                }

                }
        });
    }
}
