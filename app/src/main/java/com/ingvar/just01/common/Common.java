package com.ingvar.just01.common;


import com.ingvar.just01.inteface.NYTApi;
import com.ingvar.just01.service.NYTApiClient;

public class Common {
    public static final String BASE_URL = "http://api.nytimes.com/svc/mostpopular/v2/";
    public static NYTApi getNYTApi() {
        return NYTApiClient.getClient().create(NYTApi.class);
    }
}
