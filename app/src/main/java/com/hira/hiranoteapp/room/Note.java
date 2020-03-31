package com.hira.hiranoteapp.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Note {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name="note_title")
    public String note_title;

    @ColumnInfo(name="category")
    public String category;

    @ColumnInfo(name="note_body")
    public String noteBody;

    @ColumnInfo(name = "created_at")
    public String createdAt;    //"2004-12-13T21:39:45.618-08:00"
}
