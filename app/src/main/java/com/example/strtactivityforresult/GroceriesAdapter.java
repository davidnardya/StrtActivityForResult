package com.example.strtactivityforresult;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.strtactivityforresult.pojo.Product;

import java.util.ArrayList;

public class GroceriesAdapter extends RecyclerView.Adapter<GroceriesAdapter.GroceriesViewHolder>{

    ArrayList<Product> productArrayList;

    public GroceriesAdapter(ArrayList<Product> productArrayList) {
        this.productArrayList = productArrayList;
    }

    @NonNull
    @Override
    public GroceriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_product_cell, parent, false);

        return new GroceriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GroceriesViewHolder holder, final int position) {
        Product item = productArrayList.get(position);
        holder.productName.setText(item.getName());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    DataManager.addProductToSelected(productArrayList.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }

    public class GroceriesViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        TextView productName;
        CheckBox checkBox;

        public GroceriesViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.groceries_list_container);
            productName = itemView.findViewById(R.id.product_name_tv);
            checkBox = itemView.findViewById(R.id.product_checkbox);
        }
    }
}
