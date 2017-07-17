package com.lcu.cs.demodailyapplication.com.lcu.cs.bean;

import com.google.gson.annotations.Expose;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;

/**
 * Created by Alvin on 2017/5/23.
 */

public class User extends BmobUser {

    public User(){
        this.setTableName("_User");
    }


}
