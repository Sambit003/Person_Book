package com.dbscope.personbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//import android.view.View; "view statements has been replaced by the lambda function, so no need of importing this attribute"
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    Button insert,viewdata;
    EditText PersonName,personAge,personBgrp,personContact;
    ListView data_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insert= findViewById(R.id.insert);
        viewdata=findViewById(R.id.viewdata);
        PersonName=findViewById(R.id.PersonName);
        personAge=findViewById(R.id.personAge);
        personBgrp=findViewById(R.id.personBgrp);
        personContact=findViewById(R.id.personContact);
        data_view=findViewById(R.id.person_details);

        insert.setOnClickListener(v -> {
            personDB DATASET;
            try {
                DATASET= new personDB(-1,PersonName.getText().toString(),Integer.parseInt(personAge.getText().toString()),personBgrp.getText().toString(),personContact.getText().toString());
                //Toast.makeText(MainActivity.this, DATASET.toString(), Toast.LENGTH_SHORT).show();
            }
            catch (Exception e) {
                Toast.makeText(MainActivity.this,"Error", Toast.LENGTH_SHORT).show();
                DATASET= new personDB(-1,"ERROR",0,"ERROR","ERROR");
            }

            DBHandler DBHandler= new DBHandler(MainActivity.this);
            boolean success= DBHandler.addOne(DATASET);
            Toast.makeText(MainActivity.this,"Entry status : "+success,Toast.LENGTH_SHORT).show();
        });

        viewdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHandler dbHandler= new DBHandler(MainActivity.this);
                List<personDB> everyone= dbHandler.getEveryOne();
                ArrayAdapter personDBadapter= new ArrayAdapter<personDB>(MainActivity.this, android.R.layout.simple_list_item_1,dbHandler.getEveryOne());
                data_view.setAdapter(personDBadapter);
            }
        });

    }
}