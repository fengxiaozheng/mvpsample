package com.example.david.myapp.uii.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.david.myapp.R;

import butterknife.ButterKnife;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by androie on 2016/9/22.
 */

public class BaseFragment extends Fragment {
    public Activity activity;
    private CompositeSubscription compositeSubscription;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        activity = getActivity();
    }

    public Toolbar initToolBar(View view, String title){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        TextView textView = (TextView) toolbar.findViewById(R.id.textview);
        textView.setText(title);
        return toolbar;
    }

    public void toastShow(int resId) {
        Toast.makeText(activity, resId, Toast.LENGTH_SHORT).show();
    }

    public void toastShow(String resId) {
        Toast.makeText(activity, resId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        onUnsubscribe();
    }

    public void onUnsubscribe(){
        //取消注册，避免内存泄露
        if (compositeSubscription != null){
            compositeSubscription.unsubscribe();
        }
    }

    public void addSubscription(Subscription subscription){
        compositeSubscription = new CompositeSubscription();
        compositeSubscription.add(subscription);
    }
}
