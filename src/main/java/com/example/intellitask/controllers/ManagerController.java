package com.example.intellitask.controllers;

import com.example.exception_handling.user_exception.NoSuchUserException;
import com.example.exception_handling.user_exception.UserIncorrectData;
import com.example.exception_handling.user_exception.WalletException;
import com.example.intellitask.entity.Product;
import com.example.intellitask.entity.User;
import com.example.intellitask.service.product_service.ProductService;
import com.example.intellitask.service.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ManagerController {
    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @GetMapping("/product's_users/{id}")
    public List<User> getAllProductBuyers(@PathVariable int id) {
        return productService.getProduct(id).getProductUsers();
    }
    @GetMapping("/user's_products/{id}")
    public List<Product> getAllUserProducts(@PathVariable int id) {
        return userService.getUser(id).getUserProducts();
    }

    @GetMapping("customer/{customerId}/product/{productId}")
    public User buyProduct(@PathVariable int customerId, @PathVariable int productId){
        boolean success = userService.buyProduct(userService.getUser(customerId),productService.getProduct(productId));
        if(!success){
            throw new WalletException("check balance");
        }

        return userService.getUser(customerId);
    }

    @ExceptionHandler
    public ResponseEntity<UserIncorrectData> handleException(WalletException exception){
        UserIncorrectData data = new UserIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<UserIncorrectData> handleException(Exception exception){
        UserIncorrectData data = new UserIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
