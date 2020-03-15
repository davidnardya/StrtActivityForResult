package com.example.strtactivityforresult;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.strtactivityforresult.pojo.Product;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {


    ArrayList<Product> selectedProductsList;

    public MainAdapter(ArrayList<Product> selectedProductsList) {
        this.selectedProductsList = selectedProductsList;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_product_cell,parent,false);

        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        Product item = selectedProductsList.get(position);
        holder.productName.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return selectedProductsList.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder{

        RecyclerView recyclerView;
        TextView productName;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.main_activity_container);
            productName = itemView.findViewById((R.id.product_name_tv));
        }
    }
}
