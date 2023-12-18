package com.csit321.WikangWali.Service;

import com.csit321.WikangWali.Entity.StudentEntity;
import com.csit321.WikangWali.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Create a new student
    public StudentEntity createStudent(String firstName, String lastName, String progressTracker, String courseProgress) {
        StudentEntity student = new StudentEntity(firstName, lastName, progressTracker, courseProgress);
        return studentRepository.save(student);
    }

    // Get all students
    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }
}
