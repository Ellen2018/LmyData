package com.ellen.lmydata;

import androidx.annotation.NonNull;

import java.util.Map;

/**
 * 请求参数(Post请求)
 */
public class RequestParams {

    /**
     * 存储字段类型 & 值(Post请求方式)
     */
    private Map<String,Object> postFieldValues;

    /**
     * 存储字段类型 & 值(Get请求方式)
     */
    private Map<String,Object> getFieldValues;

    /**
     * 请求的地址
     */
    private String url;

    /**
     * 请求的类型
     */
    private RequestType requestType;

    public Map<String, Object> getPostFieldValues() {
        return postFieldValues;
    }

    public void setPostFieldValues(Map<String, Object> postFieldValues) {
        this.postFieldValues = postFieldValues;
    }

    public Map<String, Object> getGetFieldValues() {
        return getFieldValues;
    }

    public void setGetFieldValues(Map<String, Object> getFieldValues) {
        this.getFieldValues = getFieldValues;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public static class Build{

        private Map<String,Object> postFieldValues;
        private Map<String,Object> getFieldValues;
        private String url;
        private RequestType requestType;

        public Build setUrl(@NonNull String url) {
            this.url = url;
            return this;
        }

        public Build get(Map<String, Object> fieldValues){
            getFieldValues = fieldValues;
            requestType = RequestType.GET;
            return this;
        }

        public Build post(@NonNull Map<String, Object> fieldValues){
            postFieldValues = fieldValues;
            requestType = RequestType.POST;
            return this;
        }

        public RequestParams build(){
            RequestParams requestParams = new RequestParams();
            requestParams.postFieldValues = postFieldValues;
            requestParams.getFieldValues = getFieldValues;
            requestParams.requestType = requestType;
            requestParams.url = url;
            return requestParams;
        }
    }


    enum RequestType{
        POST,
        GET;
    }
}
