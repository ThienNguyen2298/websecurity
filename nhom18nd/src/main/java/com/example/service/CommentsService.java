package com.example.service;

import java.util.List;

import com.example.model.Comments;

public interface CommentsService {
	List<Comments> findAllCommentsByNewsDetails(int id);
	void save(Comments cmt);
}
