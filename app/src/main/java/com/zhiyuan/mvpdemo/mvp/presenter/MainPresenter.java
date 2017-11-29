package com.zhiyuan.mvpdemo.mvp.presenter;

import com.zhiyuan.mvpdemo.api.ApiCallBack;
import com.zhiyuan.mvpdemo.bean.MainDataEntity;
import com.zhiyuan.mvpdemo.mvp.view.MainView;

/**
 * Created by admin on 2017/11/29.
 */

public class MainPresenter extends BasePresenter<MainView> {
    public MainPresenter(MainView mainView){
        attachView(mainView);
    }

    public void loadData(){
        view.showLoading();
        addSubscription(new ApiCallBack<MainDataEntity>() {
            @Override
            public void onSuccess(MainDataEntity model) {
                view.hideLoading();
                view.getDataSuccess(model);
            }

            @Override
            public void onFailure(String msg) {
                 view.getDataFail(msg);
            }

            @Override
            public void onFinish() {
                view.hideLoading();
            }
        }, mApiService.getBroadCast());
    }
}
