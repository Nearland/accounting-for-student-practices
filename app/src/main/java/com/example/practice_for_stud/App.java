package com.example.practice_for_stud;

import android.app.Application;

import androidx.room.Room;

import com.example.practice_for_stud.data.AppDatabase;
import com.example.practice_for_stud.data.StudentsDao;

public class App extends Application {

    private AppDatabase database;
    private StudentsDao studentsDao;

    private static App insance;

    /**
     *
     * @return insance
     */
    public static App getInstance() {
        return insance;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        insance = this;

        database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "studentsDB")
                .allowMainThreadQueries()
                .build();
        studentsDao = database.studentsDao();
    }

    /**
     *
     * @param database
     * @return вззвращает базу данных
     */
    public AppDatabase getDatabase(AppDatabase database) {
        return database;
    }

    /**
     *
     * @param database interface
     */
    public void setDatabase(AppDatabase database) {
        this.database = database;
    }

    /**
     *
     * @return возвращает класс интерфейс
     */
    public StudentsDao getNoteDao() {
        return studentsDao;
    }

    /**
     *
     * @param noteDao interface
     */
    public void setNoteDao(StudentsDao noteDao) {
        this.studentsDao = noteDao;
    }
}
