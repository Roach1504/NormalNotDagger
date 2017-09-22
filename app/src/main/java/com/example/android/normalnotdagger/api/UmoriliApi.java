package com.example.android.normalnotdagger.api;



import com.example.android.normalnotdagger.models.new_model.comments.ComentsListModel;
import com.example.android.normalnotdagger.models.new_model.news.NewsModel;
import com.example.android.normalnotdagger.models.new_model.registr.RegistModel;
import com.example.android.normalnotdagger.models.new_model.status.StatusModel;
import com.example.android.normalnotdagger.models.new_model.user_info.UserModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface UmoriliApi {

    @GET("api/get-posts")
    Call<NewsModel> getData(@Query("limit") String limit,
                            @Query("offset") int offset,
                            @Query("user_id") String user_id);//полдучения\ постов

    @GET("/api/set-mark")
    Call<StatusModel> addLike(@Query("id") String id,
                              @Query("post_id") String post_id,
                              @Query("mark") int mark);//установка лайка

    @GET("/api/set-view")
    Call<StatusModel> addView(@Query("id") String id,
                              @Query("post_id") String post_id);//установка просмотра

    @GET("/api/sign-up")
    Call<RegistModel> getRegist(@Query("login") String login,
                                @Query("pass") String pass,
                                @Query("name") String name,
                                @Query("family") String family,
                                @Query("city") String city,
                                @Query("tel") String tel);//регистрация

    @GET("/api/user-info")
    Call<UserModel> getUserInfo(@Query("id") String id); //информация о пользователе

    @GET("/api/sign-in")
    Call<RegistModel> getAvtor(@Query("login") String login,
                               @Query("pass") String pass); //авторизация

    @GET("/api/get-comments")
    Call<ComentsListModel> getComments(@Query("post_id") String post_id);  //выгрузка коментов


    //добпавления коментариев
    //создание новости
    //удаления поста
    //лента подписок
    //отправка сообщения
    //выгрузка сообщений


    //добавление подписка
    //удаление подписки

}
