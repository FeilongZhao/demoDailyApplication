package com.lcu.cs.demodailyapplication.com.lcu.cs.DBHelper;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.lcu.cs.demodailyapplication.com.lcu.cs.bean.TuLing;

import java.sql.SQLException;

/**
 * Created by Alvin on 2017/6/13.
 */

public class ORMLiteDatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String TAG = "ORMLiteDatabaseHelper";

    private static final String DATABASE_NAME = "tuling.db";

    private static final int DATABASE_VERSION = 1;

    private Dao<TuLing,Integer> userDao = null;

    private RuntimeExceptionDao<TuLing,Integer> runtimeExceptionDao = null;

    public ORMLiteDatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }


    public ORMLiteDatabaseHelper(Context context, String databaseName,
                                 SQLiteDatabase.CursorFactory factory, int databaseVersion) {
        super(context, databaseName, factory, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {

        try {
            //TableUtils.clearTable(connectionSource,TuLing.class);
            TableUtils.createTable(connectionSource,TuLing.class);
            userDao = getUserDao();
            runtimeExceptionDao = getUserDataDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {

        try {
            TableUtils.dropTable(connectionSource,TuLing.class,true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Dao<TuLing,Integer> getUserDao() throws SQLException{
        if (userDao == null){
            userDao = getDao(TuLing.class);
        }
        return userDao;
    }

    public  RuntimeExceptionDao<TuLing,Integer> getUserDataDao(){
        if (runtimeExceptionDao == null){
            runtimeExceptionDao = getRuntimeExceptionDao(TuLing.class);
        }
        return runtimeExceptionDao;

    }
    public void close(){
        super.close();
        runtimeExceptionDao = null;
    }
}
