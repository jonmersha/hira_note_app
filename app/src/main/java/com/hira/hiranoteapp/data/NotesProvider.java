package com.hira.hiranoteapp.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class NotesProvider extends ContentProvider {
    public static  final String AUTHORITY="com.hira.hiranoteapp.data.NotesProvider";
    public static  final String BASE_PATH="notes";
    public static  final  Uri CONTENT_URI=Uri.parse("content://"+AUTHORITY+"/"+BASE_PATH);

    //constant to identify the requested operatoin
    public static final int NOTES=1;
    public static final int NOTES_ID=2;

    public static final UriMatcher uriMarcher=new UriMatcher(UriMatcher.NO_MATCH);
    static{
        uriMarcher.addURI(AUTHORITY,BASE_PATH,NOTES);
        uriMarcher.addURI(AUTHORITY,BASE_PATH+"/#",NOTES_ID);

        uriMarcher.addURI(AUTHORITY,BASE_PATH,NOTES_ID);

    }


    private SQLiteDatabase database;
    @Override
    public boolean onCreate() {
        DBOpenHelper helper=new DBOpenHelper(getContext());
        database= helper.getWritableDatabase();
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {

        return database.query(DBOpenHelper.TABLE_NOTES,DBOpenHelper.ALL_COLUMNS,selection,null,null,null,DBOpenHelper.NOTE_CREATED+ " DESC");
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        long id=database.insert(DBOpenHelper.TABLE_NOTES,null,values);
        return Uri.parse(BASE_PATH+"/"+ id);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return  database.delete(DBOpenHelper.TABLE_NOTES,selection,selectionArgs);
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return database.update(DBOpenHelper.TABLE_NOTES,values,selection,selectionArgs);
    }
}
