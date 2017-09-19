package com.example.android.normalnotdagger.api;



import com.example.android.normalnotdagger.models.new_model.NewsModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface UmoriliApi {

    @GET("api/get-posts")
    Call<NewsModel> getData(@Query("limit") String limit, @Query("offset") String offset, @Query("user_id") String user_id);
}
