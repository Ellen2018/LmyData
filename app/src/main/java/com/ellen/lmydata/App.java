package com.ellen.lmydata;

import android.app.Application;

import com.ellen.lmydata.sql.AppLibrary;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        AppLibrary appLibrary = new AppLibrary(this,"lmy_sql_library",1);

        //初始化
        LmyEmulator.getInstance().init(this);

        //配置登录接口模拟器
        LmyEmulator.getInstance().addHttpsEmulator(new LoginHttpsEmulator(appLibrary));
    }
}
