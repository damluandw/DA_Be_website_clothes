package com.bkap.services;

import java.util.List;

import com.bkap.entities.Brand;

public interface BrandService {
	List<Brand> findAll();

	Brand findId(int id);

	List<Brand> findByName(String name);

	Brand save(Brand b);

	Brand update(Brand b);

	void remove(int id);
}
