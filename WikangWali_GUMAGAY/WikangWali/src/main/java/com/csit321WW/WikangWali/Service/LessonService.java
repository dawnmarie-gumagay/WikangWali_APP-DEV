package com.csit321WW.WikangWali.Service;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csit321WW.WikangWali.Entity.LessonEntity;
import com.csit321WW.WikangWali.Repository.LessonRepository;

@Service
public class LessonService {
	
    private final LessonRepository lessonRepository;
    
    @Autowired
    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }
    
    // Create (C) - Add a new lesson
    public LessonEntity createLesson(LessonEntity lesson) {
        return lessonRepository.save(lesson);
    }

    // Read (R) - Retrieve lesson by ID
    public LessonEntity getLessonById(int lessonid) throws NoSuchElementException {
        return lessonRepository.findById(lessonid)
                .orElseThrow(() -> new NoSuchElementException("Lesson with ID " + lessonid + " not found"));
    }
    
    // Update (U) - Update lesson information
    public LessonEntity updateLesson(int lessonid, LessonEntity newLessonData) throws NoSuchElementException {
        LessonEntity existingLesson = lessonRepository.findById(lessonid)
                .orElseThrow(() -> new NoSuchElementException("Lesson with ID " + lessonid + " not found"));

        // Update existingLesson with newLessonData fields
        existingLesson.setLessontitle(newLessonData.getLessontitle());
        existingLesson.setLessoncontent(newLessonData.getLessoncontent());
        existingLesson.setCourseid(newLessonData.getCourseid());
          
        return lessonRepository.save(existingLesson);
    }
    
    // Custom business logic - Start lessons for a course
    public String startLessons(int courseid) throws NoSuchElementException {
        return "Lessons for course with ID " + courseid + " have started";
    }

    // Custom business logic - Mark lesson as completed
    public String markLessonAsCompleted(int lessonid, boolean isCompleted) throws NoSuchElementException {
        LessonEntity lesson = lessonRepository.findById(lessonid)
                .orElseThrow(() -> new NoSuchElementException("Lesson with ID " + lessonid + " not found"));
        
        // Set the lesson as completed using the isCompleted field
        lesson.setCompleted(isCompleted);
        lessonRepository.save(lesson);
        
        return "Lesson with ID " + lessonid + " has been marked as completed: " + isCompleted;
    }
}