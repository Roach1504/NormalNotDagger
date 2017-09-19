package com.example.android.normalnotdagger.ui;


import com.example.android.normalnotdagger.models.new_model.News;

import java.util.List;

public interface NewsMVP {
    void showNews(List<News> posts);
    void showError();
    void showIsEmpty();
}
