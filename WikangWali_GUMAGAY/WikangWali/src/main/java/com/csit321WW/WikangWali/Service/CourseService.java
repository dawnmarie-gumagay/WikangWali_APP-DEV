
package com.csit321WW.WikangWali.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csit321WW.WikangWali.Entity.CourseEntity;
import com.csit321WW.WikangWali.Repository.CourseRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    
    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Read (R) - Retrieve course by ID
    public CourseEntity getCourseById(int courseid) throws NoSuchElementException {
        return courseRepository.findById(courseid)
                .orElseThrow(() -> new NoSuchElementException("Course with ID " + courseid + " not found"));
    }
    
    // Retrieve all courses
    public List<CourseEntity> getAllCourses() {
        return courseRepository.findAll();
    }

    // Update (U) - Update course information
    public CourseEntity updateCourse(int courseid, CourseEntity newCourseData) throws NoSuchElementException {
        CourseEntity existingCourse = courseRepository.findById(courseid)
                .orElseThrow(() -> new NoSuchElementException("Course with ID " + courseid + " not found"));

        // Update existingCourse with newCourseData fields
        existingCourse.setCoursename(newCourseData.getCoursename());
        existingCourse.setCoursedescription(newCourseData.getCoursedescription());
        existingCourse.setCourselevel(newCourseData.getCourselevel()); 

        return courseRepository.save(existingCourse);
    }

    // Custom business logic - Start a course
    public String startCourse(int courseid) throws NoSuchElementException {
        return "Course with ID " + courseid + " has started";
    }

    // Custom business logic - Mark a course as completed with a boolean status
    public String markCourseAsCompleted(int courseid, boolean isCompleted) throws NoSuchElementException {
        CourseEntity course = courseRepository.findById(courseid)
                .orElseThrow(() -> new NoSuchElementException("Course with ID " + courseid + " not found"));
        
        // Set the course as completed using the isCompleted field
        course.setCompleted(isCompleted);
        courseRepository.save(course);
        
        return "Course with ID " + courseid + " has been marked as completed: " + isCompleted;
    }
}