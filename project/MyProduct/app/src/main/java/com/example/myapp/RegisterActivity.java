package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    ImageView backEntry;
    EditText regName,regUsername, regEmail, regPassword,regPhoneNo;
    Button regBtn;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        backEntry = findViewById(R.id.backEntry);
        backEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        regBtn = findViewById(R.id.regBtn);
        regUsername = findViewById(R.id.regUsername);
        regName = findViewById(R.id.regName);
        regEmail = findViewById(R.id.regEmail);
        regPassword = findViewById(R.id.regPassword);
        regPhoneNo = findViewById(R.id.regPhoneNo);

        // save data to firebase
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode= FirebaseDatabase.getInstance();
                //reference
                reference = rootNode.getReference("users");
                //get all the values
                String username = regUsername.getEditableText().toString();
                String name = regName.getEditableText().toString();
                String email = regEmail.getEditableText().toString();
                String password = regPassword.getEditableText().toString();
                String phoneNo = regPhoneNo.getEditableText().toString();
                UserHelperClass helperClass = new UserHelperClass(username,name,email,password,phoneNo);
                reference.child(username).setValue(helperClass);
                Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("name",username);
                intent.putExtra("email",email);
                intent.putExtra("password",password);
                intent.putExtra("phoneNo",phoneNo);
                startActivity(intent);
            }
        });


    }
}
