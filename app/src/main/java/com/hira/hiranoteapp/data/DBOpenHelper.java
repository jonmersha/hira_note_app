package com.hira.hiranoteapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DBOpenHelper<TABLE_CREATE> extends SQLiteOpenHelper {
    //constanct fro database version and name
    private static final String DATABASE_NAME="botes.db";
    private static final int DATABASE_VERSION=1;

    //Constants for identifying table and columns

    public  static final String TABLE_NOTES="notes";
    public static final String NOTE_ID="_id";
    public static final String NOTE_TEXT="noteText";
    public static final String NOTE_CREATED="noteCreated";


    public static final String[] ALL_COLUMNS={NOTE_ID,NOTE_TEXT,NOTE_CREATED};

    public static final String TABLE_CREATE = "CREATE TABLE " + TABLE_NOTES
            + "VALUES("
            + NOTE_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            +NOTE_TEXT+ " TEXT ,"
            +NOTE_CREATED+ " TEXT default CURRENT_TIMESTAMP"
            +")";


    public DBOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES);
        onCreate(db);
    }
}
