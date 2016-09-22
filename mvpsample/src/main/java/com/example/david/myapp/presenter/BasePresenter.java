package com.example.david.myapp.presenter;

import com.example.david.myapp.retrofit.ApiStore;
import com.example.david.myapp.retrofit.AppClient;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by androie on 2016/9/12.
 */
public class BasePresenter<V> implements Presenter<V> {
    public V view;
    public ApiStore apiStore = AppClient.getRetrofit().create(ApiStore.class);
    private CompositeSubscription subscription;

    @Override
    public void destoryView() {
        this.view = null;
        onUnSubscribe();
    }

    //注销rxjava，以免内存泄漏
    private void onUnSubscribe() {
        if (subscription != null && subscription.hasSubscriptions()){
            subscription.unsubscribe();
        }
    }

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    public void addSubscription(Observable observable, Subscriber subscriber){
        if (subscription == null){
            subscription = new CompositeSubscription();
        }
        subscription.add((Subscription) observable.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(subscriber));
    }
}
