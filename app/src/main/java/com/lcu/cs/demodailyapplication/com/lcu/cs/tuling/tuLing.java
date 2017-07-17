package com.lcu.cs.demodailyapplication.com.lcu.cs.tuling;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.lcu.cs.demodailyapplication.R;
import com.lcu.cs.demodailyapplication.R;
import com.lcu.cs.demodailyapplication.com.lcu.cs.DBHelper.ORMLiteDatabaseHelper;
import com.lcu.cs.demodailyapplication.com.lcu.cs.bean.Info;
import com.lcu.cs.demodailyapplication.com.lcu.cs.bean.TuLing;
import com.lcu.cs.demodailyapplication.com.lcu.cs.bean.TuLingJson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.b.I;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class tuLing extends OrmLiteBaseActivity<ORMLiteDatabaseHelper> implements HttpGetData,View.OnClickListener {

    private HttpData httpData;
    private List<TuLingJson> lists;
    private ListView lv;
    private EditText sendText;
    private Button send_btn;
    private String text_str;
    private TextAdapter adapter;
    private String[] welcome_array;
    private double currentTime = 0,oldTime = 0;
    private String data;
    private String person = "1";
    private String robott = "2";
    private List<Info> per;
    private List<Info> ro;
    private TuLingJson js;
    private RuntimeExceptionDao<TuLing,Integer> Dao;
    TuLing tuLing;
    private List<TuLing> tuDbData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tu_ling);
        Dao = getHelper().getUserDataDao();
        initView();


    }

    private void initView(){

        lv = (ListView) findViewById(R.id.lv);
        sendText = (EditText) findViewById(R.id.sendText);
        send_btn = (Button) findViewById(R.id.send_btn);
        lists = new ArrayList<TuLingJson>();
        per = new ArrayList<>();
        ro = new ArrayList<>();




        send_btn.setOnClickListener(this);
        adapter = new TextAdapter(lists, this);
        lv.setAdapter(adapter);
/*
        BmobQuery<Info> qu = new BmobQuery<Info>();
        qu.addWhereEqualTo("username","2");
        qu.findObjects(new FindListener<Info>() {
            @Override
            public void done(List<Info> list, BmobException e) {
                if (e == null){
                    //lists.add(new TuLingJson(list.get(7).getInfo(),2,"null"));

                    for (int i = 0; i <= list.size();i++ ){
                        // ro.add(list.get(i));
                     //   Log.i("ro",ro.get(i).getInfo());
                        // lists.add(new TuLingJson(list.get(i+1).getInfo(),2,"null"));
                        lists.add(new TuLingJson(list.get(i).getInfo(),2,""));
                      //  adapter.notifyDataSetChanged();
                        Log.i("ro",list.get(i).getInfo());
                    }

                    //Log.i("in",list.get(2).getInfo());
                }else{
                    Log.i("roerror",e.getMessage());
                    //  Toast.makeText(tuLing.this,e.getErrorCode(),Toast.LENGTH_SHORT).show();
                    Log.i("roerrorcode", String.valueOf(e.getErrorCode()));
                }
            }
        });


        BmobQuery<Info> query = new BmobQuery<Info>();
        query.addWhereEqualTo("username","1");
      //  query.setLimit(50);
        query.findObjects(new FindListener<Info>() {
            @Override
            public void done(List<Info> list, BmobException e) {

                if (e == null){

                    for (int i = 0;i <= list.size();i++ ){
                      // per.add(list.get(i));
                        Log.i("per",list.get(i).getInfo());
                        lists.add(2 * i +1,new TuLingJson(list.get(i).getInfo(),1,""));
                       adapter.notifyDataSetChanged();

                    }
                    //adapter.notifyDataSetChanged();

                  //  Log.i("info",list.get(1).getInfo());

                }else {
                    //Toast.makeText(tuLing.this,"无数据",Toast.LENGTH_SHORT).show();
                    Log.i("error",e.getMessage());
                  //  Toast.makeText(tuLing.this,e.getErrorCode(),Toast.LENGTH_SHORT).show();
                    Log.i("errorcode", String.valueOf(e.getErrorCode()));
                }
            }
        });

*/


       // for (int i = 0; i <= 8 ;i++){

           // lists.add(new TuLingJson(per.get(1).getInfo(),1,"null"));


    //    }
        //lists.add(new TuLingJson(per.get(2).getInfo(),1,"null"));
     //   for (int i = 0; i < per.size()&&i < ro.size();i++){

     //   }

        //获取数据库的数据
        tuDbData = new ArrayList<>();

        tuDbData = Dao.queryForAll();
        for (int i = 0;i < tuDbData.size();i++){
            lists.add(new TuLingJson(tuDbData.get(i).getInfo(),tuDbData.get(i).getKey(),""));
        }
        adapter.notifyDataSetChanged();



        TuLingJson listData;
        listData = new TuLingJson(getRandomWelcomeTips(), TuLingJson.RECEIVER,
                getTime());
        lists.add(listData);
    }

    private String getRandomWelcomeTips() {
        String welcome_tip = null;
        welcome_array = this.getResources()
                .getStringArray(R.array.welcome_tips);
        int index = (int) (Math.random() * (welcome_array.length - 1));
        welcome_tip = welcome_array[index];
        return welcome_tip;
    }

    @Override
    public void getData(String data) {
      //  Log.i("data",data);
            paseText(data);
    }

    public void paseText(String json){

        Gson gson = new Gson();
        TuLing tl = new TuLing();
        TuLingJson tuLingJson = gson.fromJson(json,TuLingJson.class);
        tuLingJson.setFlag(TuLingJson.RECEIVER);
        tuLingJson.setTime(getTime());
        lists.add(tuLingJson);

        tl.setUserName("rob");
        tl.setKey(2);
        tl.setInfo(tuLingJson.getText());
        Dao.create(tl);


        final Info robot = new Info();
        robot.setUsername(robott);
        robot.setInfo(tuLingJson.getText());
        robot.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null){
                    Log.i("robot",robot.getInfo());
                }
            }
        });
        adapter.notifyDataSetChanged();
        Log.i("jsontext",tuLingJson.getText());
    }

    public void onClick(View v){

        getTime();
        text_str = sendText.getText().toString();
        sendText.setText("");
        String dropk = text_str.replace(" ","");
        String dropn = text_str.replace("\n","");
        TuLingJson tuLingJson = new TuLingJson(text_str,TuLingJson.SEND,getTime());
        lists.add(tuLingJson);
        if (lists.size() > 30){
            for (int i = 0; i < lists.size(); i++){
                lists.remove(i);
            }
        }
        adapter.notifyDataSetChanged();

        httpData = (HttpData) new HttpData("http://www.tuling123.com/openapi/api?key=" +
                "d7028e797788470cb67253f607873d03&info="+ dropn,this).execute();


        tuLing = new TuLing();
        tuLing.setUserName("peo");
        tuLing.setKey(1);
        tuLing.setInfo(dropn);
        Dao.create(tuLing);

       // Log.i("dase", Dao.queryForAll().get(2).getInfo());



        Info info = new Info();
        info.setUsername(person);
        info.setInfo(dropn);
        info.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {

                if (e == null){
                    Log.i("创建数据成功","a");
                }
            }
        });



    }

    private String getTime() {
        currentTime = System.currentTimeMillis();
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date curDate = new Date();
        String str = format.format(curDate);
        if (currentTime - oldTime >= 500) {
            oldTime = currentTime;
            return str;
        } else {
            return "";
        }

    }
}
