package com.shankar.quiz.service;

import com.shankar.quiz.dao.QuizDao;
import com.shankar.quiz.feign.QuizInterface;
import com.shankar.quiz.model.QuestionWrapper;
import com.shankar.quiz.model.Quiz;
import com.shankar.quiz.model.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

    	List<Integer> questions = quizInterface.getQuestionsForQuiz(category, numQ).getBody();
    	Quiz quiz = new Quiz(); 
    	quiz.setTitle(title); 
    	quiz.setQuestionIds(questions);
    	quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Quiz quiz = quizDao.findById(id).get();
        List<Integer> questionIds = quiz.getQuestionIds();
        
        return quizInterface.getQuestionsFromID(questionIds);

    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
    	
    	return quizInterface.getScore(responses);
    }
}
