package com.lcu.cs.demodailyapplication.com.lcu.cs.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lcu.cs.demodailyapplication.R;
import com.lcu.cs.demodailyapplication.com.lcu.cs.bean.WeatherJson;

import java.util.List;

/**
 * Created by Alvin on 2017/6/11.
 */

public class WeatherAdapter extends BaseAdapter {

    private List<WeatherJson.ResultBean.FutureBean> lists;
    private Context context;
    private TextView weather_future_time;
    private TextView weather_future_temperature;
    private TextView weather_future_weather;
    private TextView weather_future_wind;

    public WeatherAdapter(List<WeatherJson.ResultBean.FutureBean> lists, Context context){

        this.lists = lists;
        this.context = context;
    }
    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int i) {
        return lists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.weather_show,null);

        weather_future_time = (TextView) view.findViewById(R.id.weather_future_time);
        weather_future_temperature = (TextView) view.findViewById(R.id.weather_future_temperature);
        weather_future_weather = (TextView) view.findViewById(R.id.weather_future_weather);
        weather_future_wind = (TextView) view.findViewById(R.id.weather_future_wind);

        weather_future_time.setText(lists.get(i).getDate());
        weather_future_temperature.setText(lists.get(i).getTemperature());
        weather_future_weather.setText(lists.get(i).getWeather());
        weather_future_wind.setText(lists.get(i).getWind());

        return view;
    }
}
