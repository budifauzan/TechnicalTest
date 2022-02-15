package com.example.technicaltest;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPI {
    @GET("users?q=budi")
    Call<ArrayList<UserModel>> getAllData();
}
