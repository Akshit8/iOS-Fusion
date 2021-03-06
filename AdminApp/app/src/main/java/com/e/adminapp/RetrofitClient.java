package com.e.adminapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private final static String BASE_URL = "https://adg-events.herokuapp.com/";
    private static RetrofitClient retrofitClient;
    private Retrofit retrofit;

    private RetrofitClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance()
    {
        if(retrofitClient == null)
        {
            retrofitClient = new RetrofitClient();
        }
        return retrofitClient;
    }

    public API getAPI()
    {
        return retrofit.create(API.class);
    }

}
