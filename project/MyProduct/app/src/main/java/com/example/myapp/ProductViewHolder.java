
package com.example.myapp;
        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.RecyclerView;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.TextView;
        import com.facebook.drawee.view.SimpleDraweeView;

public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView p_name;
    private TextView p_price;
    private TextView p_bland;
    private SimpleDraweeView p_profile;

    ProductsAdapter.onProductListener onProductListener;
    public ProductViewHolder(@NonNull View itemView, ProductsAdapter.onProductListener onProductListener) {
        super(itemView);
        p_name = itemView.findViewById(R.id.p_name);
        p_price = itemView.findViewById(R.id.p_price);
        p_bland = itemView.findViewById(R.id.p_bland);
        p_profile = itemView.findViewById(R.id.p_profile);
        this.onProductListener = onProductListener;
        itemView.setOnClickListener(this);
    }
    public void bind(Product product){
        p_name.setText(product.getName());
        p_price.setText(product.getPrice());
        p_bland.setText(product.getBland());
        p_profile.setImageURI(product.getProfile());
    }
    public void onClick(View v) {
        onProductListener.onProductClick(getAdapterPosition());
    }

}
