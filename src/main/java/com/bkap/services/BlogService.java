package com.bkap.services;

import java.util.List;

import com.bkap.entities.Blog;

public interface BlogService {
	List<Blog> findAll();

	Blog findId(int id);

	List<Blog> findByName(String name);

	Blog save(Blog b);

	Blog update(Blog b);

	void remove(int id);
}
