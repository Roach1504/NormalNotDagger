package com.example.android.normalnotdagger.ui.commits;


import com.example.android.normalnotdagger.models.new_model.comments.Comment;

import java.util.List;

public interface ComentsMVP {
    void showComments(List<Comment> comments);
    void showError();
    void showIsEmpty();
    void startProgresBar();
    void stopProgresBar();
}
