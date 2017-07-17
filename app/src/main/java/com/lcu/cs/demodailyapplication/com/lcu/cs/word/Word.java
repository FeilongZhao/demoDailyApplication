package com.lcu.cs.demodailyapplication.com.lcu.cs.word;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lcu.cs.demodailyapplication.R;
import com.lcu.cs.demodailyapplication.com.lcu.cs.bean.WordJson;

import java.util.ArrayList;
import java.util.List;

public class Word extends AppCompatActivity {

    private String word;
    private String context;
    private WordJson wordData;
    private Handler handler;
    private EditText eWord;
    private Button btn;
    private TextView pron;
    private TextView english;
    private TextView chinese;
    private ListView lv;
    private List<WordJson> lists;
    private WordAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
        handler = new Handler();

        eWord = (EditText) findViewById(R.id.input_Word);
        btn = (Button) findViewById(R.id.input_btn);
        pron = (TextView) findViewById(R.id.Pron);
        english = (TextView) findViewById(R.id.English);
        chinese = (TextView) findViewById(R.id.Chinese);
        lv = (ListView) findViewById(R.id.word_lv);
        lists = new ArrayList<>();



     //   Log.i("aaaa",word);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                word = eWord.getText().toString();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        HttpGetWordData httpGetWordData = new HttpGetWordData("https://api.shanbay.com/bdc/search/?word="+word);
                        context = httpGetWordData.getWordData();
                        Log.i("context",context);
                        wordData = paseWordJson(context);
                      //  handler.post(runnable);
                        if(lists.size() == 0){
                            lists.add(wordData);
                        }else {
                            lists.clear();
                            lists.add(wordData);
                        }

                        handler.post(runnable);
                    }
                }).start();
            }
        });
    }

    public WordJson paseWordJson(String json){


        Gson gson = new Gson();
        WordJson wordJson = gson.fromJson(json,WordJson.class);
        Log.i("MSG",wordJson.getMsg());
        return wordJson;
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            adapter = new WordAdapter(Word.this,lists);
            lv.setAdapter(adapter);
        }
    };

}
