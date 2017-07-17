package com.lcu.cs.demodailyapplication.com.lcu.cs.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.lang.annotation.Target;

/**
 * Created by Alvin on 2017/6/13.
 */

@DatabaseTable(tableName = "tuling")
public class TuLing {

    public TuLing(){

    }

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "userName")
    private String userName;
    @DatabaseField(columnName = "key")
    private int key;

    @DatabaseField(columnName = "info")
    private String info;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
