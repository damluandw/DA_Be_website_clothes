package com.bkap.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bkap.entities.BlogCategory;
import com.bkap.reponsitories.BlogCategoryRespository;

@Service
public class BlogCategoryServiceImp implements BlogCategoryService {
	@Autowired
	private BlogCategoryRespository blogCategoryRespository;

	@Override
	public List<BlogCategory> findAll() {
		// TODO Auto-generated method stub
		return blogCategoryRespository.findAll();
	}

	@Override
	public BlogCategory findId(int id) {
		// TODO Auto-generated method stub
		return blogCategoryRespository.getById(id);
	}

	@Override
	public BlogCategory save(BlogCategory b) {
		// TODO Auto-generated method stub
		return blogCategoryRespository.save(b);
	}

	@Override
	public BlogCategory update(BlogCategory b) {
		// TODO Auto-generated method stub
		return blogCategoryRespository.save(b);
	}

	@Override
	public void remove(int id) {
		blogCategoryRespository.deleteById(id);
	}

}
