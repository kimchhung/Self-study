package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

public class ProductDetailActivity extends AppCompatActivity {
    private TextView p_name;
    private TextView p_price;
    private TextView p_bland;
    private SimpleDraweeView p_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        p_name = (TextView)findViewById(R.id.p_name);
        p_price = (TextView)findViewById(R.id.p_price);
        p_bland = (TextView)findViewById(R.id.p_bland);
        p_profile = (SimpleDraweeView)findViewById(R.id.p_profile);

        String tmpName = getIntent().getStringExtra("name");
        String tmpPrice = getIntent().getStringExtra("price");
        String tmpBland = getIntent().getStringExtra("bland");
        String tmpProfile = getIntent().getStringExtra("profile");

        p_name.setText(tmpName);
        p_price.setText(tmpPrice);
        p_bland.setText(tmpBland);
        p_profile.setImageURI(tmpProfile);

    }
}
