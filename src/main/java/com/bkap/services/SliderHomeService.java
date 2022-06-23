package com.bkap.services;

import java.util.List;

import com.bkap.entities.SliderHome;

public interface SliderHomeService {
	List<SliderHome> findAll();

	SliderHome findId(int id);

	SliderHome save(SliderHome s);

	SliderHome update(SliderHome s);

	void remove(int id);
}
