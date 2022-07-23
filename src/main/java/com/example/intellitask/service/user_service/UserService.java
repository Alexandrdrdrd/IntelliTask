package com.example.intellitask.service.user_service;


import com.example.intellitask.entity.Product;
import com.example.intellitask.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(int userId);

    void deleteUser(int userId);

    boolean buyProduct(User user,  Product product);
}
