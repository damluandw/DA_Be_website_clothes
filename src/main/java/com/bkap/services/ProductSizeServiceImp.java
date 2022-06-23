package com.bkap.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bkap.entities.ProductSize;
import com.bkap.reponsitories.ProductSizeRespository;

@Service
public class ProductSizeServiceImp implements ProductSizeService {
	@Autowired
	private ProductSizeRespository productSizeRespository;

	@Override
	public List<ProductSize> findAll() {
		// TODO Auto-generated method stub
		return productSizeRespository.findAll();
	}

	@Override
	public ProductSize findId(int id) {
		// TODO Auto-generated method stub
		return productSizeRespository.getById(id);
	}

	@Override
	public ProductSize save(ProductSize ps) {
		// TODO Auto-generated method stub
		return productSizeRespository.save(ps);
	}

	@Override
	public ProductSize update(ProductSize ps) {
		// TODO Auto-generated method stub
		return productSizeRespository.save(ps);
	}

	@Override
	public void remove(int id) {
		productSizeRespository.deleteById(id);
	}

	@Override
	public List<ProductSize> getSizeByProId(int id) {
		// TODO Auto-generated method stub
		return productSizeRespository.getSizeByProId(id);
	}

	@Override
	public List<ProductSize> getProSize(Pageable pageable) {
		// TODO Auto-generated method stub
		return productSizeRespository.getProSize(pageable);
	}

	@Override
	public int countProductSize() {
		// TODO Auto-generated method stub
		return productSizeRespository.countProductSize();
	}

}
