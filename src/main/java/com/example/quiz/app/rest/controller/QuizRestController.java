package com.example.quiz.app.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.quiz.app.service.QuizService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class QuizRestController {

	@Autowired
	QuizService quizService;
	
	@GetMapping("/get-quiz-data")
	public ResponseEntity<?> getByTypeCategoryAndDifficulty(@RequestParam("type") String type,@RequestParam("category") String category,@RequestParam("difficulty") String difficulty,@RequestParam("subCategory") String subCategory,@RequestParam("limit") String limit){
		return new ResponseEntity(quizService.getByTypeCategoryAndDifficulty(type,category,difficulty,subCategory,limit),HttpStatus.OK);
	}
}
