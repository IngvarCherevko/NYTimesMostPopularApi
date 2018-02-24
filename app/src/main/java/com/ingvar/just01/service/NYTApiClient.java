package com.ingvar.just01.service;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.ingvar.just01.common.Common.BASE_URL;

public class NYTApiClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
