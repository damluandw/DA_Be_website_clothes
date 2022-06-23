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
@Table(name = "Style")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Style {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "StyleId")
	private int id;
	@Column(name = "StyleName")
	private String style;
	@Column(name = "Description")
	private String description;
	@Column(name = "Status")
	private boolean status;

	@OneToMany(mappedBy = "style", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<ProductStyle> stylePs;

	public Style() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Style(int id, String style, String description, boolean status, List<ProductStyle> stylePs) {
		super();
		this.id = id;
		this.style = style;
		this.description = description;
		this.status = status;
		this.stylePs = stylePs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
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

	public List<ProductStyle> getStylePs() {
		return stylePs;
	}

	public void setStylePs(List<ProductStyle> stylePs) {
		this.stylePs = stylePs;
	}

}
