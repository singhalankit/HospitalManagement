package com.example.hospitalmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterPatient extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_patient);
        Button b = findViewById(R.id.patientSubmit);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitPatienttDetails();            }
        });
    }

    private void submitPatienttDetails(){
        Intent intent = new Intent(this,BookingSuccessActivity.class);
        startActivity(intent);
    }
}
