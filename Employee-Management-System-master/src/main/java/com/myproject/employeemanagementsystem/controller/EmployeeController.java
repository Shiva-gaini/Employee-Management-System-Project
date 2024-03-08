package com.myproject.employeemanagementsystem.controller;

import com.myproject.employeemanagementsystem.DAO.EmployeeRepo;
import com.myproject.employeemanagementsystem.entity.Employee;
import com.myproject.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeRepo employeeRepo;

    @PostMapping(path = "/addEmployee" , consumes = "application/json")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.save(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }
    @GetMapping("/allEmployee")
    public ResponseEntity<List<Employee>> allEmployees(){
        List<Employee> employee = employeeService.findAll();
        System.out.println(employee);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @GetMapping(path = "byId/{id}", produces = "application/json")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable("id") Long id){
        Optional<Employee> employee = employeeService.findEmployeeById(id);
        if (employee.isPresent()){
            return new ResponseEntity<>(employee,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long id){
        Optional<Employee> employee = employeeService.findEmployeeById(id);
        if(employee.isPresent()){
            employeeService.deleteById(id);
            String message = "Employee with ID " + id + " has been deleted successfully.";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }
        else {
            String message = "Employee with ID " + id + " Not Found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployeebyId(@PathVariable("id") Long id, @RequestBody Employee employee){
        Employee emp = employeeService.updateEmployee(employee, id);
        return new ResponseEntity<>(emp, HttpStatus.OK);

    }






}
