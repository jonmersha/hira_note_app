package com.hira.hiranoteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReadNote extends AppCompatActivity {

    TextView title;
    TextView body;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_note);
        Intent intent=getIntent();
        title=findViewById(R.id._title);
        body=findViewById(R.id._body);

        title.setText(intent.getStringExtra("title"));
        body.setText(intent.getStringExtra("body"));


        //////////////
        //title.setText(intent.getStringExtra("id"));


    }
}
