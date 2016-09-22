package com.example.david.myapp.presenter;

/**
 * Created by androie on 2016/9/12.
 */
public interface Presenter<V> {

    void destoryView();

    void attachView(V view);
}
