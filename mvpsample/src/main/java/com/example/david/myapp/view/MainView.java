package com.example.david.myapp.view;

import android.widget.Button;
import android.widget.TextView;

import com.example.david.myapp.model.MainModel;

/**
 * Created by androie on 2016/9/12.
 */
public interface MainView {

    Button getButton();

    void failure(String msg);

    void getDatas(MainModel model);
}
