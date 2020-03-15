package com.example.strtactivityforresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.strtactivityforresult.pojo.Product;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final int REQUEST_CODE = 12345;

    Button selectProductsBtn;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectProductsBtn = findViewById(R.id.select_product_btn);

        RecyclerView selectedProductsList = findViewById(R.id.main_activity_container);
        selectedProductsList.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));
         adapter = new MainAdapter(DataManager.selectedProduct);
        selectedProductsList.setAdapter(adapter);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                selectProductsBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, GroceriesActivity.class);

                        startActivityForResult(intent, REQUEST_CODE);
                    }
                });

            }
        }, 5000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            if(data != null){
                DataManager.setSelectedProduct(new ArrayList<Product>());
                String productString = data.getStringExtra("list");
                try {
                    JSONArray array = new JSONArray(productString);
                    for (int i = 0; i < array.length(); i++) {
                      Gson gson = new Gson();
                      Product product = gson.fromJson(array.getString(i), Product.class);
                      DataManager.addProductToSelected(product);
                    }

                    adapter.selectedProductsList = DataManager.selectedProduct;
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
