package com.myproject.employeemanagementsystem.controller;

import com.myproject.employeemanagementsystem.entity.Employee;
import com.myproject.employeemanagementsystem.entity.User;
import com.myproject.employeemanagementsystem.service.EmployeeService;
import com.myproject.employeemanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping(path = "/redirectIfValid/{username}/{password}")
    public ResponseEntity<Object> redirectIfValid(@PathVariable String username, @PathVariable String password) {
        boolean isValid = userService.validateUser(username, password);
        if (isValid) {

            List<Employee> employees = employeeService.findAll();
            return ResponseEntity.ok(employees);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }
    }
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
