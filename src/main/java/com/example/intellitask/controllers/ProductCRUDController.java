package com.example.intellitask.controllers;

import com.example.exception_handling.product_exception.NoSuchProductException;
import com.example.exception_handling.product_exception.ProductIncorrectData;
import com.example.exception_handling.user_exception.UserIncorrectData;
import com.example.intellitask.entity.Product;
import com.example.intellitask.service.product_service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductCRUDController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable int id) {
        Product product  = productService.getProduct(id);
        if(product == null){
            throw new NoSuchProductException("There is no player with id = "+
                    id+ " in database");
        }
        return product;
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product ) {
        productService.saveProduct(product);
        return product;
    }


    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product product ) {
        productService.saveProduct(product);
        return product;
    }

    @DeleteMapping("/products/{id}")
    public List<Product> deleteProduct(@PathVariable int id) {
        productService.getProduct(id).setProductUsers(null);
        productService.deleteProduct(id);
        return getAllProducts();
    }


    @ExceptionHandler
    public ResponseEntity<ProductIncorrectData> handleException(NoSuchProductException exception){
        ProductIncorrectData data = new ProductIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<ProductIncorrectData> handleException(Exception exception){
        ProductIncorrectData data = new ProductIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
