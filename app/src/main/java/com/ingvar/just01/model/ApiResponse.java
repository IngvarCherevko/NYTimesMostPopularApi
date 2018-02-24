package com.ingvar.just01.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {
    @SerializedName("results")
    private List<News> newsList = null;

    public ApiResponse(List<News> newsList) {
        this.newsList = newsList;
    }


    public List<News> getNewsList() {
        return newsList;
    }
}
