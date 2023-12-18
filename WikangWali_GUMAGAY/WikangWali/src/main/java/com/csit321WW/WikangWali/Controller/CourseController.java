
package com.csit321WW.WikangWali.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.csit321WW.WikangWali.Entity.CourseEntity;
import com.csit321WW.WikangWali.Service.CourseService;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Read (R) - Retrieve course by ID
    @GetMapping("/{id}")
    public CourseEntity getCourseById(@PathVariable int id) {
        try {
            return courseService.getCourseById(id);
        } catch (NoSuchElementException ex) {
            // Handle NoSuchElementException
            return null; 
        }
    }
    
    // Retrieve all courses
    @GetMapping("/all")
    public List<CourseEntity> getAllCourses() {
        return courseService.getAllCourses();
    }


    // Update (U) - Update course information
    @PutMapping("/{id}")
    public CourseEntity updateCourse(@PathVariable int id, @RequestBody CourseEntity newCourseData) {
        try {
            return courseService.updateCourse(id, newCourseData);
        } catch (NoSuchElementException ex) {
            // Handle NoSuchElementException
            return null; 
        }
    }

    
    // Custom business logic - Start a course
    @PostMapping("/start/{id}")
    public String startCourse(@PathVariable int id) {
        try {
            // Business rule: Start a course
            return courseService.startCourse(id);
        } catch (NoSuchElementException ex) {
            // Handle NoSuchElementException
            return "Course with ID " + id + " not found"; // For simplicity, returning a message in case of exception
        }
    }
    
 // Custom business logic - Mark course as completed using PATCH
    @PatchMapping("/complete/{id}")
    public String markCourseAsCompleted(@PathVariable int id, @RequestBody boolean isCompleted) {
        try {
            // Business rule: Mark a course as completed
            return courseService.markCourseAsCompleted(id, isCompleted);
        } catch (NoSuchElementException ex) {
            // Handle NoSuchElementException
            return "Course with ID " + id + " not found"; 
        }
    }

}
