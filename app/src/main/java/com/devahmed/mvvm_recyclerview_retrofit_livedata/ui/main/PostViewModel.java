package com.devahmed.mvvm_recyclerview_retrofit_livedata.ui.main;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.devahmed.mvvm_recyclerview_retrofit_livedata.Models.PostModel;
import com.devahmed.mvvm_recyclerview_retrofit_livedata.data.PostsClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {

    MutableLiveData<List<PostModel>> postsMutableLiveData = new MutableLiveData<>();

    public void getPosts(){
        PostsClient.getInstance().getPosts().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                postsMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                System.out.println("Error in ViewModel " + this.toString() +" because"+ t.getMessage());
            }
        });
    }
}
