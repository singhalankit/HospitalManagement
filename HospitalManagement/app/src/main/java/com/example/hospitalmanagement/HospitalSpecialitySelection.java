package com.example.hospitalmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HospitalSpecialitySelection extends AppCompatActivity {

    private Spinner spinner;
    private static final String[] paths = {"item 1", "item 2", "item 3"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_hospital_speciality);
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.hospital_list,
                        android.R.layout.simple_spinner_item);
        staticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner1.setAdapter(staticAdapter);

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> staticAdapter1 = ArrayAdapter
                .createFromResource(this, R.array.speciality,
                        android.R.layout.simple_spinner_item);
        staticAdapter1
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner2.setAdapter(staticAdapter1);
//        Spinner dynamicSpinner = (Spinner) findViewById(R.id.dynamic_spinner);
//
//        String[] items = new String[] { "Chai Latte", "Green Tea", "Black Tea" };
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item, items);
//
//        dynamicSpinner.setAdapter(adapter);
        Button b = findViewById(R.id.buttonSubmit);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                docSlotActivityCall();
            }
        });


    }
    private void docSlotActivityCall(){
        Intent intent = new Intent(this,DocSlotBooking.class);
        startActivity(intent);
    }
}
