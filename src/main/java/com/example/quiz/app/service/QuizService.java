package com.example.quiz.app.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quiz.app.entity.Question;
import com.example.quiz.app.repository.QuestionsRepository;

@Service("quizService")
public class QuizService {
	
	
	private static final Logger log = LoggerFactory.getLogger(QuizService.class);

	
	@Autowired
	QuestionsRepository questionsRepository;
	
	public List<Question> getByTypeCategoryAndDifficulty(String type, String category, String difficulty,String subCategory,String limit){
		log.info("SERVICE :: FETCHING QUIZ DATA RESPONSE FOR "+subCategory);
		List<Question> getQuestions = questionsRepository.findByTypeCategoryAndDifficulty(type, category, difficulty,subCategory)
				.stream().limit(Integer.parseInt(limit)).collect(Collectors.toList());
		return getQuestions;
	}

	public void insertQuizData(Question questions) {
		questionsRepository.save(questions);
		
	}
	
}
