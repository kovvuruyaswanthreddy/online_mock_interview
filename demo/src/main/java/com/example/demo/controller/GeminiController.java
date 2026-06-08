package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.GeminiRequestDto;
import com.example.demo.service.GeminiService;

@RestController
@RequestMapping("/gemini")
public class GeminiController {

    @Autowired
    private GeminiService geminiService;

    @PostMapping("/question")
    public String generateQuestion(
            @RequestBody GeminiRequestDto dto) {

        return geminiService.generateQuestion(
                dto.getInterviewType(),
                dto.getDomain());
    }
}