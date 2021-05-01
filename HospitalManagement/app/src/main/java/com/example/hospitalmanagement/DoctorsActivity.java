package com.example.hospitalmanagement;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DoctorsActivity extends AppCompatActivity implements Callback<JsonObject> {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_doctor);

        Button DocSignIn = findViewById(R.id.DocSignIn);



DocSignIn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        CallDocRegister();
    }
});
        // prepare call in Retrofit 2.0


        }

    private void CallDocRegister() {
        EditText DocFirstName = findViewById(R.id.DocFirstName);
        EditText DocLastName = findViewById(R.id.DocLastName);
        EditText DocEmployeeId = findViewById(R.id.DocEmployeeId);
        EditText DocEmail = findViewById(R.id.DocEmailAddress);
        EditText DocPhone = findViewById(R.id.DocPhone);
        EditText DocAge = findViewById(R.id.DocAge);
        EditText DocGender = findViewById(R.id.DocGender);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DoctorsLogin.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DoctorsLogin apiInterface = retrofit.create(DoctorsLogin.class);
        try {
            JSONObject paramObject = new JSONObject();
            paramObject.put("firstName", DocFirstName.getText());
            paramObject.put("staffId", DocEmployeeId.getText());
            paramObject.put("lastName", DocLastName.getText());
            paramObject.put("age", DocAge.getText());
            paramObject.put("gender", DocGender.getText());
            paramObject.put("email", DocEmail.getText());
            paramObject.put("phone", DocPhone.getText());


            Call<JsonObject> userCall = apiInterface.getUser(paramObject.toString());
            userCall.enqueue(this);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

    }

    @Override
    public void onFailure(Call<JsonObject> call, Throwable t) {

    }
}
