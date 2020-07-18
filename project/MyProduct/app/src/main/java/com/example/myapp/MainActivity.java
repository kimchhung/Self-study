package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.rengwuxian.materialedittext.MaterialEditText;

public class MainActivity extends AppCompatActivity {

//    MaterialEditText email,password;
      Button loginEntry;
      TextView registerEntry, skipLogin;

//    CheckBox loginStatue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        email = findViewById(R.id.email);
//        password = findViewById(R.id.password);
//        loginStatue = findViewById(R.id.checkbox);
        skipLogin = findViewById(R.id.skipLogin);
        loginEntry = findViewById(R.id.loginEntry);
        registerEntry = findViewById(R.id.registerEntry);
        registerEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( MainActivity.this,RegisterActivity.class));
//                finish();
            }

        });
        loginEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( MainActivity.this,LoginActivity.class));
//                finish();
            }
        });
        skipLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( MainActivity.this,DashboardActivity.class));
//                finish();
            }
        });
    }
}
