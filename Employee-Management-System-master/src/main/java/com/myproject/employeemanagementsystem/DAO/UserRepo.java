package com.myproject.employeemanagementsystem.DAO;

import com.myproject.employeemanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    public ArrayList<User> getAllUser();


}
