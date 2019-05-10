package com.example.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.News;
import java.util.List;

@Repository
public interface NewsRepository extends CrudRepository<News, Integer> {
	@Query("SELECT e FROM News e")
	List<News> findAlll();
	
	@Query("SELECT e FROM News e WHERE e.author.id = :id")
	List<News> findAllByAuthor(@Param("id") Integer id);
	
	@Query("SELECT e FROM News e WHERE e.categoryNews.id = :id")
	List<News> findAllByCategoryNewsId(@Param("id") Integer id);
	
	
	
}
