package com.hira.hiranoteapp;

import android.content.Context;
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
        Note note=notes.get(position);
        holder.noteBody.setText(note.noteBody);
        holder.noteBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Sharing Trigered", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
