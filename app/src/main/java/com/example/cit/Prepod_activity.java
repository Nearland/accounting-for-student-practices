package com.example.cit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Prepod_activity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;

    MyDatabaseHelper myDatabaseHelper;
    ArrayList<String> teach_id, name_teach, surname_teach, patronymic_tech;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepod_activity);

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(Prepod_activity.this, Add_prepod_activity.class);
                startActivity(i);
            }
        });

        myDatabaseHelper = new MyDatabaseHelper(Prepod_activity.this);
        teach_id = new ArrayList<>();
        name_teach = new ArrayList<>();
        surname_teach = new ArrayList<>();
        patronymic_tech = new ArrayList<>();

        storeData();

        adapter = new Adapter(Prepod_activity.this, teach_id, name_teach, surname_teach, patronymic_tech);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Prepod_activity.this));

    }

    void storeData(){
        Cursor cursor = myDatabaseHelper.read();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "Нет данных", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){
                name_teach.add(cursor.getString(2));
                surname_teach.add(cursor.getString(3));
                patronymic_tech.add(cursor.getString(0));
                teach_id.add(cursor.getString(1));
            }
        }
    }
}