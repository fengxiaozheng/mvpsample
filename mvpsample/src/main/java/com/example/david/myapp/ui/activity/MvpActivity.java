package com.example.david.myapp.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.david.myapp.presenter.BasePresenter;

/**
 * Created by androie on 2016/9/12.
 */
public abstract class MvpActivity<P extends BasePresenter> extends BaseActivity {
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
    }

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null){
            presenter.destoryView();
        }
    }
}
