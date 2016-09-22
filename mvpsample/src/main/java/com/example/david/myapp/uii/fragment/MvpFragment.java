package com.example.david.myapp.uii.fragment;

import android.os.Bundle;
import android.view.View;

import com.example.david.myapp.presenter.BasePresenter;

/**
 * Created by androie on 2016/9/22.
 */

public abstract class MvpFragment<P extends BasePresenter> extends BaseFragment {
    protected P presenter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = createPresenter();
    }

    protected abstract P createPresenter();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null){
            presenter.destoryView();
        }
    }
}
