package com.example.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.NewsDetails;
import com.example.repository.NewsDetailsRepository;

@Service
@Transactional
public class NewsDetailsServiceImpl implements NewsDetailsService{
	@Autowired
	private NewsDetailsRepository newsDetailsRepository;
	
	@Override
	public Iterable<NewsDetails> findAll() {
		// TODO Auto-generated method stub
		return newsDetailsRepository.findAll();
	}

	@Override
	public NewsDetails findOne(Integer id) {
		// TODO Auto-generated method stub
		return newsDetailsRepository.findById(id).orElse(null);
	}

	@Override
	public void save(NewsDetails d) {
		// TODO Auto-generated method stub
		newsDetailsRepository.save(d);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		newsDetailsRepository.deleteById(id);
	}

	@Override
	public NewsDetails findNewsDetailsByIdNews(Integer idnews) {
		// TODO Auto-generated method stub
		return newsDetailsRepository.findNewsDetailsByIdNews(idnews);
	}

}
