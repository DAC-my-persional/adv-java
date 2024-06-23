package com.blog.entity;

import java.time.LocalDateTime;

public class Blog {

	private int id;
	private String title;
	private String contents;
	private int userId;
	private int categoryId;
	LocalDateTime l1 = LocalDateTime.now();
	public Blog()
	{
		
	}

	public Blog(String title, String contents, int userId, int categoryId) {
		//super();
//		this.id = id;
		this.title = title;
		this.contents = contents;
		this.userId = userId;
		this.categoryId = categoryId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	

	public LocalDateTime getL1() {
		return l1;
	}

	public void setL1(LocalDateTime time) {
		this.l1 = time;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", contents=" + contents + ", userId=" + userId + ", categoryId="
				+ categoryId + ", l1=" + l1 + "]";
	}
	
}
