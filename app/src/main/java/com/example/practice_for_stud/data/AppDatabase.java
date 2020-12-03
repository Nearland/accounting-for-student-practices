package com.example.practice_for_stud.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.practice_for_stud.model.Students;

@Database(entities = {Students.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract StudentsDao studentsDao();
}
