package com.lcu.cs.demodailyapplication.com.lcu.cs.TuLingNet;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.lcu.cs.demodailyapplication.R;
import com.lcu.cs.demodailyapplication.com.lcu.cs.bean.Info;
import com.lcu.cs.demodailyapplication.com.lcu.cs.bean.TuLingJson;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class TuLingNet extends AppCompatActivity {

    private ListView lv;
    private TuLingNetAdapter adapter;
    private List<TuLingJson> lists;


    private Boolean t1end = false;
    private Boolean t2end = false;

    private List<Info> list1 = null;

    private List<Info> list2 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tu_ling_net);

        lv = (ListView) findViewById(R.id.tulingnet);

        lists = new ArrayList<>();

       // adapter = new TuLingNetAdapter(lists,this);


        adapter = new TuLingNetAdapter(lists,this);

        lv.setAdapter(adapter);


        AA aa = new AA();
        aa.execute();

        BmobQuery<Info> qu = new BmobQuery<Info>();
        qu.addWhereEqualTo("username","2");
        qu.findObjects(new FindListener<Info>() {
            @Override
            public void done(List<Info> list, BmobException e) {


                if (e == null){
                    //t1end = true;
                    //lists.add(new TuLingJson(list.get(7).getInfo(),2,"null"));
                    list1 = list;
                    /*
                    for (int i = 0; i <= list.size();i++ ){
                        // ro.add(list.get(i));
                        //   Log.i("ro",ro.get(i).getInfo());
                        // lists.add(new TuLingJson(list.get(i+1).getInfo(),2,"null"));
                        lists.add(2 * i + 1,new TuLingJson(list.get(i).getInfo(),2,""));
                         // adapter.notifyDataSetChanged();
                        Log.i("ro",list.get(i).getInfo());
                    }
                    */

                    //Log.i("in",list.get(2).getInfo());
                }else{
                    Log.i("roerror",e.getMessage());
                    //  Toast.makeText(tuLing.this,e.getErrorCode(),Toast.LENGTH_SHORT).show();
                    Log.i("roerrorcode", String.valueOf(e.getErrorCode()));
                }
                t1end = true;
            }
        });


        BmobQuery<Info> query = new BmobQuery<Info>();
        query.addWhereEqualTo("username","1");
        //  query.setLimit(50);
        query.findObjects(new FindListener<Info>() {
            @Override
            public void done(List<Info> list, BmobException e) {

                if (e == null){
                    list2 = list;
                    /*
                    for (int i = 0;i <= list.size();i++ ){
                        // per.add(list.get(i));
                        Log.i("per",list.get(i).getInfo());
                        lists.add(new TuLingJson(list.get(i).getInfo(),1,""));
                        adapter.notifyDataSetChanged();

                    }
                    */
                 //   adapter.notifyDataSetChanged();

                    //  Log.i("info",list.get(1).getInfo());

                }else {
                    //Toast.makeText(tuLing.this,"无数据",Toast.LENGTH_SHORT).show();
                    Log.i("error",e.getMessage());
                    //  Toast.makeText(tuLing.this,e.getErrorCode(),Toast.LENGTH_SHORT).show();
                    Log.i("errorcode", String.valueOf(e.getErrorCode()));
                }
                t2end = true;
            }
        });
    }

    class AA extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {

            while(true){
                if(t1end == true && t2end == true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            for (int i = 0; i <= list1.size();i++ ){
                lists.add(2 * i + 1,new TuLingJson(list1.get(i).getInfo(),2,""));
            }

            for (int i = 0;i <= list2.size();i++ ){
                lists.add(new TuLingJson(list2.get(i).getInfo(),1,""));
            }
            adapter.notifyDataSetChanged();

        }
    }
}
