package com.example.david.myapp.rxjava;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by androie on 2016/9/12.
 */
public class SubscriberCallback<T> extends Subscriber<T> {
    private ApiCallback<T> apiCallback;

    public SubscriberCallback(ApiCallback<T> apiCallback){
        this.apiCallback = apiCallback;
    }

    @Override
    public void onCompleted() {
        apiCallback.onCompleted();
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof HttpException){
            HttpException exception = (HttpException) e;
            int code = exception.code();
            String msg = exception.getMessage();
            if (code == 504){
                msg = "网络错误";
            }
            apiCallback.onFailure(code, msg);
        }else {
            apiCallback.onFailure(0, e.getMessage());
        }
        apiCallback.onCompleted();
    }

    @Override
    public void onNext(T t) {
        apiCallback.onSuccess(t);
    }
}
