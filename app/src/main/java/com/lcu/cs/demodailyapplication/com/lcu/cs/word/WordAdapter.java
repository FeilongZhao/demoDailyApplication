package com.lcu.cs.demodailyapplication.com.lcu.cs.word;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lcu.cs.demodailyapplication.R;
import com.lcu.cs.demodailyapplication.com.lcu.cs.bean.WordJson;

import java.io.IOException;
import java.util.List;

/**
 * Created by Alvin on 2017/6/6.
 */

public class WordAdapter extends BaseAdapter {

    private Context context;
    private List<WordJson> lists;
    private LinearLayout layout;
    private TextView Pron;
    private TextView English;
    private TextView Chinese;
    private TextView miss;
    private Button Btn;

    public WordAdapter(Context context,List<WordJson> lists){

        this.context = context;
        this.lists = lists;
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

        final int a = i;

        if (lists.get(i).getStatus_code() == 0) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.word_english, null);
            Pron = (TextView) view.findViewById(R.id.Pron);
            English = (TextView) view.findViewById(R.id.English);
            Chinese = (TextView) view.findViewById(R.id.Chinese);
            Btn = (Button) view.findViewById(R.id.word_yin);
            Pron.setText(lists.get(i).getData().getPron());
            English.setText(lists.get(i).getData().getEn_definition().getDefn());
            Chinese.setText(lists.get(i).getData().getDefinition());
            Btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    Uri uri;
                    try {
                        mediaPlayer.reset();
                      //  mediaPlayer.setDataSource(context, Uri.parse("http://media.shanbay.com/audio/us/a.mp3"));
                        mediaPlayer.setDataSource(lists.get(a).getData().getAudio());
                        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        Log.i("yinyue",lists.get(a).getData().getAudio());
                        mediaPlayer.prepareAsync();
                        // mediaPlayer.prepare();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            //   mediaPlayer.reset();
                            mediaPlayer.start();
                        }
                    });
                }
            });
        }else {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.word_chinese,null);
            miss = (TextView) view.findViewById(R.id.word_miss);
            miss.setText(lists.get(i).getMsg());
        }
        return view;
    }
}
