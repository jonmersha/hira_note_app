package com.hira.hiranoteapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.hira.hiranoteapp.room.AppDatabase;
import com.hira.hiranoteapp.room.Note;
import com.hira.hiranoteapp.room.NoteDao;

import java.util.ArrayList;
import java.util.List;


public class NoteViewModel extends AndroidViewModel {
    private AppDatabase db;
    private MutableLiveData<ArrayList<Note>> notes;
    private NoteDao db_service;
    ArrayList mylist;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        db = ((App) application).getDb();
        mylist = new ArrayList<Note>(db.noteDao().getAll());
        notes = new MutableLiveData<>();
        notes.setValue(mylist);


    }
    public void add_note(Note note){
        db.noteDao().insertAll(note);
        mylist = new ArrayList<Note>(db.noteDao().getAll());
        notes.setValue(mylist);
    }

    public MutableLiveData<ArrayList<Note>> getNotes() {
        return notes;
    }
}