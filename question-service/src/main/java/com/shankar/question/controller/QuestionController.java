package com.shankar.question.controller;


import com.shankar.question.model.Question;
import com.shankar.question.model.QuestionWrapper;
import com.shankar.question.model.Response;
import com.shankar.question.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
//question service starts here
    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }
    
    @GetMapping("sayHi")
    public String sayHi() {
    	return "hi";
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return  questionService.addQuestion(question);
    }
    
    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz (@RequestParam String categoryName, @RequestParam Integer numQuestions){
    	return questionService.getQuestionsForQuiz(categoryName,numQuestions);
    }
    
    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromID(@RequestBody List<Integer> questionIds){
    	return questionService.getQuestionsById(questionIds);
    }
    
    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> response){
    	
    	return questionService.getScore(response);
    }
    

}
