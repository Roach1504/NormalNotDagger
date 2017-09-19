package com.example.android.normalnotdagger.models.new_model;


import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.normalnotdagger.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsAdapter2 extends RecyclerView.Adapter<NewsAdapter2.ViewHolder>{

    private List<News> posts;

    public NewsAdapter2(List<News> posts) {
        this.posts = posts;
        Log.e("Test", "adapter "+this.posts.size());
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        Log.e("Test", "adapter"+posts.size());
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        News post = posts.get(position);
        holder.dateTextView.setText(post.getDate());
        holder.autorTextView.setText(post.getUserLogin());
        holder.headTextView.setText(post.getTitle());
        holder.subTextView.setText(post.getShort());
        holder.viewsTextView.setText(post.getViews());
        holder.ratingTextView.setText(post.getMark());

    }

    @Override
    public int getItemCount() {
        if (posts == null)
            return 0;
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textDate)
        TextView dateTextView;
        @BindView(R.id.textAutor)
        TextView autorTextView;
        @BindView(R.id.head)
        TextView headTextView;
        @BindView(R.id.subtitle)
        TextView subTextView;
        @BindView(R.id.views)
        TextView viewsTextView;
        @BindView(R.id.rating)
        TextView ratingTextView;
        @BindView(R.id.layout)
        View layout;



        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
