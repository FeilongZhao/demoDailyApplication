package com.lcu.cs.demodailyapplication.com.lcu.cs.weather;


import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by Alvin on 2017/6/9.
 */

public class HttpGetWeatherData {

    private String url = null;
    private String reData = null;
    private OkHttpClient okHttpClient = null;

    public HttpGetWeatherData(String url){
        this.url = url;
    }

    public String getUrlData(){

        okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try {
           Response response = okHttpClient.newCall(request).execute();
            reData = response.body().string();
            Log.i("reponse",reData);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return reData;
    }


}
