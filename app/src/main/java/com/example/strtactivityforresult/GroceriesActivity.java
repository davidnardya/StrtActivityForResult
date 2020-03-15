package com.example.strtactivityforresult;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.strtactivityforresult.pojo.Product;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GroceriesActivity extends AppCompatActivity {

    TextView productName;
    Button finishBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groceries);

        productName = findViewById(R.id.product_name_tv);
        finishBtn = findViewById(R.id.finish_btn);

        RecyclerView groceriesList = findViewById(R.id.groceries_list_container);
        groceriesList.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        //ArrayList<Product> allProductsList = new ArrayList<>();
        final GroceriesAdapter adapter = new GroceriesAdapter(DataManager.allProducts);

        groceriesList.setAdapter(adapter);

        finishBtn.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             JSONArray array = new JSONArray();
                                             for (int i = 0; i < DataManager.selectedProduct.size(); i++) {
                                                 Product product = DataManager.getSelectedProduct().get(i);
                                                 String productObject = new Gson().toJson(product);
                                                 array.put(productObject);
                                             }

                                             Intent intent = new Intent();
                                             intent.putExtra("list", array.toString());

                                             setResult(Activity.RESULT_OK, intent);
                                             finish();

                                         }
                                     }
            );

        Product sugar = new Product();
        sugar.setName("Sugar");
        DataManager.addProductToAllProducts(sugar);
        Product milk = new Product();
        milk.setName("Milk");
        DataManager.addProductToAllProducts(milk);
        Product bread = new Product();
        bread.setName("Bread");
        DataManager.addProductToAllProducts(bread);
        Product flour = new Product();
        flour.setName("Flour");
        DataManager.addProductToAllProducts(flour);
        Product salt = new Product();
        salt.setName("Salt");
        DataManager.addProductToAllProducts(salt);
    }
}
