package com.lcu.cs.demodailyapplication.com.lcu.cs.register;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lcu.cs.demodailyapplication.R;
import com.lcu.cs.demodailyapplication.com.lcu.cs.bean.User;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class TestRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this,"a105c9af66d32a3857ba76118af7740a");
        setContentView(R.layout.register);
        final User user = new User();
        user.setUsername("bab");
        user.setPassword("bbb");
        user.setMobilePhoneNumber("17862519234");
        user.setEmail("1236@126.com");
        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.signUp(new SaveListener<User>() {
                    @Override
                    public void done(User o, BmobException e) {
                        if (e == null){

                        }else {
                            Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                        }
                    }
                });
            }
        });

    }
}
