package com.example.david.myapp.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.david.myapp.R;
import com.example.david.myapp.bean.WeatherInfo;
import com.example.david.myapp.model.MainModel;
import com.example.david.myapp.presenter.MainPresenter;
import com.example.david.myapp.view.MainView;

public class MainActivity extends MvpActivity<MainPresenter> implements MainView {

   private Button button;
   private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textview);
        button = (Button) findViewById(R.id.button);
        presenter.getData();
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public Button getButton() {
        return button;
    }

    @Override
    public void failure(String msg) {
        Toast.makeText(this, msg+"错误",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getDatas(MainModel model) {
        WeatherInfo info = model.getWeatherinfo();
        String ss = info.getCity();
        textView.setText(ss);
    }
}
