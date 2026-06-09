package com.example.demo.dto;

public class InterviewReportDto {

    private Long interviewId;
    private Integer questionsAnswered;
    private Double averageScore;
    private Double bestScore;
    private Double worstScore;

    public Long getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(Long interviewId) {
        this.interviewId = interviewId;
    }

    public Integer getQuestionsAnswered() {
        return questionsAnswered;
    }

    public void setQuestionsAnswered(Integer questionsAnswered) {
        this.questionsAnswered = questionsAnswered;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }

    public Double getBestScore() {
        return bestScore;
    }

    public void setBestScore(Double bestScore) {
        this.bestScore = bestScore;
    }

    public Double getWorstScore() {
        return worstScore;
    }

    public void setWorstScore(Double worstScore) {
        this.worstScore = worstScore;
    }
}