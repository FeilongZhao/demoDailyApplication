package com.lcu.cs.demodailyapplication.com.lcu.cs.weather;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lcu.cs.demodailyapplication.R;
import com.lcu.cs.demodailyapplication.com.lcu.cs.bean.WeatherJson;

import java.util.ArrayList;
import java.util.List;

public class Weather extends AppCompatActivity {

    private String data;
    private List<WeatherJson.ResultBean.FutureBean> lists;
    private TextView weather_temp = null;
    private TextView weather_wind_direction = null;
    private TextView weather_wind_strength = null;
    private TextView weather_dressing_index = null;
    private TextView weather_dressing_advice = null;
    private TextView weather_uv_index = null;
    private ListView weather_lv = null;
    private WeatherAdapter adapter;
    private WeatherJson weatherJson;
    private Handler handler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        weather_temp = (TextView) findViewById(R.id.weather_temp);
        weather_wind_direction = (TextView) findViewById(R.id.weather_wind_direction);
        weather_wind_strength = (TextView) findViewById(R.id.weather_wind_strength);
        weather_dressing_index = (TextView) findViewById(R.id.weather_dressing_index);
        weather_dressing_advice = (TextView) findViewById(R.id.weather_dressing_advice);
        weather_uv_index = (TextView) findViewById(R.id.weather_uv_index);
        weather_lv = (ListView) findViewById(R.id.weather_lv);
        handler = new Handler();
        lists = new ArrayList<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpGetWeatherData h = new HttpGetWeatherData("http://v.juhe.cn/weather/index?format=2&cityname=聊城&key=72269afd64d0445892646143a45c47b5");
                data = h.getUrlData();
                Log.i("data",data);
                paseJson(data);
                handler.post(runnable);

            }
        }).start();

    }

    private void paseJson(String wData){
        Gson gson = new Gson();
        weatherJson = gson.fromJson(wData,WeatherJson.class);
        for (int i = 0; i < weatherJson.getResult().getFuture().size();i++){
            lists.add(weatherJson.getResult().getFuture().get(i));
        }


       // lists.add(weatherJson);
      //  Log.i("lists",lists.get(1).toString());
    }
    Runnable runnable = new Runnable() {
        @Override
        public void run() {

            weather_temp.setText(weatherJson.getResult().getSk().getTemp());
            weather_wind_direction.setText(weatherJson.getResult().getSk().getWind_direction());
            weather_wind_strength.setText(weatherJson.getResult().getSk().getWind_strength());
            weather_dressing_index.setText(weatherJson.getResult().getToday().getDressing_index());
            weather_dressing_advice.setText(weatherJson.getResult().getToday().getDressing_advice());
            weather_uv_index.setText(weatherJson.getResult().getToday().getUv_index());

            adapter = new WeatherAdapter(lists,Weather.this);
            weather_lv.setAdapter(adapter);
        }
    };
}
