package com.example.strtactivityforresult;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.strtactivityforresult.pojo.Product;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    DataManager dataManager = new DataManager();
    
    ArrayList<Product> selectedProductsList = new ArrayList<>();

    public MainAdapter(ArrayList<Product> selectedProductsList) {
        this.selectedProductsList = selectedProductsList;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MainViewHolder extends RecyclerView.ViewHolder{

        RecyclerView recyclerView;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.main_activity_container);
        }
    }
}
