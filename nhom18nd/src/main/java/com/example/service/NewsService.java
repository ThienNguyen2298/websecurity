package com.example.service;

import com.example.model.News;

import java.util.List;

import org.springframework.data.repository.query.Param;

public interface NewsService {
	Iterable<News> findAll();
	
	News findOne(Integer id);
	
	List<News> findAllByAuthor(Integer id);
	
	List<News> findAllByCategoryNewsId(Integer id);
	
	
	
	void saveNews(News n);
	
	void deleteNews(Integer id);
}
