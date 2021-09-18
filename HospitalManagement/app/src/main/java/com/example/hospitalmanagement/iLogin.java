package com.example.hospitalmanagement;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface iLogin {

    String URL_BASE = "https://manage-hospital.azurewebsites.net";

    @Headers("Content-Type: application/json")
    @POST("/login")
    Call<JsonObject> getUser(@Body LoginRequest body);
}
