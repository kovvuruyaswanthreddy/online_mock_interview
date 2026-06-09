package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.AnswerHistoryDto;
import com.example.demo.dto.InterviewReportDto;
import com.example.demo.service.AnswerService;

import java.util.List;

import com.example.demo.dto.AnswerHistoryDto;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private AnswerService answerService;

    @GetMapping("/{interviewId}")
    public InterviewReportDto getReport(
            @PathVariable Long interviewId) {

        return answerService.getInterviewReport(
                interviewId);
    }

    @GetMapping("/history/{interviewId}")
    public List<AnswerHistoryDto> getHistory(
            @PathVariable Long interviewId) {

        return answerService
                .getInterviewHistory(
                        interviewId);
    }
}