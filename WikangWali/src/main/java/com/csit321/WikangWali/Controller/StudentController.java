package com.csit321.WikangWali.Controller;

import com.csit321.WikangWali.Entity.StudentEntity;
import com.csit321.WikangWali.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parent")  
public class StudentController {

    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<StudentEntity> createStudent(@RequestBody StudentEntity student) {
        try {
            StudentEntity createdStudent = studentService.createStudent(student.getFirstName(),
                    student.getLastName(), student.getProgressTracker(), student.getCourseProgress());
            return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getStudentId")  
    public ResponseEntity<List<StudentEntity>> getStudentById() {
        try {
            List<StudentEntity> students = studentService.getAllStudents();
            if (students.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
