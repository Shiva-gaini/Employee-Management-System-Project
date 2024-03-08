package com.myproject.employeemanagementsystem.DAO;

import com.myproject.employeemanagementsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo {
    List<Employee> findAll();
    Employee  save(Employee employee);
    Optional<Employee>  findEmployeeById(Long id);
    void  deleteById(Long id);
    List<Employee> findAllSortedByLastName();

    Employee updateEmployee(Employee employee, Long id);
}
