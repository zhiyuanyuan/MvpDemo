package com.zhiyuan.mvpdemo.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 2017/11/29.
 */

public class ApiManager {
    private Retrofit mRetrofit;
    private static final int DEFAULT_TIMEOUT=5;
    private static ApiManager apiManager;
    private static ApiService apiService;

     private ApiManager(){
         OkHttpClient.Builder builder=new OkHttpClient.Builder();
         builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
         OkHttpClient client = builder.build();
         mRetrofit=new Retrofit.Builder().baseUrl(ApiConstants.Urls.BASE_URL)
                 .addConverterFactory(GsonConverterFactory.create())
                 .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                 .client(client).build();
         apiService = mRetrofit.create(ApiService.class);
     }

     public static ApiService getApiService(){
         if(apiManager==null){
             apiManager=new ApiManager();
         }

         return apiService;
     }

}
