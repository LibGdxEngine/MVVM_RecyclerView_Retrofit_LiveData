package com.devahmed.mvvm_recyclerview_retrofit_livedata.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.devahmed.mvvm_recyclerview_retrofit_livedata.Models.PostModel;
import com.devahmed.mvvm_recyclerview_retrofit_livedata.R;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostsViewHolder> {

    private List<PostModel> PostModelsList;

    public PostAdapter(List<PostModel> PostModelsList) {
        this.PostModelsList = PostModelsList;
    }

    @Override
    public PostsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_item, parent, false);

        return new PostsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PostsViewHolder holder, int position) {
        PostModel model = PostModelsList.get(position);
        holder.textView.setText(model.getBody());
    }

    public void setList(List<PostModel> newList){
        PostModelsList = newList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return PostModelsList.size();
    }

    public class PostsViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public PostsViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.body);
        }
    }
}