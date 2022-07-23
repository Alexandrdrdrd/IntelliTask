package com.example.intellitask.service.product_service;

import com.example.intellitask.dao.product_DAO.ProductDAO;
import com.example.intellitask.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDAO productDAO;

    @Transactional
    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Transactional
    @Override
    public void saveProduct(Product product) {
        productDAO.saveProduct(product);
    }

    @Transactional
    @Override
    public Product getProduct(int productId) {
        return productDAO.getProduct(productId);
    }

    @Transactional
    @Override
    public void deleteProduct(int productId) {
        productDAO.deleteProduct(productId);
    }
}
