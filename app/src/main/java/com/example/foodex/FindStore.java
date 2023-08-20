package com.example.foodex;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class FindStore extends AppCompatActivity {
    Button btnStore;
    EditText etStoreName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_store);
        btnStore=findViewById(R.id.btnStore);
        etStoreName=findViewById(R.id.etStoreName);
        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location=etStoreName.getText().toString().trim();
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+location));
                startActivity(intent);

            }
        });

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Fab Care");
    }
}
