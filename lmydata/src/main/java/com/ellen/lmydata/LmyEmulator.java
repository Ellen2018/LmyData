package com.ellen.lmydata;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据生产模拟器
 */
public class LmyEmulator {

    private volatile static LmyEmulator instance;
    private volatile List<LmyHttpsEmulator> lmyHttpsEmulatorList;

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

    public LmyEmulator addHttpsEmulator(LmyHttpsEmulator lmyHttpsEmulator){
        lmyHttpsEmulatorList.add(lmyHttpsEmulator);
        return this;
    }

    public LmyEmulator removeHttpsEmulator(LmyHttpsEmulator lmyHttpsEmulator){
        lmyHttpsEmulatorList.remove(lmyHttpsEmulator);
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
