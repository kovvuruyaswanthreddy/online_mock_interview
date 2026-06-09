package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Answer;
import com.example.demo.repository.AnswerRepository;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    public Answer saveAnswer(Answer answer) {

        answer.setCreatedAt(LocalDateTime.now());

        return answerRepository.save(answer);
    }
}