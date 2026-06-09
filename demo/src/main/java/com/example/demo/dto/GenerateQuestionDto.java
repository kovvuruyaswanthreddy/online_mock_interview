package com.example.demo.dto;

public class GenerateQuestionDto {

    private Long interviewId;

    private Integer questionNumber;
    public GenerateQuestionDto() {
    }

    public Long getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(Long interviewId) {
        this.interviewId = interviewId;
    }
    public Integer getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Integer questionNumber) {
        this.questionNumber = questionNumber;
    }
}