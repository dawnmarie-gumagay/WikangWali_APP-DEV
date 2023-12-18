package com.csit321WW.WikangWali.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csit321WW.WikangWali.Entity.UserStudentEntity;
import com.csit321WW.WikangWali.Repository.UserStudentRepository;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserStudentService {

    private final UserStudentRepository userStudentRepository;

    @Autowired
    public UserStudentService(UserStudentRepository userStudentRepository) {
        this.userStudentRepository = userStudentRepository;
    }

    // Create (C) - Register a new user
    public UserStudentEntity registerUser(UserStudentEntity user) {
        return userStudentRepository.save(user);
    }

    // Read (R) - Retrieve user by ID
    public UserStudentEntity getUserById(int userid) {
        return userStudentRepository.findById(userid)
                .orElseThrow(() -> new NoSuchElementException("User with ID " + userid + " not found"));
    }

    // Update (U) - Update user information
    public UserStudentEntity updateUser(int userid, UserStudentEntity newUserData) throws NoSuchElementException {
        UserStudentEntity existingUser = userStudentRepository.findById(userid)
                .orElseThrow(() -> new NoSuchElementException("User with ID " + userid + " not found"));

        existingUser.setFirstname(newUserData.getFirstname());
        existingUser.setLastname(newUserData.getLastname());
        existingUser.setEmail(newUserData.getEmail());
        existingUser.setPassword(newUserData.getPassword());

        return userStudentRepository.save(existingUser);
    }

    // Get all students
    public List<UserStudentEntity> getAllStudents() {
        return userStudentRepository.findAll();
    }
    // Delete (D) - Delete user by ID
    public String deleteUser(int userId) throws NoSuchElementException {
        if (userStudentRepository.existsById(userId)) {
            userStudentRepository.deleteById(userId);
            return "User with ID " + userId + " has been deleted successfully";
        } else {
            throw new NoSuchElementException("User with ID " + userId + " not found");
        }
    }
}
