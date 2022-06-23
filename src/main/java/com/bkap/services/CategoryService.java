package com.bkap.services;

import java.util.List;

import com.bkap.entities.Category;

public interface CategoryService {
	List<Category> findAll();
	
	List<Category> getShowCategoryProduct();

	Category findId(int id);

	List<Category> findByName(String name);
	
	List<Category> getCateByProId(int id);

	Category save(Category c);

	Category update(Category c);

	void remove(int id);

}
