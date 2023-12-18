package com.csit321.WikangWali.Entity;

import javax.persistence.*;

@Entity
@Table(name = "tblstudent")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "progress_tracker")
    private String progressTracker;

    @Column(name = "course_progress")
    private String courseProgress;

    // Other fields as needed

    // Constructors

    public StudentEntity() {
        // Default constructor
    }

    public StudentEntity(String firstName, String lastName, String progressTracker, String courseProgress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.progressTracker = progressTracker;
        this.courseProgress = courseProgress;
        // Initialize other fields as needed
    }

    // Getters and Setters

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProgressTracker() {
        return progressTracker;
    }

    public void setProgressTracker(String progressTracker) {
        this.progressTracker = progressTracker;
    }

    public String getCourseProgress() {
        return courseProgress;
    }

    public void setCourseProgress(String courseProgress) {
        this.courseProgress = courseProgress;
    }

    // Add getters and setters for other fields as needed

    // toString() method for debugging or logging

    @Override
    public String toString() {
        return "StudentEntity{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", progressTracker='" + progressTracker + '\'' +
                ", courseProgress='" + courseProgress + '\'' +
                // Add other fields to the string representation
                '}';
    }
}
