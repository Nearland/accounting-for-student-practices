package com.example.practice_for_stud.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.practice_for_stud.model.Students;

import java.util.List;

@Dao
public interface StudentsDao {

    /**
     * запрос на выбор всей таблицы
     */
    @Query("SELECT * FROM Students")
    List<Students> getAll();

    @Query("SELECT * FROM Students")
    LiveData<List<Students>> getAllLiveData();
    /**
     * запрос с выбором id
     */
    @Query("SELECT * FROM Students WHERE id IN (:userIds)")
    List<Students> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM Students  WHERE id = :uniqueId LIMIT 1")
    Students findById(int uniqueId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Students students);
    /**
     * запрос обновления
     */
    @Update
    void update(Students students);
    /**
     * запрос удаления
     */
    @Delete
    void delete(Students students);
}
