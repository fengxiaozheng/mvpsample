package com.example.david.myapp.rxjava;

/**
 * Created by androie on 2016/9/12.
 */
public interface ApiCallback<T> {

    void onSuccess(T model);

    void onFailure(int code, String msg);

    void onCompleted();
}
