package com.example.quiz.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.example.quiz.app.entity.Question;


@Repository("questionRepository")
public interface QuestionsRepository extends JpaRepositoryImplementation<Question, Long> {

	@Query("select quest from Question quest where quest.type =:type and quest.category=:category and quest.difficulty=:difficulty and quest.subCategory=:subCategory")
	List<Question> findByTypeCategoryAndDifficulty(String type, String category, String difficulty,String subCategory);

}
