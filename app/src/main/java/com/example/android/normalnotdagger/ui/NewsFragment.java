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
import com.example.android.normalnotdagger.models.new_model.NewsModel;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NewsFragment extends Fragment{
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

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        l = new ArrayList<>();
        l.add("1");
        l.add("2");
        l.add("3");
        l.add("4");
        l.add("5");

        newsAdapter = new NewsAdapter2(l);
        recyclerView.setAdapter(newsAdapter);



        App.getApi().getData("2", "0", "1").enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                Log.e("sizeTest", response.body().getNews().size() + "test");
                posts = response.body().getNews();
               // posts.addAll(posts);
                newsAdapter = new NewsAdapter2(l);

                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {
                Log.e("error", t.getMessage());
                Toast.makeText(getActivity(), "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });



        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
