package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.CategoryNews;
import com.example.repository.CategoryNewsRepository;

@Service
public class CategoryNewsServiceImpl implements CategoryNewsService{
	
	@Autowired
	private CategoryNewsRepository categoryNewsService;

	@Override
	public Iterable<CategoryNews> findAll() {
		// TODO Auto-generated method stub
		return categoryNewsService.findAll();
	}

	@Override
	public CategoryNews findOne(Integer id) {
		// TODO Auto-generated method stub
		return categoryNewsService.findById(id).orElse(null);
	}

	@Override
	public void save(CategoryNews c) {
		// TODO Auto-generated method stub
		categoryNewsService.save(c);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		categoryNewsService.deleteById(id);
	}

	
}
