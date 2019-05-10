package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="comments")
public class Comments {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name = "id", nullable = false)
	private Integer id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="content")
	private String content;

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Column(name="usercmt")
	private String usercmt;
	public String getUsercmt() {
		return usercmt;
	}
	public void setUsercmt(String usercmt) {
		this.usercmt = usercmt;
	}

	@OneToOne
	@JoinColumn(name="idnewsdetails")
	private NewsDetails newsDetails;

	public NewsDetails getNewsDetails() {
		return newsDetails;
	}
	public void setNewsDetails(NewsDetails newsDetails) {
		this.newsDetails = newsDetails;
	}
}
