package com.example.intellitask.dao.product_DAO;

import com.example.intellitask.entity.Product;
import com.example.intellitask.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO{
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Product> getAllProducts() {
        Query query = entityManager.createQuery("from Product");
        List<Product> allProducts = query.getResultList();
        return allProducts;
    }

    @Override
    public void saveProduct(Product product) {
        Product newproduct = entityManager.merge(product);
        product.setId(newproduct.getId());
    }

    @Override
    public Product getProduct(int productId) {
        Product product  = entityManager.find(Product.class, productId);
        return product;
    }

    @Override
    @Transactional
    public void deleteProduct(int productId) {
        Query query = entityManager.createQuery("delete from Product where id =: productId");
        query.setParameter("productId", productId);
        query.executeUpdate();
    }
}
