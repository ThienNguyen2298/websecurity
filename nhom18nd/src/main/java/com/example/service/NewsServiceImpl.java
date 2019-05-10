package com.example.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.News;
import com.example.repository.NewsRepository;
@Service("newsService")
@Transactional
public class NewsServiceImpl implements NewsService{
	@Autowired
	private NewsRepository newsRepository;

	@Override
	public Iterable<News> findAll() {
		// TODO Auto-generated method stub
		return newsRepository.findAlll();
	}

	

	@Override
	public News findOne(Integer id) {
		// TODO Auto-generated method stub
		return newsRepository.findById(id).orElse(null);
	}

	@Override
	public void saveNews(News n) {
		// TODO Auto-generated method stub
		newsRepository.save(n);
	}

	@Override
	public void deleteNews(Integer id) {
		// TODO Auto-generated method stub
		newsRepository.deleteById(id);
	}



	@Override
	public List<News> findAllByAuthor(Integer id) {
		// TODO Auto-generated method stub
		return newsRepository.findAllByAuthor(id);
	}



	@Override
	public List<News> findAllByCategoryNewsId(Integer id) {
		// TODO Auto-generated method stub
		return newsRepository.findAllByCategoryNewsId(id);
	}



	



	



	



	
}
