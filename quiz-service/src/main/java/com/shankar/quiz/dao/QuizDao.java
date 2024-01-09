package com.shankar.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shankar.quiz.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz,Integer> {
}
