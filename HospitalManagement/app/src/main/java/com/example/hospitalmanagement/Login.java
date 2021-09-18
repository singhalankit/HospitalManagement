package com.example.hospitalmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Login extends AppCompatActivity implements Callback<JsonObject> {



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button signIn = findViewById(R.id.signIn);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallLogin();
            }
        });

    }

   private void CallLogin()
    {
        staffMenuActivity();
        EditText userName = findViewById(R.id.userName);
        EditText passWord = findViewById(R.id.password);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(iLogin.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        iLogin apiInterface = retrofit.create(iLogin.class);

        try {
            LoginRequest request = new LoginRequest();
            CommonAPIHeader header = new CommonAPIHeader();
            request.setUserName(String.valueOf(userName.getText()));
            request.setPassword(String.valueOf(passWord.getText()));
            header.setChannelId("CN");
            header.setHospitalId("H0002");
            header.setTransId("transId");
            request.setHeader(header);
            Log.i("Request-----",request.toString());
            Call<JsonObject> userCall = apiInterface.getUser(request);
            userCall.enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    Log.i("Response-----",response.body().toString());
                    if(response.body().toString().contains("responseCode\":\"0\"")){
                        staffMenuActivity();
                    }
                    staffMenuActivity();
                }

                @Override
                public void onFailure(Call<JsonObject> call, Throwable t) {

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void staffMenuActivity(){
        Intent intent = new Intent(this,SelectAction.class);
        startActivity(intent);
    }
    @Override
    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

    }

    @Override
    public void onFailure(Call<JsonObject> call, Throwable t) {

    }
}
