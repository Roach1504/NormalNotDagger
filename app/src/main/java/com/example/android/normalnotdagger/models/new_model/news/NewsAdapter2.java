package com.example.android.normalnotdagger.models.new_model.news;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.android.normalnotdagger.R;
import java.util.List;

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
        holder.ratingTextView.setText(post.getMark().toString());

    }

    @Override
    public int getItemCount() {
        if (posts == null)
            return 0;
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView dateTextView;
        TextView autorTextView;
        TextView headTextView;
        TextView subTextView;
        TextView viewsTextView;
        TextView ratingTextView;



        public ViewHolder(View itemView) {
            super(itemView);
            dateTextView = (TextView) itemView.findViewById(R.id.textDate);
            autorTextView = (TextView) itemView.findViewById(R.id.textAutor);
            headTextView = (TextView) itemView.findViewById(R.id.head);
            subTextView = (TextView) itemView.findViewById(R.id.subtitle);
            viewsTextView = (TextView) itemView.findViewById(R.id.views);
            ratingTextView = (TextView) itemView.findViewById(R.id.rating);
        }
    }
}
