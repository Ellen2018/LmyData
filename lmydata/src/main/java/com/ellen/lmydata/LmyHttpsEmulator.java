package com.ellen.lmydata;

public interface LmyHttpsEmulator {

    /**
     * 初始化数据库数据
     */
    void initData();

    String url();

    RequestParams.RequestType type();

    String json(RequestParams requestParams);

}
