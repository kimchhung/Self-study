package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static java.security.AccessController.getContext;

public class LoginActivity extends AppCompatActivity {
    TextView registerEntry;
    ImageView backEntry;

    private View view;
    private TextInputEditText emailSignIn, passwordSignIn;
    private Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        backEntry = findViewById(R.id.backEntry);
        backEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        registerEntry = findViewById(R.id.registerEntry);
        registerEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( LoginActivity.this,RegisterActivity.class));
                finish();
            }
        });

    }

//    private void init() {
//        passwordSignIn = view.findViewById(R.id.passwordSignIn);
//        emailSignIn = view.findViewById(R.id.emailSignIn);
//        btnSignIn = view.findViewById(R.id.btnSignIn);
//        btnSignIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent( LoginActivity.this,LoginActivity.class));
//                finish();
//            }
//        });
//    }
//    private void login(){
//        StringRequest request = new StringRequest(Request.Method.POST, Constant.LOGIN, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                try {
//                    JSONObject object = new JSONObject(response);
//                    if (object.getBoolean("success")){
////                        JSONObject user = object.getJSONObject("user");
////                        SharedPreferences userPref = getAco
////                        SharedPreferences userPref = getActivity().getApplicationContext().getSharedPreferences("user",getContext().MODE_PRIVATE);
////                        SharedPreferences.Editor editor = userPref.edit();
////                        editor.putString("token",object.getString("token"));
////                        editor.putString("name",object.getString("name"));
////                        editor.putString("email",object.getString("email"));
////                        editor.apply();
//                        Toast.makeText(LoginActivity.this,"Login Success",Toast.LENGTH_SHORT).show();
//                    }
//                }catch (JSONException e){
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d("error",error.toString());
//            }
//        }){
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                HashMap<String,String> map = new HashMap<>();
//                map.put("email",emailSignIn.getText().toString().trim());
//                map.put("password",passwordSignIn.getText().toString());
//                return map;
//            }
//        };
//        Volley.newRequestQueue(this).add(request);
//    }



}
