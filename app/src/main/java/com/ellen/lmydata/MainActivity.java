package com.ellen.lmydata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LmyData lmyData = new LmyData();

        //配置请求参数
        RequestParams requestParams = new RequestParams.Build()
                .setRequestType(RequestParams.RequestType.Get)
                .addPostFieldValue("user_account","ellen")
                .addPostFieldValue("user_password","123123")
                .setUrl("https://www.chen.com")
                .build();

        //开始发起同步请求
        lmyData.setRequestParams(requestParams)
                .startSynchronizeRequest(new LmyData.Callback() {
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