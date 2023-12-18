package com.csit321.WikangWali.Service;

import com.csit321.WikangWali.Entity.FeedbackEntity;
import com.csit321.WikangWali.Repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FeedbackService {

    @Autowired
    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public FeedbackEntity saveFeedback(FeedbackEntity feedback) {
        return feedbackRepository.save(feedback);
    }

    public List<FeedbackEntity> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    public FeedbackEntity updateFeedback(Long feedbackId, FeedbackEntity newFeedbackDetails) {
        FeedbackEntity feedback = getFeedbackById(feedbackId);
        // Update relevant details from newFeedbackDetails
        // For example:
        feedback.setParentName(newFeedbackDetails.getParentName());
        feedback.setEmail(newFeedbackDetails.getEmail());
        feedback.setFeedbackMessage(newFeedbackDetails.getFeedbackMessage());
        // Update other fields as needed
        return feedbackRepository.save(feedback);
    }

    public String deleteFeedback(Long feedbackId) {
        if (feedbackRepository.existsById(feedbackId)) {
            feedbackRepository.deleteById(feedbackId);
            return "Feedback " + feedbackId + " is successfully deleted!";
        } else {
            return "Feedback " + feedbackId + " does not exist.";
        }
    }

    private FeedbackEntity getFeedbackById(Long feedbackId) {
        return feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new NoSuchElementException("Feedback " + feedbackId + " does not exist!"));
    }
}
