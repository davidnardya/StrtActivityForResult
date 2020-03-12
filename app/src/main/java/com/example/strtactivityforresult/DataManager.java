package com.example.strtactivityforresult;

import com.example.strtactivityforresult.pojo.Product;

import java.util.ArrayList;

public class DataManager {
    static ArrayList<Product> selectedProduct = new ArrayList<>();
    static ArrayList<Product> allProducts = new ArrayList<>();

    public static ArrayList<Product> getSelectedProduct() {
        return selectedProduct;
    }

    public static void setSelectedProduct(ArrayList<Product> selectedProduct) {
        DataManager.selectedProduct = selectedProduct;
    }

    public static ArrayList<Product> getAllProducts() {
        return allProducts;
    }

    public static void setAllProducts(ArrayList<Product> allProducts) {
        DataManager.allProducts = allProducts;
    }

    public void addProductToSelected(Product product){
        selectedProduct.add(product);
    }

    public void addProductToAllProducts(Product product) {
        allProducts.add(product);
    }


}
