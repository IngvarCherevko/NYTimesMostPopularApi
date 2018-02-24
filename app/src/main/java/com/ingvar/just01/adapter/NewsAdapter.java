package com.ingvar.just01.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ingvar.just01.Constant;
import com.ingvar.just01.NewsDetaile;
import com.ingvar.just01.R;
import com.ingvar.just01.ViewHolder.ListResultViewHolder;
import com.ingvar.just01.inteface.ItemClickListener;
import com.ingvar.just01.model.News;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<ListResultViewHolder> {



    private Context context;
    private List<News> newsList;

    public NewsAdapter(Context context, List<News> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    @Override
    public ListResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.source_layout, parent, false);
        return new ListResultViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ListResultViewHolder holder, int position) {
        holder.news = newsList.get(position);
        holder.title.setText(newsList.get(position).getTitle());
        holder.shortNews.setText(newsList.get(position).getAbstractText());
     /* Picasso.with(context)
                    .load(newsList.get(position).getMediaList().get(0).getMediaMetadataList().get(0).getUrl())
                    .into(holder.imageView);
        }*/
     holder.setItemClickListener(new ItemClickListener() {
         @Override
         public void onClick(View view, int position, boolean isLongClick) {
             Intent intent = new Intent(context, NewsDetaile.class);
             intent.putExtra(Constant.newsTitle, holder.title.getText());
             intent.putExtra(Constant.publishData, holder.news.getPublishedDate());
             intent.putExtra(Constant.abstractText, holder.shortNews.getText());
             context.startActivities(new Intent[]{intent});
         }
     });
    }


    @Override
    public int getItemCount() {
        if (newsList == null) {
            return 0;
        }
        return newsList.size();
    }

}
