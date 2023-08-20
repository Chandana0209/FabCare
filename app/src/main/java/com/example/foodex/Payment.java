package com.example.foodex;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Payment extends AppCompatActivity {
    Button btnPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        btnPay=findViewById(R.id.btnPay);
        ActionBar actionBar=getSupportActionBar();
        // actionBar.setSubtitle("Welcome to our App");
        actionBar.setTitle("Payment   ");


        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Payment.this, PaymentAnimation.class);
                startActivity(intent);
            }
        });

    }
}