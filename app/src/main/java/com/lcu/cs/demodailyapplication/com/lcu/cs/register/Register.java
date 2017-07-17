package com.lcu.cs.demodailyapplication.com.lcu.cs.register;

import android.content.Intent;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lcu.cs.demodailyapplication.R;
import com.lcu.cs.demodailyapplication.com.lcu.cs.bean.User;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        final EditText userName = (EditText) findViewById(R.id.register_name);
        final EditText password = (EditText) findViewById(R.id.register_password);
        final EditText phone = (EditText) findViewById(R.id.register_phone);
        final EditText email = (EditText) findViewById(R.id.register_email);
        Button register = (Button) findViewById(R.id.register_signup);
       // TextView sign = (TextView) findViewById(R.id.register_login);

        //final String phoneNum = phone.toString();
       // Log.i("username",userName.toString());
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setUsername(userName.getText().toString());
                user.setPassword(password.getText().toString());
                user.setMobilePhoneNumber(phone.getText().toString());
                user.setEmail(email.getText().toString());
                user.signUp(new SaveListener<User>() {
                    @Override
                    public void done(User o, BmobException e) {
                        if (e == null){
                            Toast.makeText(Register.this,"注册成功",Toast.LENGTH_SHORT).show();
                            finish();
                        }else {
                            Toast.makeText(Register.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                            Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                        }
                    }
                });
            }
        });
    }
}
