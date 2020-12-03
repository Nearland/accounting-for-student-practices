package com.example.practice_for_stud.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.practice_for_stud.Jesus;
import com.example.practice_for_stud.R;
import com.example.practice_for_stud.model.Students;
import com.example.practice_for_stud.view.Adapter;
import com.example.practice_for_stud.view.Fragment_students;
import com.example.practice_for_stud.view.MainActivity;
import com.example.practice_for_stud.view.MainViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String EXTRA_STUD = "Fragment_students.EXTRA_STUD";

    private Students students;

    public static void start (Activity caller, Students students) {
        Intent intent = new Intent(caller, Fragment_students.class);
        if (students != null) {
            intent.putExtra(EXTRA_STUD, students);
        }
        caller.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button = (Button)findViewById(R.id.bn_students);
        button.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        Intent i;
        i = new Intent(this, Jesus.class);
        startActivity(i);
    }

}