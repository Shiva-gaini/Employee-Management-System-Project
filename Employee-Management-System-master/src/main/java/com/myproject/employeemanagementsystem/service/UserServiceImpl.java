package com.myproject.employeemanagementsystem.service;

import com.myproject.employeemanagementsystem.DAO.UserRepo;
import com.myproject.employeemanagementsystem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;
    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public boolean validateUser(String username, String password) {
        boolean status = false;
        ArrayList<User> users = (ArrayList<User>) userRepo.getAllUser();
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                status = true;
        }
        return status;
    }
}
