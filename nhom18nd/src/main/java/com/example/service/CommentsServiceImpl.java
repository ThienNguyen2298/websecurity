package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Comments;
import com.example.repository.CommentsRepository;

@Service
public class CommentsServiceImpl implements CommentsService {

	@Autowired
	private CommentsRepository commentsRepository;
	@Override
	public List<Comments> findAllCommentsByNewsDetails(int id) {
		// TODO Auto-generated method stub
		return commentsRepository.findAllCommentsByNewsDetails(id);
	}
	@Override
	public void save(Comments cmt) {
		// TODO Auto-generated method stub
		commentsRepository.save(cmt);
	}

}
