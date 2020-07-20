package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

public class DashboardActivity extends AppCompatActivity {
    Button btnListItem,btnAddItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        showAllUserData();
        btnListItem = findViewById(R.id.btnListItem);
        btnAddItem = findViewById(R.id.AddItemBtn);
        btnListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( DashboardActivity.this,ProductsActivity.class));
//                finish();
            }
        });
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AddProductActivity.class);
                startActivity(intent);
            }
        });
    }
    private void showAllUserData(){
        UserHelperClass userIntent = new UserHelperClass();
        Intent intent = getIntent();
        userIntent.username =intent.getStringExtra("username");
        userIntent.name =intent.getStringExtra("name");
        userIntent.email=intent.getStringExtra("email");
        userIntent.phoneNo =intent.getStringExtra("phoneNo");
        userIntent.password =intent.getStringExtra("password");

        Gson gson = new Gson();
        String json = gson.toJson(userIntent);
        Log.d("Intent",json);
    }
}
