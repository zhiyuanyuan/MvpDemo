package com.zhiyuan.mvpdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zhiyuan.mvpdemo.mvp.presenter.BasePresenter;

/**
 * Created by admin on 2017/11/29.
 */

public abstract class MvpActivity<P extends BasePresenter> extends BaseActivity {
      protected  P  mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter =createPresenter();
        super.onCreate(savedInstanceState);

    }

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null){
            mPresenter.detachView();
        }
    }
}
