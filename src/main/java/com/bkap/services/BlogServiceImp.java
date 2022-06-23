package com.bkap.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bkap.entities.Blog;
import com.bkap.reponsitories.BlogRespository;

@Service
public class BlogServiceImp implements BlogService {
	@Autowired
	private BlogRespository blogRespository;

	@Override
	public List<Blog> findAll() {
		// TODO Auto-generated method stub
		return blogRespository.findAll();
	}

	@Override
	public Blog findId(int id) {
		// TODO Auto-generated method stub
		return blogRespository.getById(id);
	}

	@Override
	public List<Blog> findByName(String name) {
		return blogRespository.findByName(name);
	}

	@Override
	public Blog save(Blog b) {
		// TODO Auto-generated method stub
		return blogRespository.save(b);
	}

	@Override
	public Blog update(Blog b) {
		// TODO Auto-generated method stub
		return blogRespository.save(b);
	}

	@Override
	public void remove(int id) {
		blogRespository.deleteById(id);

	}

}
