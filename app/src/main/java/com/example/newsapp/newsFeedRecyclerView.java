package com.example.newsapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class newsFeedRecyclerView extends RecyclerView.Adapter<newsFeedRecyclerView.myViewHolder>{

    private List<mainNews> data;

    public newsFeedRecyclerView(List<mainNews> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public newsFeedRecyclerView.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_feed_layout, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull newsFeedRecyclerView.myViewHolder holder, int position) {
        holder.newsFeedText.setText(data.get(position).getNews());
        holder.newsFeedImage.setImageResource(data.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView newsFeedText;
        ImageView newsFeedImage;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            newsFeedText = itemView.findViewById(R.id.newsTextView);
            newsFeedImage = itemView.findViewById(R.id.newsFeedImage);
        }
    }
}
