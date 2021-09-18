package com.example.hospitalmanagement;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DocSlotBooking extends AppCompatActivity {

//    ArrayList<String> listItems = new ArrayList<String>();
//    ArrayAdapter<String> adapter;
//    int clickCounter = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doc_slot_booking);

        Spinner spinner1 = (Spinner) findViewById(R.id.docSlotSpinner1);
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.docList,
                        android.R.layout.simple_spinner_item);
        staticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(staticAdapter);

        Spinner spinner2 = (Spinner) findViewById(R.id.docSlotSpinner2);
        ArrayAdapter<CharSequence> staticAdapter2 = ArrayAdapter
                .createFromResource(this, R.array.docAvailableTimeSlots,
                        android.R.layout.simple_spinner_item);
        staticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner2.setAdapter(staticAdapter2);

        Button b = findViewById(R.id.docSlotSubmitButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerPatient();
            }
        });
    }

    private void registerPatient(){
        Intent intent = new Intent(this,RegisterPatient.class);
        startActivity(intent);
    }
}
