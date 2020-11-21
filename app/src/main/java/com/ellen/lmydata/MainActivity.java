package com.ellen.lmydata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LmyData lmyData = new LmyData();

        Map<String,Object> map = new HashMap<>();
        map.put("account","ellen1");
        map.put("password","2");

        //配置请求参数
        RequestParams requestParams = new RequestParams.Build()
                .setUrl("https://www.chen.com?account=ellen&pawwsord=123456")
                .post(map)//请求方式为get
                .build();

        //开始发起同步请求
        lmyData.setRequestParams(requestParams)
                .startRequest(new LmyData.Callback() {
            @Override
            public void onSuccess(ResponseBody responseBody) {
                //请求成功
                if(responseBody.code() == 200){
                    String json = responseBody.body();
                    //解析Json
                    Log.e("Ellen2018","请求的数据:"+json);
                }
            }

            @Override
            public void onError(String errorMessage) {
                 //请求失败
                Log.e("Ellen2018","请求失败:"+errorMessage);
            }
        });
    }
}