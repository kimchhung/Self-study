package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.gson.Gson;

public class ProductsActivity extends AppCompatActivity implements ProductsAdapter.onProductListener{
    ImageView backEntry;
    RecyclerView recyclerView;
    Product[] products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_products);
        //reycler view  // make reference
        recyclerView = findViewById(R.id.recycler_view);
        // layout manager
        backEntry = findViewById(R.id.backEntry);
        backEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
//        //adapter
        loadProducts(this);
    }
    private void loadProducts(final ProductsAdapter.onProductListener onProductListener){
        String url = "http://192.168.1.3:80/api/getproduct";
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                products = gson.fromJson(response, Product[].class);
                //create and set adapter
                ProductsAdapter adapter = new ProductsAdapter(products,onProductListener);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ProductsActivity.this, "Something go wrong while querying data", Toast.LENGTH_SHORT).show();
                Log.d("app.com","load data error :" + error.getMessage());
            }
        });
        // add req to queue
        Volley.newRequestQueue(this).add(request);
    }

    @Override
    public void onProductClick(int position) {
        Log.d("click","position: "+position);
        Intent intent = new Intent(this,ProductDetailActivity.class);
        intent.putExtra("name",products[position].getName());
        intent.putExtra("price",products[position].getPrice());
        intent.putExtra("bland",products[position].getBland());
        startActivity(intent);
    }
}
