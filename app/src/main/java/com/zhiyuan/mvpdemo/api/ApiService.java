package com.zhiyuan.mvpdemo.api;

import com.zhiyuan.mvpdemo.bean.MainDataEntity;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by admin on 2017/11/29.
 */

public interface ApiService {
    @GET(ApiConstants.Urls.BROADCAST)
    Observable<MainDataEntity> getBroadCast();
}
