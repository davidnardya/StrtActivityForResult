package com.example.strtactivityforresult;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.strtactivityforresult.pojo.Product;

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

        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataManager dataManager = new DataManager();
                JSONObject object = new JSONObject();
                try {
                    object.put("Selected", dataManager.selectedProduct);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent();
                intent.putExtra("list", object.toString());

                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

    }
}
