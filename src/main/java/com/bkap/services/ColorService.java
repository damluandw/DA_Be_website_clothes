package com.bkap.services;

import java.util.List;

import com.bkap.entities.Color;

public interface ColorService {
	List<Color> findAll();

	Color findId(int id);

	List<Color> findByColor(String color);

	Color save(Color c);

	Color update(Color c);

	void remove(int id);
}
