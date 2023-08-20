package com.example.foodex;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LocationAnimation extends AppCompatActivity {
    Button btnLocNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_animation);

        btnLocNext=findViewById(R.id.btnDryNext);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Fab Care    ");

        btnLocNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LocationAnimation.this, FindStore.class);
                startActivity(intent);
            }
        });
    }
}