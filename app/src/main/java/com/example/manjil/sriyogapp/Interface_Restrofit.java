package com.example.manjil.sriyogapp;

import com.example.manjil.sriyogapp.Model.Model_notice_main;
import com.example.manjil.sriyogapp.Model.Model_post_data;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Paru on 4/5/2018.
 */

public interface Interface_Restrofit {

    @GET("getCategories")
    Call<Model_notice_main> mgetcategories();

    @GET("getWorkers")
    Call<Model_notice_main> mgetworkers();
    @POST("complaint")
    @FormUrlEncoded
    Call<Model_post_data> mpostfeedback(@Field("name") String name, @Field("phone") String phone, @Field("address") String address, @Field("sub") String sub, @Field("body") String body);

}
