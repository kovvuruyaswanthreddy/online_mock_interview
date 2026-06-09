package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.EvaluationResponseDto;
import com.example.demo.dto.SubmitAnswerDto;
import com.example.demo.entity.Answer;
import com.example.demo.service.GeminiService;

import com.example.demo.service.AnswerService;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private GeminiService geminiService;

    @Autowired
    private AnswerService answerService;

    @PostMapping("/submit")
    public EvaluationResponseDto submitAnswer(
            @RequestBody SubmitAnswerDto dto) {

        EvaluationResponseDto response =
                geminiService.evaluateAnswer(
                        dto.getQuestion(),
                        dto.getAnswer());

        Answer answer = new Answer();

        answer.setInterviewId(dto.getInterviewId());
        answer.setQuestionNumber(dto.getQuestionNumber());
        answer.setQuestion(dto.getQuestion());
        answer.setAnswer(dto.getAnswer());
        answer.setScore(response.getScore());
        answer.setFeedback(response.getFeedback());

        answerService.saveAnswer(answer);

        return response;
    }
}