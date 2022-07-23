package com.example.intellitask.service.user_service;


import com.example.intellitask.dao.user_DAO.UserDAO;
import com.example.intellitask.entity.Product;
import com.example.intellitask.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user ) {
        userDAO.saveUser(user);
    }

    @Transactional
    @Override
    public User getUser(int userId) {
        return userDAO.getUser(userId);
    }

    @Transactional
    @Override
    public void deleteUser(int userId) {
        userDAO.deleteUser(userId);
    }
    @Transactional
    @Override
    public boolean buyProduct(User user,  Product product){
        return userDAO.buyProduct(user,product);
    }
}
