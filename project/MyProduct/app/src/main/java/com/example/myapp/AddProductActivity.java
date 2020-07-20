package com.example.myapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.gson.Gson;

import java.util.HashMap;

public class AddProductActivity extends AppCompatActivity {
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    private StorageReference mStorageRef;
    private int ImageBack = 1;
    private String tmpProfile;
    EditText  productBarcode,productName,productBrand,productPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        mStorageRef = FirebaseStorage.getInstance().getReference().child("ImageFolder");
        Button productUploadBtn = findViewById(R.id.productUpload);
        Button productAddBtn = findViewById(R.id.addProductBtn);
         productBarcode = findViewById(R.id.productBarcode);
         productName = findViewById(R.id.productName);
         productBrand = findViewById(R.id.productBrand);
         productPrice = findViewById(R.id.productPrice);

        productUploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadData(v);
            }
        });
        productAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode= FirebaseDatabase.getInstance();
                //reference
                reference = rootNode.getReference("products");
                String barcode = productBarcode.getEditableText().toString();
                String name = productName.getEditableText().toString();
                String brand = productBrand.getEditableText().toString();
                String price = productPrice.getEditableText().toString();
                String profile = tmpProfile;
                Product product= new Product(barcode,name,brand,price,profile);
                reference.child(barcode).setValue(product);

            }
        });


//        reference.child("id").setValue(product);
    }
    public  void uploadData(View view){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent,ImageBack);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ImageBack){
            if(resultCode == RESULT_OK){
                Uri imageData = data.getData();
                final StorageReference imageName = mStorageRef.child("image"+imageData.getLastPathSegment());
                imageName.putFile(imageData).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        imageName.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                tmpProfile = String.valueOf(uri);
                                Toast.makeText(AddProductActivity.this,"uploaded",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        }
    }
}
