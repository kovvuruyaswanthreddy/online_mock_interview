package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Interview;
import com.example.demo.entity.User;
import com.example.demo.repository.InterviewRepository;
import com.example.demo.repository.UserRepository;

@Service
public class InterviewService {

    @Autowired
    private InterviewRepository interviewRepository;

    @Autowired
    private UserRepository userRepository;

    public Interview startInterview(Interview interview) {

        if (interview.getUserId() == null) {
            return null;
        }

        User user = userRepository
                .findById(interview.getUserId())
                .orElse(null);

        if (user == null) {
            return null;
        }

        LocalDateTime startTime = LocalDateTime.now();

        interview.setStartTime(startTime);

        interview.setEndTime(
                startTime.plusMinutes(
                        interview.getDuration()));

        interview.setStatus("IN_PROGRESS");

        return interviewRepository.save(interview);
    }

    public Interview getInterviewById(Long interviewId) {

            return interviewRepository
                    .findById(interviewId)
                    .orElse(null);
    }

    public Interview completeInterview(Long interviewId) {

        Interview interview =
                interviewRepository
                        .findById(interviewId)
                        .orElse(null);

        if (interview == null) {
            return null;
        }

        interview.setStatus("COMPLETED");

        return interviewRepository.save(
                interview);
    }
}