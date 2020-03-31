package com.hira.hiranoteapp;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.hira.hiranoteapp.room.Note;

import org.joda.time.DateTime;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {

    private ArrayList<Note> notes;
    private LayoutInflater inflater;


    public NoteAdapter(Context baseContext, ArrayList<Note> nit_list) {
        inflater=LayoutInflater.from(baseContext);
        notes=nit_list;

    }



    //    public NoteAdapter(MainActivity mainActivity, ArrayList<Note> note) {
//            this.notes=note;
//            inflater=LayoutInflater.from(mainActivity);
//    }
    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View iteview =inflater.inflate(
                R.layout.note_list,
                parent,
                false
        );

        return new NoteViewHolder(iteview);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        final Note note=notes.get(position);

        holder.noteBody.setText(note.noteBody);
        holder.note_title.setText(note.note_title);


        DateTime dateTime = new DateTime(note.createdAt);
        String day=""+dateTime.getDayOfMonth();
        String month=""+dateTime.getMonthOfYear();
        String year=""+dateTime.getYear();

        holder.date_text.setText(day+"/"+month+"/"+year);

        holder.noteBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(v.getContext(),ReadNote.class);
                i.putExtra("title",note.note_title);
                i.putExtra("body",note.noteBody);
                i.putExtra("id",note.uid);
                v.getContext().startActivity(i);

            }
        });


    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
