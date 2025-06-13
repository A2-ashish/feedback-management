package com.example.feedbackmanagement.service;

import com.example.feedbackmanagement.model.Feedback;
import com.example.feedbackmanagement.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    // Create or update feedback
    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    // Get all feedback
    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    // Get feedback by ID
    public Optional<Feedback> getById(Long id) {
        return feedbackRepository.findById(id);
    }

    // Get feedback by course ID
    public List<Feedback> getByCourseId(Long courseId) {
        return feedbackRepository.findByCourseId(courseId);
    }

    // Delete feedback
    public void deleteById(Long id) {
        feedbackRepository.deleteById(id);
    }
}
