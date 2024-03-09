package com.myproject.employeemanagementsystem.service;

import com.myproject.employeemanagementsystem.entity.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface UserService {
     User createUser(User user);
     public boolean validateUser(String username, String password);

}
