package com.example.demo.dto;

public class StartInterviewResponseDto {

    private Long interviewId;
    private String status;

    public StartInterviewResponseDto() {
    }

    public Long getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(Long interviewId) {
        this.interviewId = interviewId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}