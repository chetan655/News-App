package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView newsFeedRv, newsMainRv;
    LinearLayoutManager newsFeedLinearLayoutManager, newsMainLinearLayoutManager;

    newsFeedRecyclerView myNewsFeedAdapter;
    mainNewsRecyclerView myMainNewsAdapter;
    TextView newsFeedTextView, newsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsFeedTextView = findViewById(R.id.newsFeedTextView);
        newsTextView = findViewById(R.id.newsTextView);

        newsFeedTextView.setText("TOP NEWS CHANNELS");
        newsTextView.setText("NEWS");

        List<mainNews> dataSource = new ArrayList<>();

        dataSource.add(new mainNews(R.drawable.abc, "ABC NEWS"));
        dataSource.add(new mainNews(R.drawable.nine_news, "9 NEWS"));
        dataSource.add(new mainNews(R.drawable.seven_news, "7 NEWS"));
        dataSource.add(new mainNews(R.drawable.sbs, "SBS NEWS"));


        //news feed recycler view
        newsFeedRv = findViewById(R.id.newsFeedRecyclerView);
        newsFeedRv.setHasFixedSize(true);
        newsFeedLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        myNewsFeedAdapter = new newsFeedRecyclerView(dataSource);
        newsFeedRv.setLayoutManager(newsFeedLinearLayoutManager);
        newsFeedRv.setAdapter(myNewsFeedAdapter);

        //news main recycler view

        List<mainNews> mainNewsList = new ArrayList<>();

        mainNewsList.add(new mainNews(R.drawable.abc, "Craft alcohol producers the focus of Coalition tourism grants promise"));
        mainNewsList.add(new mainNews(R.drawable.nine_news, "Ukrainian woman sees glimmer of hope in the rubble of her home"));
        mainNewsList.add(new mainNews(R.drawable.seven_news, "Cloud hangs over Kings victory in NBL grand final series opener"));
        mainNewsList.add(new mainNews(R.drawable.sbs, "SA police search for golf club used in alleged attempted murder"));


        newsMainRv = findViewById(R.id.newsRecyclerView);
        newsMainRv.setHasFixedSize(true);
        newsMainLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        myMainNewsAdapter = new mainNewsRecyclerView(mainNewsList);
        newsMainRv.setLayoutManager(newsMainLinearLayoutManager);
        newsMainRv.setAdapter(myMainNewsAdapter);


    }

    public void selectFragment(View view) {
        Fragment fragment;
        if (view.getId() == R.id.newsFeedRecyclerView) {
            fragment = new newsFragment();
        } else {
            throw new IllegalStateException("Unexpected value: " + view.getId());
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
                .commit();
    }
}