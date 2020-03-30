package com.hira.hiranoteapp;



import android.app.Application;
import android.widget.Toast;

import androidx.room.Room;


import com.hira.hiranoteapp.room.AppDatabase;
import com.hira.hiranoteapp.util.Const;



public class App extends Application {

    private AppDatabase db;
    @Override
    public void onCreate() {
        super.onCreate();
         db = Room.databaseBuilder(
                this, AppDatabase.class,
                Const.DATABASE_NAME
        ).allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }
    public AppDatabase getDb() {
        return db;
    }
}
