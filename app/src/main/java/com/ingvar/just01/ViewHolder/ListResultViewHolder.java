package com.ingvar.just01.ViewHolder;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ingvar.just01.R;
import com.ingvar.just01.inteface.ItemClickListener;
import com.ingvar.just01.model.News;

public class ListResultViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ItemClickListener itemClickListener;

    public TextView title;
    public TextView shortNews;
    public News news;

    public ListResultViewHolder(View itemView) {
        super(itemView);

        title = (TextView) itemView.findViewById(R.id.news_title);
        shortNews = (TextView) itemView.findViewById(R.id.short_news);

        itemView.setOnClickListener(this);
    }


    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition(), false);
    }
}
