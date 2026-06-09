package com.example.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.example.demo.dto.EvaluationResponseDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.example.demo.dto.EvaluationResponseDto;

@Service
public class GeminiService {

    @Value("${gemini.api.key}")
    private String apiKey;

    @Autowired
    private RestClient restClient;

    public EvaluationResponseDto evaluateAnswer(
                                                String question,
                                                String answer) {

        EvaluationResponseDto response =
                new EvaluationResponseDto();

        response.setScore(8.0);
        response.setFeedback(
                "Good answer. Needs more technical depth.");

        return response;
    }

    public String generateQuestion(String interviewType,
                                   String domain,
                                   String level) {


        return "Explain the internal working of HashMap in Java.";
   }
}