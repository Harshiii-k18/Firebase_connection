package com.example.harshita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView email,pass;
    private Button LoginButton;
    private TextView userRegistration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (TextView) findViewById(R.id.eT);
        pass = (TextView) findViewById(R.id.ePass);
        LoginButton = (Button) findViewById(R.id.eB);
        userRegistration = (TextView) findViewById(R.id.tView);
        userRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterAct.class));
            }
        });

        final String StoredEmail="harshitakumawat53@gmail.com";
        final String StoredPass="harshi";
        LoginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String postEmail=email.getText().toString();
                String postPass=pass.getText().toString();
                if (postEmail.isEmpty()|| postPass.isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter the Details", Toast.LENGTH_SHORT).show();

                }
                else{
                    if (postEmail.equals(StoredEmail)&&postPass.equals(StoredPass)){
                        Toast.makeText(MainActivity.this, "successfull", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "sign in is unsuccessfull",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
