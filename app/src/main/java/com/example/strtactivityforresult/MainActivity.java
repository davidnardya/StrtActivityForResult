package com.example.strtactivityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.strtactivityforresult.pojo.Product;

public class MainActivity extends AppCompatActivity {

    final int REQUEST_CODE = 12345;

    Button selectProductsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectProductsBtn = findViewById(R.id.select_product_btn);

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
}
