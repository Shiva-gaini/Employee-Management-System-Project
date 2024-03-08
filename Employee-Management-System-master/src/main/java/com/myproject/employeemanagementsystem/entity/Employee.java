package com.myproject.employeemanagementsystem.entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private Long phone;

    @Column(name = "doj", nullable = false)
    private LocalDate doj;

    public Employee() {
    }

    public Employee(Long id, String firstName, String lastName, String email, Long phone, LocalDate doj) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.doj = doj;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }
}
