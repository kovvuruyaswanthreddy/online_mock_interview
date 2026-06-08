package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GeminiService {

    @Value("${gemini.api.key}")
    private String apiKey;

    public String generateQuestion(String interviewType,
                                   String domain) {

        System.out.println("API Key Loaded: " + apiKey);

        return "What is Dependency Injection in Spring Boot?";
    }
}