package com.example.cit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add_prepod_activity extends AppCompatActivity {

    Button add;
    EditText nameP, surnameP, patronymicP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_prepod_activity);

        nameP = findViewById(R.id.name_teacher);
        surnameP = findViewById(R.id.surname_teacher);
        patronymicP = findViewById(R.id.patronymic_teacher);

        add = findViewById(R.id.bn_save);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(Add_prepod_activity.this);
                myDatabaseHelper.Add_prepod(nameP.getText().toString().trim(),
                        surnameP.getText().toString().trim(), patronymicP.getText().toString().trim());
            }
        });
    }
}