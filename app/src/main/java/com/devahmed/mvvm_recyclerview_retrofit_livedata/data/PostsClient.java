package com.devahmed.mvvm_recyclerview_retrofit_livedata.data;

import com.devahmed.mvvm_recyclerview_retrofit_livedata.Models.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    private PostInterface postInterface;

    private static PostsClient INSTANCE;

    public PostsClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        postInterface = retrofit.create(PostInterface.class);
    }

    public static PostsClient getInstance(){
        if(INSTANCE == null){
            INSTANCE = new PostsClient();
        }
        return INSTANCE;
    }


    public Call<List<PostModel>> getPosts(){
        return postInterface.getPosts();
    }
}
