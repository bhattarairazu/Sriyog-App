package com.example.manjil.sriyogapp.restapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Paru on 4/5/2018.
 */

public class apiclient {

    public static final String BASE_URL = "http://sriyog.com/api/register";
    public static Retrofit retrofit = null;
    public static Retrofit getApiclient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit;

    }
}
