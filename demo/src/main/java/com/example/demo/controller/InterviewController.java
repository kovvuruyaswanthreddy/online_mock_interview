package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.StartInterviewDto;
import com.example.demo.dto.StartInterviewResponseDto;
import com.example.demo.entity.Interview;
import com.example.demo.service.InterviewService;

@RestController
@RequestMapping("/interview")
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    @PostMapping("/start")
    public Object startInterview(
            @RequestBody StartInterviewDto startInterviewDto) {

        Interview interview = new Interview();

        interview.setUserId(startInterviewDto.getUserId());
        interview.setInterviewType(startInterviewDto.getInterviewType());
        interview.setDomain(startInterviewDto.getDomain());
        interview.setLevel(startInterviewDto.getLevel());
        interview.setDuration(startInterviewDto.getDuration());

        System.out.println("UserId = " +startInterviewDto.getUserId());

        Interview savedInterview =
                interviewService.startInterview(interview);

        if (savedInterview == null) {
            return "User not found";
        }

        StartInterviewResponseDto response =
                new StartInterviewResponseDto();

        response.setInterviewId(savedInterview.getId());
        response.setStatus(savedInterview.getStatus());

        return response;
    }

    @PostMapping("/complete/{interviewId}")
    public Object completeInterview( @PathVariable Long interviewId) {

        Interview interview =
                interviewService
                        .completeInterview(
                                interviewId);

        if (interview == null) {
            return "Interview not found";
        }

        return "Interview Completed Successfully";
    }
}