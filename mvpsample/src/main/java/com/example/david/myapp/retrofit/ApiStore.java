package com.example.david.myapp.retrofit;

import com.example.david.myapp.model.MainModel;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by androie on 2016/9/12.
 */
public interface ApiStore {
    @POST("zftwq/app/get/getUseInf.do")
    Observable<MainModel> getData(@Query("token") String token, @Query("currentPage") int currentPate);
}
