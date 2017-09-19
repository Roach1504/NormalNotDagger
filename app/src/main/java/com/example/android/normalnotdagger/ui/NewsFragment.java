package com.example.android.normalnotdagger.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.normalnotdagger.R;
import com.example.android.normalnotdagger.api.App;
import com.example.android.normalnotdagger.models.new_model.News;
import com.example.android.normalnotdagger.models.new_model.NewsAdapter2;
import com.example.android.normalnotdagger.models.new_model.NewsMVP;
import com.example.android.normalnotdagger.models.new_model.NewsModel;
import com.example.android.normalnotdagger.models.new_model.NewsPresentr;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NewsFragment extends Fragment implements NewsMVP{
    List<News> posts;
    List<String> l;
    RecyclerView recyclerView;
    NewsAdapter2 newsAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);


        posts = new ArrayList<>();

        NewsPresentr pr = new NewsPresentr(this);
        pr.loadNews("2","0");

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



        recyclerView.setAdapter(newsAdapter);





        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void showNews(List<News> posts) {
        Log.e("testPresentr", posts.get(0).getText());
        newsAdapter = new NewsAdapter2(posts);
        recyclerView.setAdapter(newsAdapter);
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void showError() {

        Toast.makeText(getActivity(), "An error occurred during networking", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showIsEmpty() {

    }
}
