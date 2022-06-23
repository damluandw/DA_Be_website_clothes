package com.bkap.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bkap.entities.ProductFavorite;
import com.bkap.reponsitories.ProductFavoriteRespository;

@Service
public class ProductFavoriteServiceImp implements ProductFavoriteService {
	@Autowired
	private ProductFavoriteRespository productFavoriteRespository;

	@Override
	public List<ProductFavorite> findAll() {
		// TODO Auto-generated method stub
		return productFavoriteRespository.findAll();
	}

	@Override
	public ProductFavorite findId(int id) {
		// TODO Auto-generated method stub
		return productFavoriteRespository.getById(id);
	}

	@Override
	public ProductFavorite save(ProductFavorite pf) {
		// TODO Auto-generated method stub
		return productFavoriteRespository.save(pf);
	}

	@Override
	public ProductFavorite update(ProductFavorite pf) {
		// TODO Auto-generated method stub
		return productFavoriteRespository.save(pf);
	}

	@Override
	public void remove(int id) {
		productFavoriteRespository.deleteById(id);

	}
}
