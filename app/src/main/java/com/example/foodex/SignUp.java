package com.example.foodex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    Button btnSignUp;
    TextView tvLog;
    EditText etName,etEmail,etPassword;
    FirebaseAuth mfirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        tvLog=findViewById(R.id.tvLog);
        btnSignUp=findViewById(R.id.btnSingUp);
        etEmail=findViewById(R.id.etEmail);
        etName=findViewById(R.id.etName);
        etPassword=findViewById(R.id.etPassword);
        mfirebaseAuth=FirebaseAuth.getInstance();
        tvLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUp.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=etName.getText().toString().trim();
                String email=etEmail.getText().toString().trim();
                String password=etPassword.getText().toString().trim();
                if(name.isEmpty())
                {
                    etName.setError("Please Enter Your Name");
                    etName.requestFocus();
                }
                else if(email.isEmpty())
                {
                    etEmail.setError("Please Enter Email ID");
                    etEmail.requestFocus();
                }
                else if(password.isEmpty())
                {
                    etPassword.setError("Please Enter Password");
                    etPassword.requestFocus();
                }
                else if(email.isEmpty() && password.isEmpty() && name.isEmpty())
                {
                    Toast.makeText(SignUp.this,"Fields are Empty",Toast.LENGTH_SHORT).show();
                }
                else if(!(email.isEmpty() && password.isEmpty() && name.isEmpty()))
                {
                    mfirebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful())
                            {
                                Toast.makeText(SignUp.this,"Sign Up Unsuccessful, Please Try Again",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Intent intent=new Intent(SignUp.this,MainActivity.class);
                                startActivity(intent);
                            }
                        }
                    });
                }
                else
                {
                    Toast.makeText(SignUp.this,"Error Occurred!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

