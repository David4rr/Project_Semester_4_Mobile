package com.example.smartlab.Interface;

import com.example.smartlab.DataBarang;
import com.example.smartlab.Models.LoginResponse;
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
    // Fungsi ini untuk memanggil API http://10.0.2.2/mahasiswa/login.php
//    @FormUrlEncoded
    @POST("/api/signin")
    Call<LoginResponse> loginUser(@Body UserRequest userRequest);

    // Fungsi ini untuk memanggil API http://10.0.2.2/mahasiswa/register.php
    @FormUrlEncoded
    @POST("register.php")
    Call<ResponseBody> registerRequest(@Field("nama") String nama,
                                       @Field("email") String email,
                                       @Field("password") String password);

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

