package com.example.newsapp;

public class mainNews {
    private int image;
    private String news;

    public mainNews(int image, String news){
        this.image = image;
        this.news = news;
    }

    public int getImage() {
        return image;
    }

    public String getNews() {
        return news;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setNews(String news) {
        this.news = news;
    }
}
