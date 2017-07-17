package com.lcu.cs.demodailyapplication.com.lcu.cs.tuling;

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
 * Created by Alvin on 2017/6/3.
 */

public class TextAdapter extends BaseAdapter {
    private List<TuLingJson> lists;
    private Context mContext;
    private RelativeLayout layout;

    public TextAdapter(List<TuLingJson> lists,Context mContext) {

        this.lists = lists;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        if(lists.get(position).getFlag() == TuLingJson.RECEIVER){
            layout = (RelativeLayout) inflater.inflate(R.layout.leftitem, null);
        }
        if (lists.get(position).getFlag() == TuLingJson.SEND) {
            layout = (RelativeLayout) inflater.inflate(R.layout.rightitem, null);
        }
        TextView tv = (TextView) layout.findViewById(R.id.tv);
        TextView time = (TextView) layout.findViewById(R.id.time);
        tv.setText(lists.get(position).getText());
        time.setText(lists.get(position).getTime());
        return layout;
    }

}
