package com.example.practice_for_stud.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.practice_for_stud.App;
import com.example.practice_for_stud.R;
import com.example.practice_for_stud.model.Students;

public class Fragment_students extends AppCompatActivity {


    private static final String EXTRA_STUD = "Fragment_students.EXTRA_STUD";

    private Students students;

    private EditText t_name, t_surname, t_patronymic;

    public static void start(Activity caller, Students students) {
        Intent intent = new Intent(caller, Fragment_students.class);
        if (students != null) {
            intent.putExtra(EXTRA_STUD, students);
        }
        caller.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.fragment_students);

       // Toolbar toolbar = findViewById(R.id.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        setTitle("Студенты");

        t_name = findViewById(R.id.txt_name);
        t_surname = findViewById(R.id.txt_surname);
        t_patronymic = findViewById(R.id.txt_patronymic);

        if (getIntent().hasExtra(EXTRA_STUD)) {
            students = getIntent().getParcelableExtra(EXTRA_STUD);
            t_name.setText(students.nameS);
            t_surname.setText(students.surnameS);
            t_patronymic.setText(students.patronymicS);
        } else {
            students = new Students();
        }
    }

    /**
     * метод вызывает меню
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {        // модуль для редактирования заметок
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.action_save:
                if (t_name.getText().length() > 0) {
                    students.nameS = t_name.getText().toString();
                    students.surnameS = t_surname.getText().toString();
                    students.patronymicS = t_patronymic.getText().toString();
                    students.timestamp = System.currentTimeMillis();
                    if (getIntent().hasExtra(EXTRA_STUD)) {
                        App.getInstance().getNoteDao().update(students);
                    } else {
                        App.getInstance().getNoteDao().insert(students);
                    }
                    finish();
                }
                break;
        }
        return super.onOptionsItemSelected(item);

    }

}
