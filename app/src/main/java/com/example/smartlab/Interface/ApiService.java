package com.example.smartlab.Interface;

import com.example.smartlab.DataBarang;
import com.example.smartlab.Models.LoginResponse;
import com.example.smartlab.Models.RegisterRequest;
import com.example.smartlab.Models.RegisterResponse;
import com.example.smartlab.Models.UserRequest;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @POST("/api/signin")
    Call<LoginResponse> loginUser(@Body UserRequest userRequest);

    @POST("api/signup")
    Call<RegisterResponse> registerUser(@Body RegisterRequest registerRequest);

    @FormUrlEncoded
    @POST("/api/post")
    Call<ResponseBody> postRequest(@Field("id") String id,
                                   @Field("title") String title,
                                   @Field("slug") String slug,
                                   @Field("content") String content,
                                   @Field("stok") String stok);

    @GET("api/post")
    Call<List<DataBarang>> getBarang();
}

