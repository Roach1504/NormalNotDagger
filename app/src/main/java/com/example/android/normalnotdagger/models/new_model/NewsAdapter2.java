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

    private List<String> posts;

    public NewsAdapter2(List<String> posts) {
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
        String post = posts.get(position);
        holder.dateTextView.setText(post);
        holder.autorTextView.setText(post);
        holder.headTextView.setText(post);
        holder.subTextView.setText(post);
        holder.viewsTextView.setText(post);
        holder.ratingTextView.setText(post);

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
