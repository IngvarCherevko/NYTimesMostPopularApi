package com.ingvar.just01;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.ingvar.just01.adapter.NewsAdapter;

public class NewsDetaile extends AppCompatActivity {

    TextView titleNews;
    TextView newsText;
    TextView publishData;
    //ImageView newsImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity);

        titleNews = (TextView) findViewById(R.id.title_news);
        newsText = (TextView) findViewById(R.id.news_text);
        publishData = (TextView) findViewById(R.id.publish_date);
       // newsImage = (ImageView) findViewById(R.id.news_image);

        titleNews.setText(getIntent().getStringExtra(Constant.newsTitle));
        publishData.setText(getIntent().getStringExtra(Constant.publishData));
        newsText.setText(getIntent().getStringExtra(Constant.abstractText));

    }
}
