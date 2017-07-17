package com.lcu.cs.demodailyapplication.com.lcu.cs.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lcu.cs.demodailyapplication.MainActivity;
import com.lcu.cs.demodailyapplication.R;
import com.lcu.cs.demodailyapplication.R;
import com.lcu.cs.demodailyapplication.com.lcu.cs.bean.User;

import java.io.Serializable;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import rx.Subscriber;

public class LoginIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_in);

        final EditText input_userName = (EditText) findViewById(R.id.input_username);
        final EditText input_password = (EditText) findViewById(R.id.input_password);

        Button btn_login = (Button) findViewById(R.id.input_login);

        TextView register = (TextView) findViewById(R.id.input_register);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BmobUser user = new BmobUser();
                user.setUsername(input_userName.getText().toString());
                user.setPassword(input_password.getText().toString());
                user.loginObservable(BmobUser.class).subscribe(new Subscriber<BmobUser>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable throwable) {

                        Toast.makeText(LoginIn.this,throwable.getMessage().toString(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(BmobUser bmobUser) {
                        Toast.makeText(LoginIn.this,"登录成功",Toast.LENGTH_SHORT).show();
                        Intent i4 = new Intent(LoginIn.this,MainActivity.class);
                        i4.putExtra("userName",  input_userName.getText().toString());
                        startActivity(i4);
                        finish();
                    }
                });
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii = new Intent(LoginIn.this,Register.class);
                startActivity(ii);
            }
        });


    }
}
