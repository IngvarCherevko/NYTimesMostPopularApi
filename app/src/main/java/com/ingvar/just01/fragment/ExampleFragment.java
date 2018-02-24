package com.ingvar.just01.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ingvar.just01.R;
import com.ingvar.just01.adapter.NewsAdapter;
import com.ingvar.just01.common.Common;
import com.ingvar.just01.inteface.NYTApi;
import com.ingvar.just01.model.ApiResponse;
import com.ingvar.just01.model.News;

import java.util.List;

import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExampleFragment extends Fragment {

    private static final String API_KEY = "2a6e86720250427ca9101f8d413e4fad";

    RecyclerView listResults;
    SwipeRefreshLayout swipeRefreshLayout;
    NewsAdapter adapter;
    List<News> newsList;

    String nameTab;
    String type;
    private View view;
    private String title;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getType(nameTab);
        loadNews();
    }

    private void loadNews() {
        NYTApi api = Common.getNYTApi();
        Call<ApiResponse> call = api.getResult(type, "all-sections", 7, API_KEY);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                newsList = response.body().getNewsList();
                listResults.setAdapter(new NewsAdapter(getActivity(), newsList));
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_layout, container, false);
        Paper.init(getContext());
        listResults = (RecyclerView) view.findViewById(R.id.list_source);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        listResults.setLayoutManager(layoutManager);
        adapter = new NewsAdapter(getActivity(), newsList);
        listResults.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadNews();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }


    public void addTitle(String title) {
        this.title = title;
        nameTab = title;
    }

    public String getNameTab() {
        return nameTab;
    }

    public String getType(String nameTab) {
        StringBuilder st = new StringBuilder();
        st.append(nameTab);
        st.deleteCharAt(4);
        return st.toString();

    }
}
