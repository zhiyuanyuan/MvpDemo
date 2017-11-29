package com.zhiyuan.mvpdemo.mvp.view;

import com.zhiyuan.mvpdemo.bean.MainDataEntity;

/**
 * Created by admin on 2017/11/29.
 */

public interface MainView extends BaseView{
    void getDataSuccess(MainDataEntity model);
    void  getDataFail(String msg);
}
