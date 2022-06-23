package com.bkap.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "SliderHome")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class SliderHome {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SliderId")
	private int id;
	@Column(name = "SliderImg")
	private String img;
	@Column(name = "Title")
	private String title;
	@Column(name = "Description")
	private String description;
	@Column(name = "Sale")
	private int sale;
	@Column(name = "CreateDate")
	private Date createDate;
	@Column(name = "DisplayNo")
	private int displayNo;
	@Column(name = "Status")
	private boolean status;

	public SliderHome() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SliderHome(int id, String img, String title, String description, int sale, Date createDate, int displayNo,
			boolean status) {
		super();
		this.id = id;
		this.img = img;
		this.title = title;
		this.description = description;
		this.sale = sale;
		this.createDate = createDate;
		this.displayNo = displayNo;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getDisplayNo() {
		return displayNo;
	}

	public void setDisplayNo(int displayNo) {
		this.displayNo = displayNo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
