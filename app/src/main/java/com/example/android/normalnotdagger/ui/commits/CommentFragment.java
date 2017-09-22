package com.example.android.normalnotdagger.ui.commits;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.normalnotdagger.models.new_model.comments.Comment;

import java.util.List;

public class CommentFragment extends Fragment implements ComentsMVP{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void showComments(List<Comment> comments) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showIsEmpty() {

    }

    @Override
    public void startProgresBar() {

    }

    @Override
    public void stopProgresBar() {

    }
}
