package com.myproject.employeemanagementsystem.service;

import com.myproject.employeemanagementsystem.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface EmployeeService {
    List<Employee> findAll();
    Employee  save(Employee employee);
    Optional<Employee>  findEmployeeById(Long id);
    void  deleteById(Long id);
    List<Employee> findAllSortedByLastName();

    Employee updateEmployee(Employee employee, Long id);
}
