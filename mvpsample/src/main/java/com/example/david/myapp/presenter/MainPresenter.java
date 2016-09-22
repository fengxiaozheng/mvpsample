package com.example.david.myapp.presenter;

import android.view.View;

import com.example.david.myapp.model.MainModel;
import com.example.david.myapp.rxjava.ApiCallback;
import com.example.david.myapp.rxjava.SubscriberCallback;
import com.example.david.myapp.view.MainView;

/**
 * Created by androie on 2016/9/12.
 */
public class MainPresenter extends BasePresenter<MainView> {

    public MainPresenter(MainView view){
        attachView(view);
    }

    public void getData(){
        view.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goData();
            }
        });
    }

    private void goData(){
        addSubscription(apiStore.getData("8980ccbd-450a-47e3-8b6e-4a89a9d1ac26",0),
                new SubscriberCallback<>(new ApiCallback<MainModel>() {

                    @Override
                    public void onSuccess(MainModel model) {
                        System.out.println("sssssssssss11111"+model.getData().getUserName());
                        view.getDatas(model);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        System.out.println("sssssssssss22222"+code);
                        view.failure(msg);
                    }

                    @Override
                    public void onCompleted() {
                        System.out.println("sssssssssss33333");
                    }
                }));
    }
}
