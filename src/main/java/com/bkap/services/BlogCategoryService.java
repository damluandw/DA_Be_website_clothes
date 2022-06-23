package com.bkap.services;

import java.util.List;

import com.bkap.entities.BlogCategory;

public interface BlogCategoryService {
	List<BlogCategory> findAll();

	BlogCategory findId(int id);

	BlogCategory save(BlogCategory b);

	BlogCategory update(BlogCategory b);

	void remove(int id);
}
