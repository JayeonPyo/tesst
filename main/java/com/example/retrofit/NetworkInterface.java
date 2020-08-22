package com.example.retrofit;

import com.example.retrofit.Model.ArticleModel;
import com.example.retrofit.Model.UserModel;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface NetworkInterface {

    @POST("/post/user")
    @FormUrlEncoded
    Call<UserModel> register(@Field("id") String id, @Field("passwd") String pw, @Field("email") String email);


    @POST("/post/login")
    @FormUrlEncoded
    Call<ResponseBody> login(@Field("id") String id,@Field("passwd")String pw);


    @GET("/get/articles")
    Call<ArrayList<ArticleModel>> getarticles(String id, String title);
    // id = "id"

    @GET("/get/comments")
    Call<UserModel> getcomments();

    @POST("/post/article")
    Call<UserModel> postarticle(@Field("id") String id, @Field("title") String title,@Field("text") String article);

    @POST("/post/comment")
    @FormUrlEncoded
    Call<UserModel> postComment(@Field("id") String id, @Field("title") String title,@Field("comment") String comment);

}