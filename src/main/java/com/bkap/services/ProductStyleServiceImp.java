package com.bkap.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bkap.entities.ProductStyle;
import com.bkap.reponsitories.ProductStyleRespository;

@Service
public class ProductStyleServiceImp implements ProductStyleService {
	@Autowired
	private ProductStyleRespository productStyleRespository;

	@Override
	public List<ProductStyle> findAll() {
		// TODO Auto-generated method stub
		return productStyleRespository.findAll();
	}

	@Override
	public ProductStyle findId(int id) {
		// TODO Auto-generated method stub
		return productStyleRespository.getById(id);
	}

	@Override
	public ProductStyle save(ProductStyle ps) {
		// TODO Auto-generated method stub
		return productStyleRespository.save(ps);
	}

	@Override
	public ProductStyle update(ProductStyle ps) {
		// TODO Auto-generated method stub
		return productStyleRespository.save(ps);
	}

	@Override
	public void remove(int id) {
		productStyleRespository.deleteById(id);
	}

	@Override
	public List<ProductStyle> getStyleByProId(int id) {
		// TODO Auto-generated method stub
		return productStyleRespository.getStyleByProId(id);
	}

	@Override
	public List<ProductStyle> getProStyle(Pageable pageable) {
		// TODO Auto-generated method stub
		return productStyleRespository.getProStyle(pageable);
	}

	@Override
	public int countProductStyle() {
		// TODO Auto-generated method stub
		return productStyleRespository.countProductStyle();
	}

}
