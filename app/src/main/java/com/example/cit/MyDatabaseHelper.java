package com.example.cit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Practice.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "ALL_teachers";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME_TEACHER = "Name_teacher";
    private static final String COLUMN_SURNAME_TEACHER = "Surname_teacher";
    private static final String COLUMN_PATRONYMIC_TEACHER = "Patronymic_teacher";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query =  "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME_TEACHER + " TEXT, " +
                COLUMN_SURNAME_TEACHER + " TEXT, " +
                COLUMN_PATRONYMIC_TEACHER + " TEXT);";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    void Add_prepod(String name, String surname, String patronymic){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_NAME_TEACHER, name);
        contentValues.put(COLUMN_SURNAME_TEACHER, surname);
        contentValues.put(COLUMN_PATRONYMIC_TEACHER, patronymic);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1){
            Toast.makeText(context, "Ошибка", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Преподователь добавлен", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor read(){
         String qurey = "SELECT * FROM " + TABLE_NAME;
         SQLiteDatabase database = this.getReadableDatabase();

         Cursor cursor = null;
         if(database != null){
            cursor =  database.rawQuery(qurey, null);
         }
         return cursor;
    }
}
