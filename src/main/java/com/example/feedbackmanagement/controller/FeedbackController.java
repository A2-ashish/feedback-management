package com.example.feedbackmanagement.controller;

import com.example.feedbackmanagement.model.Feedback;
import com.example.feedbackmanagement.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    // Home page
    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    // List all feedbacks
    @GetMapping("/feedbacks")
    public String listFeedbacks(Model model) {
        List<Feedback> feedbacks = feedbackService.getAllFeedback();
        model.addAttribute("feedbacks", feedbacks);
        return "feedback-list";
    }

    // Show form to create new feedback
    @GetMapping("/feedback/new")
    public String showCreateForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "feedback-form";
    }

    // Handle form submission (create or update)
    @PostMapping("/feedback")
    public String saveFeedback(@ModelAttribute Feedback feedback) {
        feedbackService.saveFeedback(feedback);
        return "redirect:/feedbacks";
    }

    // View single feedback by ID
    @GetMapping("/find-feedback")
    public String getFeedbackById(@RequestParam Long feedbackId, Model model) {
        Feedback feedback = feedbackService.getById(feedbackId).orElse(null);
        model.addAttribute("feedback", feedback);
        return "feedback-detail";
    }

    // View feedback by course ID
    @GetMapping("/find-feedbacks-by-course")
    public String getFeedbackByCourse(@RequestParam Long courseId, Model model) {
        List<Feedback> feedbacks = feedbackService.getByCourseId(courseId);
        model.addAttribute("feedbacks", feedbacks);
        return "feedback-list";
    }

    // Show form to edit feedback
    @GetMapping("/feedback/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Feedback feedback = feedbackService.getById(id).orElse(null);
        model.addAttribute("feedback", feedback);
        return "feedback-form";
    }

    // Delete feedback
    @GetMapping("/feedback/delete/{id}")
    public String deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteById(id);
        return "redirect:/feedbacks";
    }


}
