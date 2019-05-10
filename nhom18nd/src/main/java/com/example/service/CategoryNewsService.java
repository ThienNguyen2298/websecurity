package com.example.service;

import com.example.model.CategoryNews;

public interface CategoryNewsService {
	//get
	Iterable<CategoryNews> findAll();
	//get 1 object by Id
	CategoryNews findOne(Integer id);
	//
	void save (CategoryNews c);
	//
	void delete (Integer id);
	
	
}
