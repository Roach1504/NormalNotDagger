package com.example.android.normalnotdagger.ui;


import android.util.Log;

import com.example.android.normalnotdagger.api.App;
import com.example.android.normalnotdagger.models.new_model.NewsModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsPresentr {
    NewsMVP mvp;
    public NewsPresentr(NewsMVP mvp){
        this.mvp = mvp;
    }

    public void loadNews(String user_id, String offset){
        App.getApi().getData("20", offset, user_id).enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                Log.e("sizeTest", response.body().getNews().get(0).getText() + "test");
                if(response.body().getNews().isEmpty()){

                }
                else{
                    mvp.showNews(response.body().getNews());
                }

                // posts.addAll(posts);
                //newsAdapter = new NewsAdapter2(l);


                //recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {
                Log.e("error", t.getMessage());
                mvp.showError();
                //Toast.makeText(getActivity(), "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
