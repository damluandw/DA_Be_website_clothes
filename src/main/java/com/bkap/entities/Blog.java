package com.bkap.entities;

import java.util.Date;
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
@Table(name = "Blog")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Blog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BlogId")
	private int id;
	@Column(name = "BlogTitle")
	private String title;
	@Column(name = "BlogContent")
	private String content;
	@Column(name = "Author")
	private String author;
	@Column(name = "Description")
	private String description;
	@Column(name = "FeatureImg")
	private String image;
	@Column(name = "Imgs")
	private String images;
	@Column(name = "CreateDate")
	private Date createDate;
	@Column(name = "ShowHome")
	private boolean showHome;
	@Column(name = "Status")
	private boolean status;
	@OneToMany(mappedBy = "blog", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<BlogCategory> categories;

	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Blog(int id, String title, String content, String author, String description, String image, String images,
			Date createDate, boolean showHome, boolean status, List<BlogCategory> categories) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.description = description;
		this.image = image;
		this.images = images;
		this.createDate = createDate;
		this.showHome = showHome;
		this.status = status;
		this.categories = categories;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public boolean isShowHome() {
		return showHome;
	}

	public void setShowHome(boolean showHome) {
		this.showHome = showHome;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<BlogCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<BlogCategory> categories) {
		this.categories = categories;
	}

}
