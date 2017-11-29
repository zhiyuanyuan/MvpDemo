package com.zhiyuan.mvpdemo.activity;

import android.os.Bundle;
import android.widget.Toast;

import com.zhiyuan.mvpdemo.R;
import com.zhiyuan.mvpdemo.bean.MainDataEntity;
import com.zhiyuan.mvpdemo.mvp.presenter.MainPresenter;
import com.zhiyuan.mvpdemo.mvp.view.MainView;

import java.util.List;

public class MainActivity extends MvpActivity<MainPresenter> implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter.loadData();
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void getDataSuccess(MainDataEntity model) {
        StringBuilder stringBuilder = new StringBuilder();
        List<MainDataEntity.DataBean.CategoriesBean> list = model.getData().getCategories();
        for(int i=0;i<list.size();i++){
            stringBuilder.append(list.get(i).getName() + "  ");
        }
        Toast.makeText(getApplicationContext(),stringBuilder.toString(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void getDataFail(String msg) {

    }
}
