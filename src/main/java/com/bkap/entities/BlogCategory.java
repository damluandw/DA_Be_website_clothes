package com.bkap.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Blog_Category")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class BlogCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CategoryBlogId")
	private int id;
	@ManyToOne
	@JoinColumn(name = "BlogId", referencedColumnName = "BlogId")
	private Blog blog;
	@ManyToOne
	@JoinColumn(name = "CategoryId", referencedColumnName = "CategoryId")
	private Category category;

	public BlogCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BlogCategory(int id, Blog blog, Category category) {
		super();
		this.id = id;
		this.blog = blog;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
