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

public class mainNewsRecyclerView extends RecyclerView.Adapter<mainNewsRecyclerView.myNewsViewHolder>{

    private List<mainNews> data;

    public mainNewsRecyclerView(List<mainNews> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public mainNewsRecyclerView.myNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_layout, parent, false);
        return new myNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mainNewsRecyclerView.myNewsViewHolder holder, int position) {
        holder.newsMainText.setText(data.get(position).getNews());
        holder.newsMainImage.setImageResource(data.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class myNewsViewHolder extends RecyclerView.ViewHolder{
        TextView newsMainText;
        ImageView newsMainImage;

        public myNewsViewHolder(@NonNull View itemView) {
            super(itemView);
            newsMainText = itemView.findViewById(R.id.newsMainTextView);
            newsMainImage = itemView.findViewById(R.id.newsMainImage);
        }
    }
}
