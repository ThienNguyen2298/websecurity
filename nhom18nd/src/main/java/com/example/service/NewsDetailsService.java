package com.example.service;

import com.example.model.NewsDetails;

public interface NewsDetailsService {
	Iterable<NewsDetails> findAll();
	
	NewsDetails findOne(Integer id);
	
	NewsDetails findNewsDetailsByIdNews(Integer idnews);
	
	void save(NewsDetails d);
	
	void delete(Integer id);
}
