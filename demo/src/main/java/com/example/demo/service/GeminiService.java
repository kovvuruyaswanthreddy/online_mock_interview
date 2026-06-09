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

        String prompt = """
                You are a professional interviewer.

                Interview Type: %s
                Domain: %s
                Difficulty Level: %s

                Ask exactly ONE interview question.

                Rules:
                - Ask only one question.
                - Do not provide explanation.
                - Do not provide answer.
                - Return only the question.
                """
                .formatted(interviewType, domain, level);

        String url =
        "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key="
                + apiKey;

        Map<String, Object> requestBody =
                Map.of(
                        "contents",
                        new Object[] {
                                Map.of(
                                        "parts",
                                        new Object[] {
                                                Map.of("text", prompt)
                                        })
                        });

        try {

            String response =
                    restClient.post()
                            .uri(url)
                            .body(requestBody)
                            .retrieve()
                            .body(String.class);

            System.out.println("Gemini Response:");
            System.out.println(response);

            ObjectMapper mapper = new ObjectMapper();

            JsonNode root = mapper.readTree(response);

            return root
                    .path("candidates")
                    .get(0)
                    .path("content")
                    .path("parts")
                    .get(0)
                    .path("text")
                    .asText();

        } catch (Exception e) {

            System.out.println("ERROR:");
            e.printStackTrace();

            return e.getMessage();
        }
    }
}