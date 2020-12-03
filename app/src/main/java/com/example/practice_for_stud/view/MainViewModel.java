package com.example.practice_for_stud.view;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.practice_for_stud.App;
import com.example.practice_for_stud.model.Students;

import java.util.List;

public class MainViewModel extends ViewModel {
    private LiveData<List<Students>> studentsLiveData = App.getInstance().getNoteDao().getAllLiveData();

    public LiveData<List<Students>> getNoteLiveData() {
        return studentsLiveData;
    }
}
