package com.example.demo.dto;

public class GeminiRequestDto {

    private String interviewType;
    private String domain;

    public GeminiRequestDto() {
    }

    public String getInterviewType() {
        return interviewType;
    }

    public void setInterviewType(String interviewType) {
        this.interviewType = interviewType;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}