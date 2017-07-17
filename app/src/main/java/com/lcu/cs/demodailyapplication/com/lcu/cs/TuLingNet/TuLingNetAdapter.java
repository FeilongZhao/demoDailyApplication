package com.lcu.cs.demodailyapplication.com.lcu.cs.TuLingNet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lcu.cs.demodailyapplication.R;
import com.lcu.cs.demodailyapplication.com.lcu.cs.bean.TuLingJson;

import java.util.List;

/**
 * Created by Alvin on 2017/6/15.
 */

public class TuLingNetAdapter extends BaseAdapter {

    private List<TuLingJson> lists;
    private Context context;
    private RelativeLayout layout;

    public TuLingNetAdapter(List<TuLingJson> lists,Context context){
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


        LayoutInflater inflater = LayoutInflater.from(context);
        if(lists.get(i).getFlag() == TuLingJson.RECEIVER){
            layout = (RelativeLayout) inflater.inflate(R.layout.leftitem, null);
        }
        if (lists.get(i).getFlag() == TuLingJson.SEND) {
            layout = (RelativeLayout) inflater.inflate(R.layout.rightitem, null);
        }
        TextView tv = (TextView) layout.findViewById(R.id.tv);
        TextView time = (TextView) layout.findViewById(R.id.time);
        tv.setText(lists.get(i).getText());
        time.setText(lists.get(i).getTime());
        return layout;
    }
}
