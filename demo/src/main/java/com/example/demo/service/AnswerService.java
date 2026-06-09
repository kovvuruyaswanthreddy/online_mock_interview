package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AnswerHistoryDto;
import com.example.demo.dto.InterviewReportDto;
import com.example.demo.entity.Answer;
import com.example.demo.repository.AnswerRepository;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.InterviewReportDto;

import com.example.demo.dto.AnswerHistoryDto;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    public Answer saveAnswer(Answer answer) {

        answer.setCreatedAt(LocalDateTime.now());

        return answerRepository.save(answer);
    }

    public InterviewReportDto getInterviewReport( Long interviewId) {

        List<Answer> answers =
                answerRepository.findByInterviewId(
                        interviewId);

        InterviewReportDto report =
                new InterviewReportDto();

        report.setInterviewId(interviewId);

        if (answers.isEmpty()) {

            report.setQuestionsAnswered(0);
            report.setAverageScore(0.0);
            report.setBestScore(0.0);
            report.setWorstScore(0.0);

            return report;
        }

        double total = 0;
        double best = answers.get(0).getScore();
        double worst = answers.get(0).getScore();

        for (Answer answer : answers) {

            total += answer.getScore();

            if (answer.getScore() > best) {
                best = answer.getScore();
            }

            if (answer.getScore() < worst) {
                worst = answer.getScore();
            }
        }

        report.setQuestionsAnswered(
                answers.size());

        report.setAverageScore(
                total / answers.size());

        report.setBestScore(best);

        report.setWorstScore(worst);

        return report;
    }

    public List<AnswerHistoryDto> getInterviewHistory(Long interviewId) {

        List<Answer> answers =
                answerRepository.findByInterviewId(
                        interviewId);

        List<AnswerHistoryDto> history =
                new ArrayList<>();

        for (Answer answer : answers) {

            AnswerHistoryDto dto =
                    new AnswerHistoryDto();

            dto.setQuestionNumber(
                    answer.getQuestionNumber());

            dto.setQuestion(
                    answer.getQuestion());

            dto.setAnswer(
                    answer.getAnswer());

            dto.setScore(
                    answer.getScore());

            dto.setFeedback(
                    answer.getFeedback());

            history.add(dto);
        }

        return history;
    }
}