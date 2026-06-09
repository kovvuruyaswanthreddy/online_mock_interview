package com.example.demo.dto;

public class EvaluationResponseDto {

    private Double score;
    private String feedback;

    public EvaluationResponseDto() {
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}