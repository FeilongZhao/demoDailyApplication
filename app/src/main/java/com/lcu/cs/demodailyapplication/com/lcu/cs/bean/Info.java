package com.lcu.cs.demodailyapplication.com.lcu.cs.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Alvin on 2017/5/23.
 */

public class Info extends BmobObject {
    private String username;
    private String info;
/*
    public Info(){
        this.setTableName("information");
    }
*/
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
