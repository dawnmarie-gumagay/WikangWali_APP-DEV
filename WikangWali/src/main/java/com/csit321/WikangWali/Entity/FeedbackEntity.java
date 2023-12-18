package com.csit321.WikangWali.Entity;

import javax.persistence.*;

@Entity
@Table(name = "tblfeedback")
public class FeedbackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private Long feedbackId;

    @Column(name = "email")
    private String email;
    

    @Column(name = "feedback_message")
    private String feedbackMessage;

    @Column(name = "parent_name")
    private String parentName;  // Changed from parentId


   

    // Other fields for feedback, etc.

    public FeedbackEntity() {
        // Default constructor
    }

    public FeedbackEntity(String parentName, String email, String feedbackMessage) {
        this.parentName = parentName;
        this.email = email;
        this.feedbackMessage = feedbackMessage;
        // Initialize other fields as needed
    }

    // Getters and Setters

    public Long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFeedbackMessage() {
        return feedbackMessage;
    }

    public void setFeedbackMessage(String feedbackMessage) {
        this.feedbackMessage = feedbackMessage;
    }

    // Add getters and setters for other fields as needed

    // toString() method for debugging or logging
    @Override
    public String toString() {
        return "FeedbackEntity{" +
                "feedbackId=" + feedbackId +
                ", parentName='" + parentName + '\'' +
                ", email='" + email + '\'' +
                ", feedbackMessage='" + feedbackMessage + '\'' +
                // Add other fields to the string representation
                '}';
    }
}
