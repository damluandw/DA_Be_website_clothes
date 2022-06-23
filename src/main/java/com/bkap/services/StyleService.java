package com.bkap.services;

import java.util.List;

import com.bkap.entities.Style;

public interface StyleService {
	List<Style> findAll();

	Style findId(int id);

	List<Style> findByStyle(String style);

	Style save(Style s);

	Style update(Style s);

	void remove(int id);
}
