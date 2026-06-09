package com.example.demo.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.GenerateQuestionDto;
import com.example.demo.dto.QuestionResponseDto;
import com.example.demo.entity.Interview;
import com.example.demo.service.GeminiService;
import com.example.demo.service.InterviewService;
import com.example.demo.service.QuestionService;

@RestController
@RequestMapping("/interview")
public class QuestionController {

    @Autowired
    private InterviewService interviewService;

    @Autowired
    private GeminiService geminiService;

    @Autowired
    private QuestionService questionService;

    @PostMapping("/question")
    public Object generateQuestion(
            @RequestBody GenerateQuestionDto dto) {

        Interview interview =
                interviewService.getInterviewById(
                        dto.getInterviewId());

        if (interview == null) {
            return "Interview not found";
        }
        if (interview.getEndTime() != null &&
                    LocalDateTime.now().isAfter(
                            interview.getEndTime())) {

                return "Interview Completed";
        }

        String question =
                geminiService.generateQuestion(
                                interview.getInterviewType(),
                                interview.getDomain(),
                                interview.getLevel());

        questionService.saveQuestion(
                                        interview.getId(),
                                        dto.getQuestionNumber(),
                                        question);

        QuestionResponseDto response =
                new QuestionResponseDto();

        response.setQuestion(question);

        return response;
    }
}