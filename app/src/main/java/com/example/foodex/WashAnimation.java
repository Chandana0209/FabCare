package com.example.foodex;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WashAnimation extends AppCompatActivity {
    Button btnWashNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wash_animation);
        btnWashNext=findViewById(R.id.btnWashNext);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Fab Care    ");

        btnWashNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(WashAnimation.this, Menu.class);
                startActivity(intent);
            }
        });
    }
}