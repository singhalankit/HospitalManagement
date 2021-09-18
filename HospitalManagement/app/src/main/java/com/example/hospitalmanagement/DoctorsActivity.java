package com.example.hospitalmanagement;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

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
        EditText docMiddleName = findViewById(R.id.DocMiddleName);
        EditText docLastName = findViewById(R.id.DocLastName);
        EditText docEmployeeId = findViewById(R.id.DocEmployeeId);
        EditText docEmail = findViewById(R.id.DocEmailAddress);
        EditText docPhone = findViewById(R.id.DocPhone);
        EditText docAge = findViewById(R.id.DocAge);
        EditText docGender = findViewById(R.id.DocGender);
        EditText docAddress = findViewById(R.id.DocAddress);
        EditText docSpeciality = findViewById(R.id.DocSpeciality);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DoctorsLogin.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DoctorsLogin apiInterface = retrofit.create(DoctorsLogin.class);
        try {

            StaffLoginRequest request = new StaffLoginRequest();
            CommonAPIHeader header = new CommonAPIHeader();
            request.setAddress(String.valueOf(docAddress.getText()));
            request.setLastName(String.valueOf(docLastName.getText()));
            request.setAge(Integer.valueOf(String.valueOf(docAge.getText())));
            request.setEmail(String.valueOf(docEmail.getText()));
            request.setFirstName(String.valueOf(DocFirstName.getText()));
            request.setGender(String.valueOf(docGender.getText()));
            request.setMiddleName(String.valueOf(docMiddleName.getText()));
            request.setPhone(String.valueOf(docPhone.getText()));
            request.setProfession(String.valueOf(docSpeciality.getText()));
            request.setStaffId(String.valueOf(docEmployeeId.getText()));
            header.setChannelId("CN");
            header.setHospitalId("H0002");
            header.setTransId("transId");
            request.setHeader(header);
            Call<JsonObject> userCall = apiInterface.getUser(request);

            userCall.enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    response.body();
                    Log.i("Response",response.body().toString());
                }

                @Override
                public void onFailure(Call<JsonObject> call, Throwable t) {

                }
            });
        } catch (Exception e) {
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
