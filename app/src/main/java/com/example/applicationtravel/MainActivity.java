package com.example.applicationtravel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


     private  TextView loginbt;
    private EditText emailt,cpasswordt,passwordt;
    private Button btn;
    private FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth = FirebaseAuth.getInstance();
        loginbt = findViewById(R.id.textView);
        emailt = findViewById(R.id.editTextTextEmailAddress);
        passwordt = findViewById(R.id.editTextTextPassword);
        cpasswordt = findViewById(R.id.editTextTextPassword1);
        btn = findViewById(R.id.button);
        loginbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,login.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailt.getText().toString();
                String password = passwordt.getText().toString();
                String confirmPassword = cpasswordt.getText().toString();

                if(!email.isEmpty()&&!password.isEmpty()&&!confirmPassword.isEmpty()){

                    if(password.equals(confirmPassword)){

                        if(password.length()>=6){
                            mFirebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        startActivity(new Intent(MainActivity.this,login.class));
                                        finish();
                                    }
                                    else {
                                        Toast.makeText(MainActivity.this,"Something went wrong!Please try again!",Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(MainActivity.this,"Failed!"+e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                                }
                            }).addOnCanceledListener(new OnCanceledListener() {
                                @Override
                                public void onCanceled() {
                                    Toast.makeText(MainActivity.this,"Canceled",Toast.LENGTH_SHORT).show();
                                }
                            });
                        }else{
                            Toast.makeText(MainActivity.this,"Password must have minimum 6 characters!",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Passwords not match!",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this,"Please fill the fields",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}