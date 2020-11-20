package com.ellen.lmydata;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 */
public class LmyData {
    /**
     * 请求参数
     */
    private volatile RequestParams requestParams;

    public LmyData setRequestParams(RequestParams requestParams) {
        this.requestParams = requestParams;
        return this;
    }

    /**
     * 发起同步请求
     */
    public void startSynchronizeRequest(Callback callback){
        //这里网路请求是发生在子线程中的
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);

        fixedThreadPool.submit(new Runnable() {
            @Override
            public void run() {
                LmyHttpsEmulator lmyHttpsEmulator = LmyEmulator.getInstance().findLmyHttpsEmulator(requestParams);
                if(lmyHttpsEmulator == null){
                    callback.onError("您没有配置对应的Https接口："+requestParams.getUrl());
                }else {
                    String json = lmyHttpsEmulator.json(requestParams);
                    ResponseBody responseBody = new ResponseBody();
                    responseBody.setCode(200);
                    responseBody.setBody(json);
                    callback.onSuccess(responseBody);
                }
            }
        });

    }

    /**
     * 请求回调
     */
    public interface Callback{
        void onSuccess(ResponseBody responseBody);
        void onError(String errorMessage);
    }
}
