package com.myproject.employeemanagementsystem.service;

import com.myproject.employeemanagementsystem.DAO.EmployeeRepo;
import com.myproject.employeemanagementsystem.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;


    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Optional<Employee> findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepo.deleteById(id);

    }

    @Override
    public List<Employee> findAllSortedByLastName() {
        return employeeRepo.findAllSortedByLastName();
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        return employeeRepo.updateEmployee(employee, id);
    }
}
