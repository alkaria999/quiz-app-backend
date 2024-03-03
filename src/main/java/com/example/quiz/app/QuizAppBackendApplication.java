package com.example.quiz.app;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.example.quiz.app.constant.Constant;
import com.example.quiz.app.entity.Question;
import com.example.quiz.app.service.QuizService;

@SpringBootApplication
public class QuizAppBackendApplication {
	
	@Autowired
	QuizService quizService;

	private static final Logger log = LoggerFactory.getLogger(QuizAppBackendApplication.class);
	public static void main(String[] args) throws UnknownHostException {
		SpringApplication app = new SpringApplication(QuizAppBackendApplication.class);
		Environment env = app.run(args).getEnvironment();
		log.info("\n----------------------------------------------------------\n\t" +
				"Application '{}' is running! Access URLs:\n\t" +
				"Local: \t\thttp://localhost:{}\n\t" +
				"External: \thttp://{}:{}\n\t" +
				"Profile(s): \t{}"
				+ "\n----------------------------------------------------------",
				env.getProperty("spring.application.name"),
				env.getProperty("server.port"),
				InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port"),
				env.getActiveProfiles());
	}
	
	@Bean
	String getQuizDemoData(){
		for(int i=1001;i<=1010;i++) {
			Question question = new Question();
			//question.setId((long) i);
			question.setType(Constant.TYPE_MCQ);
			question.setDifficulty(Constant.DIFFICULTY_EASY);
			question.setCategory(Constant.CATEGORY_TECHNICAL);
			question.setSubCategory("JAVA");
			question.setQuestion("Who is the founder of Java?");
			question.setCorrectAnswer("James G Ghosling");
			question.setIncorrectAnswers("Tanim,Sima,Alkaria");
			quizService.insertQuizData(question);
		}
		
		for(int i=1001;i<=1010;i++) {
			Question question = new Question();
			//question.setId((long) i);
			question.setType(Constant.TYPE_MCQ);
			question.setDifficulty(Constant.DIFFICULTY_EASY);
			question.setCategory(Constant.CATEGORY_TECHNICAL);
			question.setSubCategory("HTML");
			question.setQuestion("What is HTML?");
			question.setCorrectAnswer("Hyper Text Markup Language");
			question.setIncorrectAnswers("Tanim,Sima,Alkaria");
			quizService.insertQuizData(question);
		}
		return "Successfully inserted";
	}

}
