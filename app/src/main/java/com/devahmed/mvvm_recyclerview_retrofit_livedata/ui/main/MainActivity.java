package com.devahmed.mvvm_recyclerview_retrofit_livedata.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.devahmed.mvvm_recyclerview_retrofit_livedata.Adapters.PostAdapter;
import com.devahmed.mvvm_recyclerview_retrofit_livedata.Adapters.RecyclerTouchListener;
import com.devahmed.mvvm_recyclerview_retrofit_livedata.Models.PostModel;
import com.devahmed.mvvm_recyclerview_retrofit_livedata.R;
import com.devahmed.mvvm_recyclerview_retrofit_livedata.ui.mian2.Main2Activity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    PostViewModel postViewModel;
    RecyclerView recyclerView;
    PostAdapter adapter;
    List<PostModel> PostsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        recyclerView = findViewById(R.id.recycler);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PostsList = new ArrayList<>();
        adapter = new PostAdapter(PostsList);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(MainActivity.this, "" + position , Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this , Main2Activity.class);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        postViewModel.getPosts();
        postViewModel.postsMutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                adapter.setList(postModels);
            }
        });



    }
}
