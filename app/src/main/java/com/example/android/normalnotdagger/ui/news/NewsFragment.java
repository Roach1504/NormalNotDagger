package com.example.android.normalnotdagger.ui.news;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
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
import com.example.android.normalnotdagger.models.new_model.news.News;



import java.util.ArrayList;
import java.util.List;




public class NewsFragment extends Fragment implements NewsMVP{
    List<News> posts;
    List<String> l;
    RecyclerView recyclerView;
    NewsAdapter newsAdapter;
    NewsPresentr pr;
    SharedPreferences user;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);

        user = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);

        posts = new ArrayList<>();

        pr = new NewsPresentr(this);
        pr.loadNews("1",0);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(newsAdapter);
        return recyclerView;
    }

    @Override
    public void showNews(List<News> posts) {
        List<News> postsNull = new ArrayList<>();
        Log.e("testPresentr", posts.get(0).getText());
        newsAdapter = new NewsAdapter(postsNull, pr, user);
        newsAdapter.addPosts(posts);
        recyclerView.setAdapter(newsAdapter);
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void showError() {
        Toast.makeText(getActivity(), "Ошибка соеденения с интернетом", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showIsEmpty() {
        Toast.makeText(getActivity(), "Новостей нет", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addLike() {
       // Toast.makeText(getActivity(), "Add like", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addLikeError(String res) {
        Toast.makeText(getActivity(), res,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startProgresBar() {
        //запустить прогрес бар
    }

    @Override
    public void stopProgresBar() {
        //остановить прогрес бар
    }

}
