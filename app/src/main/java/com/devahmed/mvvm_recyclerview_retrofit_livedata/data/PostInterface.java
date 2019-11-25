package com.devahmed.mvvm_recyclerview_retrofit_livedata.data;

import com.devahmed.mvvm_recyclerview_retrofit_livedata.Models.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("posts")
    Call<List<PostModel>> getPosts();

}
