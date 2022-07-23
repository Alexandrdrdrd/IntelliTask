package com.example.intellitask.service.product_service;

import com.example.intellitask.entity.Product;


import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    void saveProduct(Product product );

    Product getProduct(int productId);

    void deleteProduct(int productId);
}
