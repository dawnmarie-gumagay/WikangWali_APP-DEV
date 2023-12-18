package com.csit321WW.WikangWali.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.csit321WW.WikangWali.Entity.ExerciseEntity;
import com.csit321WW.WikangWali.Service.ExerciseService;

import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;
    
    // Create (C) - Add a new exercise
    @PostMapping("/add")
    public ExerciseEntity addExercise(@RequestBody ExerciseEntity exercise) {
        return exerciseService.createExercise(exercise);
    }

    // Read (R) - Retrieve exercise by ID
    @GetMapping("/{id}")
    public ExerciseEntity getExerciseById(@PathVariable int id) {
        try {
            return exerciseService.getExerciseById(id);
        } catch (NoSuchElementException ex) {
            // Handle NoSuchElementException
            return null; 
        }
    }
    
    // Update (U) - Update exercise information
    @PutMapping("/{id}")
    public ExerciseEntity updateExercise(@PathVariable int id, @RequestBody ExerciseEntity newExerciseData) {
        try {
            return exerciseService.updateExercise(id, newExerciseData);
        } catch (NoSuchElementException ex) {
            // Handle NoSuchElementException
            return null; 
        }
    }

    // Custom business logic - Start exercises for a lesson
    @PostMapping("/startExercise/{id}")
    public String startExercisesForLesson(@PathVariable int id) {
        try {
            // Business rule: Start exercises for a lesson
            return exerciseService.startExercisesForLesson(id);
        } catch (NoSuchElementException ex) {
            // Handle NoSuchElementException
            return "Exercises for lesson with ID " + id + " not found"; 
        }
    }
    
    // Custom business logic - Mark exercise as completed
    @PatchMapping("/complete/{id}")
    public String markExerciseAsCompleted(@PathVariable int id, @RequestBody Map<String, Object> requestBody) {
        boolean isCompleted = (boolean) requestBody.getOrDefault("isCompleted", false);
        try {
            return exerciseService.markExerciseAsCompleted(id, isCompleted);
        } catch (NoSuchElementException ex) {
            return "Exercise with ID " + id + " not found";
        } catch (Exception e) {
            return "An error occurred: " + e.getMessage();
        }
    }
}
