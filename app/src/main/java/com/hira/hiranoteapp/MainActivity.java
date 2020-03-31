package com.hira.hiranoteapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hira.hiranoteapp.data.DBOpenHelper;
import com.hira.hiranoteapp.data.NotesProvider;
import com.hira.hiranoteapp.room.AppDatabase;
import com.hira.hiranoteapp.room.Note;
import com.hira.hiranoteapp.util.Const;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    NoteAdapter adapter;
   // ArrayList<Note> note;
    //AppDatabase db;
    RecyclerView recyclerView;
    static NoteViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.note_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        model =new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(NoteViewModel.class);


        model.getNotes().observe(this, new Observer<ArrayList<Note>>() {
            @Override
            public void onChanged(ArrayList<Note> notes) {
                Toast.makeText(getBaseContext(),"value"+notes.size(),Toast.LENGTH_LONG).show();
                adapter=new NoteAdapter(getBaseContext(),notes);
                recyclerView.setAdapter(adapter);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab_icon);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Edit.class);
                startActivity(i);
            }
        });}}