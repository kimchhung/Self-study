package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ProductsAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    //dataset
    private Product[] products;
    private onProductListener onProductListener;
    public ProductsAdapter(Product[] products, onProductListener onProductListener){
        this.products=products;
        this.onProductListener = onProductListener;
    }
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // load layout file
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.view_holder_product, parent, false);
        return new ProductViewHolder(itemView, onProductListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = products[position];
        holder.bind(product);
    }

    @Override
    public int getItemCount() {
        return products.length;
    }
    public interface onProductListener{
        void onProductClick(int position);
    }
}

