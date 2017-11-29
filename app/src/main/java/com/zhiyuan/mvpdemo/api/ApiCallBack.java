package com.zhiyuan.mvpdemo.api;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by admin on 2017/11/29.
 */

public abstract class ApiCallBack<M> extends Subscriber<M> {

    public abstract void onSuccess(M model);
    public abstract void onFailure(String msg);
    public abstract void onFinish();

    @Override
    public void onCompleted() {
            onFinish();
    }

    @Override
    public void onError(Throwable e) {
         if(e instanceof HttpException){
             HttpException httpException= (HttpException)e;
             int code = httpException.code();
             String message = httpException.getMessage();
             if(code==504){
                 message="网络不给了";
             }
             if (code == 502 || code == 404) {
                 message = "服务器异常，请稍后再试";
             }
             onFailure(message);
         }else {
             onFailure(e.getMessage());
         }

         onFinish();
    }

    @Override
    public void onNext(M m) {
        onSuccess(m);
    }
}
