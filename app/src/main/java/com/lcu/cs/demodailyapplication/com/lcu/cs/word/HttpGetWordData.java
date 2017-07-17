package com.lcu.cs.demodailyapplication.com.lcu.cs.word;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Alvin on 2017/6/6.
 */

public class HttpGetWordData {

    private String url;
    private String context;

    public HttpGetWordData(String url){
        this.url = url;
    }

    public String getWordData(){

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            context = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return context;
    }
}
