package com.ellen.lmydata;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据生产模拟器
 */
public class LmyEmulator {

    private volatile static LmyEmulator instance;
    private volatile List<LmyHttpsEmulator> lmyHttpsEmulatorList;
    private SharePreferenceHelper sharePreferenceHelper;

    private LmyEmulator(){}

    public static LmyEmulator getInstance(){
        if(instance == null){
            synchronized (LmyEmulator.class){
                if(instance == null){
                    instance = new LmyEmulator();
                    instance.lmyHttpsEmulatorList = new ArrayList<>();
                }
            }
        }
        return instance;
    }

    public void init(Context context){
        sharePreferenceHelper = new SharePreferenceHelper(context,"lmy_key_value_save");
    }

    public LmyEmulator addHttpsEmulator(LmyHttpsEmulator lmyHttpsEmulator){
        lmyHttpsEmulatorList.add(lmyHttpsEmulator);
        lmyHttpsEmulator.initData(sharePreferenceHelper.getValue(lmyHttpsEmulator.url(),false));
        sharePreferenceHelper.save(lmyHttpsEmulator.url(),true);
        return this;
    }

    public LmyEmulator removeHttpsEmulator(LmyHttpsEmulator lmyHttpsEmulator){
        lmyHttpsEmulatorList.remove(lmyHttpsEmulator);
        sharePreferenceHelper.deleteKey(lmyHttpsEmulator.url());
        return this;
    }

    public LmyHttpsEmulator findLmyHttpsEmulator(RequestParams requestParams){
        LmyHttpsEmulator result = null;
        for(LmyHttpsEmulator lmyHttpsEmulator:lmyHttpsEmulatorList){
            if(requestParams.getUrl().contains(lmyHttpsEmulator.url())){
                //匹配上了
                result = lmyHttpsEmulator;
                break;
            }
        }
        return result;
    }
}
