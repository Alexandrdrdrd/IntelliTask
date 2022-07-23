package com.example.intellitask.dao.user_DAO;



import com.example.intellitask.entity.Product;
import com.example.intellitask.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {

        Query query = entityManager.createQuery("from User");
        List<User> allUsers = query.getResultList();

        return allUsers;
    }

    @Override
    public void saveUser(User user) {
        User newuser = entityManager.merge(user);
        user.setId(newuser.getId());
    }

    @Override
    public User getUser(int userId) {

        User user  = entityManager.find(User.class, userId);
        return user;
    }


    @Override
    public void deleteUser(int userId) {
        Query query = entityManager.createQuery("delete from User where id =: userId");
        query.setParameter("userId", userId);
        query.executeUpdate();
    }

    @Override
    public boolean buyProduct(User user,  Product product) {
        if(user.getWallet()<product.getPrice()){
            return false;
        }else {
            user.setWallet(user.getWallet()-product.getPrice());
            user.addProductToUser(product);

            saveUser(user);
            return true;
        }

    }
}
