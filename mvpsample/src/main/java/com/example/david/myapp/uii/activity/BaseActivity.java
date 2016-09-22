package com.example.david.myapp.uii.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.david.myapp.R;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by androie on 2016/9/12.
 */
public class BaseActivity extends AppCompatActivity{
    private CompositeSubscription subscription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onUnSubscriber();
    }

    private void onUnSubscriber() {
        if (subscription != null && subscription.hasSubscriptions()){
            subscription.unsubscribe();
        }
    }

    public void addSubscription(Subscription subscriptione){
        subscription = new CompositeSubscription();
        subscription.add(subscriptione);
    }

    public Toolbar initToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.finishAfterTransition(BaseActivity.this);
            }
        });
        return toolbar;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                super.onBackPressed();//返回
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
