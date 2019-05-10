package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.Comments;

@Repository
public interface CommentsRepository extends CrudRepository<Comments, Integer> {
	@Query("SELECT c FROM Comments c WHERE c.newsDetails.id= :id")
	List<Comments> findAllCommentsByNewsDetails(@Param("id") int id);
}
