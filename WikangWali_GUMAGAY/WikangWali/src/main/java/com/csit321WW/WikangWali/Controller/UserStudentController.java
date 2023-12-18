package com.csit321WW.WikangWali.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.csit321WW.WikangWali.Entity.UserStudentEntity;
import com.csit321WW.WikangWali.Service.UserStudentService;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
public class UserStudentController {

    @Autowired
    private UserStudentService userStudentService;

    // Create (C) - Register a new user
    @PostMapping("/register")
    public UserStudentEntity registerUser(@RequestBody UserStudentEntity user) {
        return userStudentService.registerUser(user);
    }

    // Read (R) - Retrieve user by ID
    @GetMapping("/{id}")
    public UserStudentEntity getUserById(@PathVariable int id) {
        try {
            return userStudentService.getUserById(id);
        } catch (NoSuchElementException ex) {
            // Handle NoSuchElementException
            return null; 
        }
    }

    // Update (U) - Update user information
    @PutMapping("/{id}")
    public UserStudentEntity updateUser(@PathVariable int id, @RequestBody UserStudentEntity newUserData) {
        try {
            return userStudentService.updateUser(id, newUserData);
        } catch (NoSuchElementException ex) {
            // Handle NoSuchElementException
            return null; 
        }
    }

    // Delete (D) - Delete user by ID
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        try {
            return userStudentService.deleteUser(id);
        } catch (NoSuchElementException ex) {
            // Handle NoSuchElementException
            return "User with ID " + id + " not found"; // For simplicity, returning a message in case of exception
        }
    }

    // Get all students
    @GetMapping("/all")
    public List<UserStudentEntity> getAllStudents() {
        return userStudentService.getAllStudents();
    }
}