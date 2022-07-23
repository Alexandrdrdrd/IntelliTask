package com.example.intellitask.dao.user_DAO;



import com.example.intellitask.entity.Product;
import com.example.intellitask.entity.User;

import java.util.List;

public interface UserDAO {
     List<User> getAllUsers();

     void saveUser(User user);

     User getUser (int userId);

    void deleteUser(int userId);

    boolean buyProduct(User user,  Product product);
}
