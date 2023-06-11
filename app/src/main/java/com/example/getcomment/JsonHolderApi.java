package com.example.getcomment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface JsonHolderApi {
    @GET("posts/{id}/comments")
    Call<List<Comment>>getComment(@Path("id") int postId);

}
