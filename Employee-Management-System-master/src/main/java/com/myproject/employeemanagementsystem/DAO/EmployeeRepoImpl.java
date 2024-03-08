package com.myproject.employeemanagementsystem.DAO;

import com.myproject.employeemanagementsystem.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
@Transactional
public class EmployeeRepoImpl implements EmployeeRepo {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("From Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public Optional<Employee> findEmployeeById(Long id) {
        return Optional.ofNullable(entityManager.find(Employee.class, id));
    }

    @Override
    public void deleteById(Long id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);

    }

    @Override
    public List<Employee> findAllSortedByLastName() {
        TypedQuery<Employee> query = entityManager.createQuery("From Employee order by lastname asc", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        employee.setId(id);
        return entityManager.merge(employee);
    }
}
