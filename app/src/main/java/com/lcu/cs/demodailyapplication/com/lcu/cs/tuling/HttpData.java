package com.lcu.cs.demodailyapplication.com.lcu.cs.tuling;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.client.HttpClient;

import java.io.IOException;
import java.io.StringReader;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Alvin on 2017/6/3.
 */

public class HttpData extends AsyncTask<String,Void,String>{

    private OkHttpClient mOkHttpClint;
    private String mData;
    private HttpGetData mHttpGetData;
    private String url;

    public HttpData(String url, HttpGetData mHttpGetData){
        this.url = url;
        this.mHttpGetData = mHttpGetData;
    }

    @Override
    protected String doInBackground(String... strings) {


        mOkHttpClint = new OkHttpClient();
       Request request = new Request.Builder().url(url).build();
        try {
            Response response = mOkHttpClint.newCall(request).execute();
            mData = response.body().string();
            return mData;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {

            mHttpGetData.getData(s);
        //Log.i("sss",s);
        super.onPostExecute(s);
    }

}
