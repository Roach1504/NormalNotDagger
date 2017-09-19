package com.example.android.normalnotdagger.models.new_model;


import java.util.List;

public interface NewsMVP {
    void showNews(List<News> posts);
    void showError();
    void showIsEmpty();
}
