    package com.example.demo.dto;

    public class GenerateQuestionRequestDto {

        private String interviewType;
        private String domain;
        private String level;

        public GenerateQuestionRequestDto() {
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
        public String getLevel() {
            return level;
        }
        public void setLevel(String level) {
            this.level = level;
        }
    }