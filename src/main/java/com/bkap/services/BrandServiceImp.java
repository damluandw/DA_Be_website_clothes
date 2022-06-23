package com.bkap.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bkap.entities.Brand;
import com.bkap.reponsitories.BrandRespository;

@Service
public class BrandServiceImp implements BrandService {
	@Autowired
	private BrandRespository brandRespository;

	@Override
	public List<Brand> findAll() {
		// TODO Auto-generated method stub
		return brandRespository.findAll();
	}

	@Override
	public Brand findId(int id) {
		// TODO Auto-generated method stub
		return brandRespository.getById(id);
	}

	@Override
	public List<Brand> findByName(String name) {
		// TODO Auto-generated method stub
		return brandRespository.findByName(name);
	}

	@Override
	public Brand save(Brand b) {
		// TODO Auto-generated method stub
		return brandRespository.save(b);
	}

	@Override
	public Brand update(Brand b) {
		// TODO Auto-generated method stub
		return brandRespository.save(b);
	}

	@Override
	public void remove(int id) {
		brandRespository.deleteById(id);
	}
}
