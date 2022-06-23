package com.bkap.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bkap.entities.Category;
import com.bkap.reponsitories.CategoryRespository;

@Service
public class CategoryServiceImp implements CategoryService {
	@Autowired
	private CategoryRespository categoryRespository;

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryRespository.findAll();
	}

	@Override
	public Category findId(int id) {
		// TODO Auto-generated method stub
		return categoryRespository.getById(id);
	}

	@Override
	public List<Category> findByName(String name) {
		// TODO Auto-generated method stub
		return categoryRespository.findByName(name);
	}

	@Override
	public Category save(Category c) {
		// TODO Auto-generated method stub
		return categoryRespository.save(c);
	}

	@Override
	public Category update(Category c) {
		// TODO Auto-generated method stub
		return categoryRespository.save(c);
	}

	@Override
	public void remove(int id) {
		categoryRespository.deleteById(id);

	}

	@Override
	public List<Category> getShowCategoryProduct() {
		// TODO Auto-generated method stub
		return categoryRespository.getShowCategoryProduct();
	}

	@Override
	public List<Category> getCateByProId(int id) {
		// TODO Auto-generated method stub
		return categoryRespository.getCategoryByProId(id);
	}

}
