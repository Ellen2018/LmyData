package com.ellen.lmydata;

import android.app.Application;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //配置登录接口模拟器
        LmyEmulator.getInstance().addHttpsEmulator(new LoginHttpsEmulator());
    }
}
