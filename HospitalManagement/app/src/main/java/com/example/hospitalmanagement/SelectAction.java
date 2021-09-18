package com.example.hospitalmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SelectAction extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_action);
        Button bookAppointment = findViewById(R.id.book_appointment);

        bookAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appointmentActivity();
            }
        });

    }
    private void appointmentActivity(){
        Intent intent = new Intent(this,HospitalSpecialitySelection.class);
        startActivity(intent);
    }
}
