package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Question;
import com.example.demo.repository.QuestionRepository;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Question saveQuestion(
            Long interviewId,
            Integer questionNumber,
            String questionText) {

        Question question = new Question();

        question.setInterviewId(interviewId);
        question.setQuestionNumber(questionNumber);
        question.setQuestionText(questionText);
        question.setCreatedAt(LocalDateTime.now());

        return questionRepository.save(question);
    }
}