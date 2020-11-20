package com.ellen.lmydata;

import com.google.gson.Gson;

public class LoginHttpsEmulator implements LmyHttpsEmulator {

    @Override
    public String url() {
        return "https://www.chen.com";
    }

    @Override
    public RequestParams.RequestType type() {
        return RequestParams.RequestType.Get;
    }

    @Override
    public String json(RequestParams requestParams) {
        Gson gson = new Gson();
        LoginBean loginBean = new LoginBean();
        loginBean.setCode(200);
        loginBean.setImgUrl("https://123405/ellen/jtk.jpg");
        loginBean.setUserName("Ellen2020");
        loginBean.setMessage("登录成功!");
        return gson.toJson(loginBean);
    }

}
