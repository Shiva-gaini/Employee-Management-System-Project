package com.myproject.employeemanagementsystem.DAO;

import com.myproject.employeemanagementsystem.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public class UserRepoImpl {

    @Autowired
    EntityManager entityManager;
    public ArrayList<User> getAllUser(){
        TypedQuery<User> query = entityManager.createQuery("From User", User.class);
        return (ArrayList<User>) query.getResultList();
    }
}
