package com.ashish.newstoday;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsRVAdapter extends RecyclerView.Adapter<NewsRVAdapter.ViewHolder>{
    private ArrayList<Articles> articlesArrayList;
    private Context context;

    NewsRVAdapter(ArrayList<Articles> articlesArrayList, Context context){
        this.articlesArrayList = articlesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_rv_item, parent, false);
        return new NewsRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsRVAdapter.ViewHolder holder, int position) {
        Articles articles = articlesArrayList.get(position);
        holder.titleTV.setText(articles.getTitle());
        holder.SubTitleTV.setText(articles.getDescription());

        Log.d("Image_URL", "ImageUrl"+articles.getUrlToImage());
        Log.d("News_URL", "NewsUrl" + articles.getUrl());

        if (articles.getUrlToImage() != null && !articles.getUrlToImage().isEmpty()) {
            Picasso.get().load(articles.getUrl()).placeholder(R.drawable.baseline_autorenew_24).error(R.drawable.baseline_newspaper_24).into(holder.newsIV);
        } else {
            holder.newsIV.setImageResource(R.drawable.baseline_newspaper_24);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, NewsDetailActivity.class);
                i.putExtra("title", articles.getTitle());
                i.putExtra("desc", articles.getDescription());
                i.putExtra("Image", articles.getUrlToImage());
                Log.d("Image_URL_BTN", "ImageUrl"+ articles.getUrlToImage());
                i.putExtra("url", articles.getUrl());
                Log.d("News_URL_BTN", "NewsUrl" + articles.getUrl());
                i.putExtra("content", articles.getContents());
                context.startActivity(i);
            }
        });
    }
    @Override
    public int getItemCount() {
        return articlesArrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView newsIV;
        private TextView titleTV, SubTitleTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.idTVHeading);
            SubTitleTV = itemView.findViewById(R.id.idTVSubHeading);
            newsIV = itemView.findViewById(R.id.idIVNews);
        }
    }
}


