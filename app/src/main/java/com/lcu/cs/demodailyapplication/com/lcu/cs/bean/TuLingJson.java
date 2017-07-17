package com.lcu.cs.demodailyapplication.com.lcu.cs.bean;

/**
 * Created by Alvin on 2017/6/3.
 */

public class TuLingJson {

    public static final int SEND = 1;
    public static final int RECEIVER = 2;
    private String code;
    private String text;
    private int flag;
    private String time;

    public TuLingJson(String text,int flag,String time){

        this.text = text;
        this.flag = flag;
        this.time = time;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
