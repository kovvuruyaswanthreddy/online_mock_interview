package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Interview;

public interface InterviewRepository extends JpaRepository<Interview, Long> {

}