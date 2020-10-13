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

public class login extends AppCompatActivity {

    private TextView signbt;
    private EditText emailt,passwordt;
    private Button btn;
    private FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailt = findViewById(R.id.editTextTextEmailAddress);
        passwordt = findViewById(R.id.editTextTextPassword);
       btn = findViewById(R.id.button);
       mFirebaseAuth = FirebaseAuth.getInstance();
        signbt = findViewById(R.id.textView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = emailt.getText().toString();
                String password = passwordt.getText().toString();

                if(!email.isEmpty()&&!password.isEmpty()){
             mFirebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                 @Override
                 public void onComplete(@NonNull Task<AuthResult> task) {
                     if(task.isSuccessful()){
                         startActivity(new Intent(login.this,home.class));
                         finish();
                     }else{
                         Toast.makeText(login.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                     }
                 }
             }).addOnFailureListener(new OnFailureListener() {
                 @Override
                 public void onFailure(@NonNull Exception e) {
                     Toast.makeText(login.this, "Erorr!"+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                 }
             }).addOnCanceledListener(new OnCanceledListener() {
                 @Override
                 public void onCanceled() {
                     Toast.makeText(login.this, "Canceled!", Toast.LENGTH_SHORT).show();
                 }
             });
                }
                else{
                    Toast.makeText(login.this, "Please fill fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        signbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this,MainActivity.class));
            }
        });
    }

}