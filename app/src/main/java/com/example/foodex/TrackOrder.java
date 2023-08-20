package com.example.foodex;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class TrackOrder extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_order);

        ActionBar actionBar=getSupportActionBar();
        // actionBar.setSubtitle("Welcome to our App");
        actionBar.setTitle(" Track Order   ");





    }


}
