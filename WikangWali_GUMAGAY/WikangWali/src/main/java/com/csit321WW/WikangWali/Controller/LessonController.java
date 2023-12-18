package com.csit321WW.WikangWali.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.csit321WW.WikangWali.Entity.LessonEntity;
import com.csit321WW.WikangWali.Service.LessonService;

import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/lesson")
public class LessonController {

    @Autowired
    private LessonService lessonService;
    
    // Create (C) - Add a new lesson
    @PostMapping("/add")
    public LessonEntity addLesson(@RequestBody LessonEntity lesson) {
        return lessonService.createLesson(lesson);
    }

    // Read (R) - Retrieve lesson by ID
    @GetMapping("/{id}")
    public LessonEntity getLessonById(@PathVariable int id) {
        try {
            return lessonService.getLessonById(id);
        } catch (NoSuchElementException ex) {
            // Handle NoSuchElementException
            return null; 
        }
    }
    
    // Update (U) - Update lesson information
    @PutMapping("/{id}")
    public LessonEntity updateLesson(@PathVariable int id, @RequestBody LessonEntity newLessonData) {
        try {
            return lessonService.updateLesson(id, newLessonData);
        } catch (NoSuchElementException ex) {
            // Handle NoSuchElementException
            return null; 
        }
    }
    
    // Custom business logic - Start lessons for a course
    @PostMapping("/startLessons/{id}")
    public String startLessons(@PathVariable int id) {
        try {
            // Business rule: Start lessons for a course
            return lessonService.startLessons(id);
        } catch (NoSuchElementException ex) {
            // Handle NoSuchElementException
            return "Lessons for course with ID " + id + " not found"; 
        }
    }

    // Custom business logic - Mark lesson as completed
    @PatchMapping("/complete/{id}")
    public String markLessonAsCompleted(@PathVariable int id, @RequestBody Map<String, Boolean> requestBody) {
        if (requestBody.containsKey("isCompleted")) {
            boolean isCompleted = requestBody.get("isCompleted");
            try {
                // Business rule: Mark lesson as completed
                return lessonService.markLessonAsCompleted(id, isCompleted);
            } catch (NoSuchElementException ex) {
                // Handle NoSuchElementException
                return "Lesson with ID " + id + " not found"; 
            } catch (Exception e) {
                return "An error occurred: " + e.getMessage();
            }
        } else {
            return "Invalid request. 'isCompleted' field not found in the request body.";
        }
    }    

}