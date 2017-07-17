package com.lcu.cs.demodailyapplication;

import android.app.Application;

import com.thinkland.sdk.android.JuheSDKInitializer;

import cn.bmob.v3.Bmob;

/**
 * Created by Alvin on 2017/6/3.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        JuheSDKInitializer.initialize(getApplicationContext());
        Bmob.initialize(this,"a105c9af66d32a3857ba76118af7740a");
    }
}
