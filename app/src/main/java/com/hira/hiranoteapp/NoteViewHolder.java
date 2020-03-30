package com.hira.hiranoteapp;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

class NoteViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.note_title)
    TextView noteBody;

    @BindView(R.id.share)
    Button button;

    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
