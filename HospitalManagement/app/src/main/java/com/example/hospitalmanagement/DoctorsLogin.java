package com.example.hospitalmanagement;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface DoctorsLogin {

    String URL_BASE = "https://manage-hospital.azurewebsites.net";

    @Headers("Content-Type: application/json")
    @POST("/registerStaff")

    Call<JsonObject> getUser(@Body String body);
}
