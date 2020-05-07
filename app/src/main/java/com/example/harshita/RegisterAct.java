package com.example.harshita;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterAct extends AppCompatActivity {
    private EditText userName,userPassword,userEmail;
    private Button regLogin;
    private TextView userLogin;
    private FirebaseAuth firebaseAuth;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userName=(EditText)findViewById(R.id.etplain);
        userEmail=(EditText)findViewById(R.id.editMail);
        userPassword=(EditText)findViewById(R.id.editPassword);
        regLogin=(Button)findViewById(R.id.btnLogin);
        userLogin=(TextView)findViewById(R.id.tvLogin);
        firebaseAuth=FirebaseAuth.getInstance();

        regLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (validate()){
                   //database
                   String user_email=userEmail.getText().toString().trim();
                   String user_password=userPassword.getText().toString().trim();
                   firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           if (task.isSuccessful()) {
                               Toast.makeText(RegisterAct.this, "registration successful", Toast.LENGTH_SHORT).show();
                               startActivity(new Intent(RegisterAct.this, MainActivity.class));
                           }
                           else{
                               Toast.makeText(RegisterAct.this,"not successful",Toast.LENGTH_SHORT).show();
                           }

                       }
                   });



                }
            }
        });


        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterAct.this,MainActivity.class));
            }
        });

    }
    private Boolean validate(){
        Boolean result=false;
        String name=userName.getText().toString();
        String password=userPassword.getText().toString();
        String email=userEmail.getText().toString();
        if (name.isEmpty() && password.isEmpty() && email.isEmpty()){
            Toast.makeText(RegisterAct.this," enter the details", Toast.LENGTH_SHORT).show();
        }else{
            result=true;
        }

        return result;
    }

}

