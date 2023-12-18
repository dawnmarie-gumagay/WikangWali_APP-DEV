package com.csit321WW.WikangWali.Service;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csit321WW.WikangWali.Entity.ExerciseEntity;
import com.csit321WW.WikangWali.Repository.ExerciseRepository;

@Service
public class ExerciseService {
	
	private final ExerciseRepository exerciseRepository;
	
	@Autowired	
	public ExerciseService(ExerciseRepository exerciseRepository) {
		this.exerciseRepository = exerciseRepository;
	}
	
	// Create (C) - Add a new exercise
    public ExerciseEntity createExercise(ExerciseEntity exercise) {
        return exerciseRepository.save(exercise);
    }

    // Read (R) - Retrieve exercise by ID
    public ExerciseEntity getExerciseById(int exerciseid) throws NoSuchElementException {
        return exerciseRepository.findById(exerciseid)
                .orElseThrow(() -> new NoSuchElementException("Exercise with ID " + exerciseid + " not found"));
    }
    
    // Update (U) - Update exercise information
    public ExerciseEntity updateExercise(int exerciseid, ExerciseEntity newExerciseData) throws NoSuchElementException {
        ExerciseEntity existingExercise = exerciseRepository.findById(exerciseid)
                .orElseThrow(() -> new NoSuchElementException("Exercise with ID " + exerciseid + " not found"));

        // Update existingExercise fields with newExerciseData
        existingExercise.setLessonid(newExerciseData.getLessonid());
        existingExercise.setExercisetype(newExerciseData.getExercisetype());
        existingExercise.setExercisecontent(newExerciseData.getExercisecontent());
        // Add other fields you want to update

        return exerciseRepository.save(existingExercise);
    }

    // Custom business logic - Start exercises for a lesson
    public String startExercisesForLesson(int lessonid) throws NoSuchElementException {
        return "Exercises for lesson with ID " + lessonid + " have started";
    }

    // Custom business logic - Mark exercise as completed
    public String markExerciseAsCompleted(int exerciseId, Boolean isCompleted) throws NoSuchElementException {
        ExerciseEntity exercise = exerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new NoSuchElementException("Exercise with ID " + exerciseId + " not found"));

        if (isCompleted != null) {
            exercise.setCompleted(isCompleted);
            exerciseRepository.save(exercise);
            return "Exercise with ID " + exerciseId + " has been marked as completed: " + isCompleted;
        } else {
            return "The 'isCompleted' parameter is null or missing.";
        }
    }

}

