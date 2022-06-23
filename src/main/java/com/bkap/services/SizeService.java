package com.bkap.services;

import java.util.List;

import com.bkap.entities.Size;

public interface SizeService {
	List<Size> findAll();

	Size findId(int id);

	List<Size> findBySize(String size);
	

	Size save(Size s);

	Size update(Size s);

	void remove(int id);
}
