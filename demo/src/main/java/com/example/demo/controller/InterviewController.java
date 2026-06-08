package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.StartInterviewDto;
import com.example.demo.entity.Interview;
import com.example.demo.service.InterviewService;

@RestController
@RequestMapping("/interview")
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    @PostMapping("/start")
    public String startInterview(
            @RequestBody StartInterviewDto startInterviewDto) {

        Interview interview = new Interview();

        interview.setUserId(startInterviewDto.getUserId());
        interview.setInterviewType(startInterviewDto.getInterviewType());
        interview.setDomain(startInterviewDto.getDomain());
        interview.setDuration(startInterviewDto.getDuration());

        Interview savedInterview =
                interviewService.startInterview(interview);

        if (savedInterview == null) {
            return "User not found";
        }

        return "Interview started successfully";
    }
}