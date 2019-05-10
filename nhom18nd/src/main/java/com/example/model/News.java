package com.example.model;

import java.io.Serializable;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;


import java.util.Date;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="news")

public class News implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name = "id", nullable = false)
	private Integer id_news;
	
	public int getId() {
		return id_news;
	}
	public void setId(int id) {
		this.id_news = id;
	}
	
	@Column(name="name", nullable = false)
	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="image")
	private String image;

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	@Column(name="postday", nullable=false)
	private String postday;

	public String getPostday() {
		return postday;
	}
	public void setPostday(String postday) {
		this.postday = postday;
	}
	
	@OneToOne
	@JoinColumn(name="categorynews")
	private CategoryNews categoryNews;

	public CategoryNews getCategoryNews() {
		return categoryNews;
	}
	public void setCategoryNews(CategoryNews categoryNews) {
		this.categoryNews = categoryNews;
	}

	@OneToOne
	@JoinColumn(name="author")
	private User author;

	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}

	
}
