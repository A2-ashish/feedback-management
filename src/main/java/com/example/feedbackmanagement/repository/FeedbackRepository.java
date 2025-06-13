package com.example.feedbackmanagement.repository;

import com.example.feedbackmanagement.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    // Custom query method to find feedbacks by courseId
    List<Feedback> findByCourseId(Long courseId);
}
