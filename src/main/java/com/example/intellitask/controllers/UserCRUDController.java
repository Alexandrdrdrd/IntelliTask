package com.example.intellitask.controllers;


import com.example.exception_handling.product_exception.NoSuchProductException;
import com.example.exception_handling.product_exception.ProductIncorrectData;
import com.example.exception_handling.user_exception.NoSuchUserException;
import com.example.exception_handling.user_exception.UserIncorrectData;
import com.example.intellitask.entity.User;
import com.example.intellitask.service.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserCRUDController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        User user = userService.getUser(id);
        if(user == null){
            throw new NoSuchUserException("There is no player with id = "+
                    id+ " in database");
        }
        return user;
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }


    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public List<User> deleteUser(@PathVariable int id) {
        userService.getUser(id).setUserProducts(null);
        userService.deleteUser(id);
        return getAllUsers();
    }


    @ExceptionHandler
    public ResponseEntity<UserIncorrectData> handleException(NoSuchUserException exception){
        UserIncorrectData data = new UserIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<UserIncorrectData> handleException(Exception exception){
        UserIncorrectData data = new UserIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
