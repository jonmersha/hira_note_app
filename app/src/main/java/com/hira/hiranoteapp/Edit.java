package com.hira.hiranoteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.hira.hiranoteapp.room.AppDatabase;
import com.hira.hiranoteapp.room.Note;
import com.hira.hiranoteapp.util.Const;

import org.joda.time.DateTime;

public class Edit extends AppCompatActivity {

    private AppDatabase db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
    }
    public void saveNote(View v) {
        EditText text_body=findViewById(R.id.note_body);
        Note note=new Note();
        note.noteBody=text_body.getText().toString();
        note.createdAt=new DateTime().toString();
        MainActivity.model.add_note(note);
        Intent i =new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
