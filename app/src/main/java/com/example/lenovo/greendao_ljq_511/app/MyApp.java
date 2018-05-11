package com.example.lenovo.greendao_ljq_511.app;

import android.app.Application;

import com.example.lenovo.greendao_ljq_511.bean.DaoMaster;
import com.example.lenovo.greendao_ljq_511.bean.DaoSession;

public class MyApp extends Application {

    private DaoMaster daoMaster;
    private static DaoSession daoSession;
    @Override
    public void onCreate() {
        super.onCreate();

        //初始化GreenDao
        //测试使用的版本
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "baway.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        daoSession = daoMaster.newSession();


    }

    //提供方法让外面拿到这个daoSession
    public static DaoSession getDaoSession() {
        return daoSession;
    }
}
