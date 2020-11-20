package com.ellen.lmydata;

public interface LmyHttpsEmulator {

    String url();
    RequestParams.RequestType type();
    String json(RequestParams requestParams);

}
