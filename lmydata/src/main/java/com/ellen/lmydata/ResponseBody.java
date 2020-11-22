package com.ellen.lmydata;

public class ResponseBody {
    private int code;
    /**
     * 数据实体
     */
    private String body;

    public int code() {
        return code;
    }

    void setCode(int code) {
        this.code = code;
    }

    public String body() {
        return body;
    }

    void setBody(String body) {
        this.body = body;
    }
}
