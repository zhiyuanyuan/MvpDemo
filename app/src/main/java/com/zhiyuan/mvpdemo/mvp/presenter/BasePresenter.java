package com.zhiyuan.mvpdemo.mvp.presenter;

import com.zhiyuan.mvpdemo.api.ApiManager;
import com.zhiyuan.mvpdemo.api.ApiService;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by admin on 2017/11/29.
 */

public class BasePresenter<V> {
          public  V view;
          private CompositeSubscription mCompositeSubscription;
          protected ApiService mApiService;

          public void attachView(V view){
              this.view=view;
              mApiService= ApiManager.getApiService();
          }

          public void  detachView(){
              this.view=null;
              onUnsubsribe();
          }

    private void onUnsubsribe() {
        if(mCompositeSubscription!=null&&mCompositeSubscription.hasSubscriptions()){
            mCompositeSubscription.unsubscribe();
        }
    }

    public void addSubscription(Subscriber subscriber, Observable observable){
              if(mCompositeSubscription==null){
                  mCompositeSubscription=new CompositeSubscription();
              }
              mCompositeSubscription.add(observable.subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber)
              );

    }
}
