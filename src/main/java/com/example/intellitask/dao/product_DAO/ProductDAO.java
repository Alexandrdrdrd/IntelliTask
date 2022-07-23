package com.example.intellitask.dao.product_DAO;

import com.example.intellitask.entity.Product;


import java.util.List;

public interface ProductDAO {
    List<Product> getAllProducts();

    void saveProduct(Product product);

    Product getProduct (int productId);

    void deleteProduct(int productId);
}
