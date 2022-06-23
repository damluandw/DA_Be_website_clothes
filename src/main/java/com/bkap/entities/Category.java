package com.bkap.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Category")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CategoryId")
	private int id;
	@Column(name = "CategoryName")
	private String name;
	@Column(name = "ParentId")
	private int parentId;
	@Column(name = "ShowCategory")
	private boolean showCategory;
	@Column(name = "Description")
	private String description;
	@Column(name = "Status")
	private boolean status;
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ProductCategory> products;
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<BlogCategory> blogs;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int id, String name, int parentId, boolean showCategory, String description, boolean status,
			List<ProductCategory> products, List<BlogCategory> blogs) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.showCategory = showCategory;
		this.description = description;
		this.status = status;
		this.products = products;
		this.blogs = blogs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public boolean isShowCategory() {
		return showCategory;
	}

	public void setShowcategory(boolean showcategory) {
		this.showCategory = showcategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<ProductCategory> getProducts() {
		return products;
	}

	public void setProducts(List<ProductCategory> products) {
		this.products = products;
	}

	public List<BlogCategory> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<BlogCategory> blogs) {
		this.blogs = blogs;
	}

}
