package com.bkap.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bkap.entities.ProductColor;
import com.bkap.reponsitories.ProductColorRespository;

@Service
public class ProductColorServiceImp implements ProductColorService {
	@Autowired
	private ProductColorRespository productColorRespository;

	@Override
	public List<ProductColor> findAll() {
		// TODO Auto-generated method stub
		return productColorRespository.findAll();
	}

	@Override
	public ProductColor findId(int id) {
		// TODO Auto-generated method stub
		return productColorRespository.getById(null);
	}

	@Override
	public ProductColor save(ProductColor pc) {
		// TODO Auto-generated method stub
		return productColorRespository.save(pc);
	}

	@Override
	public ProductColor update(ProductColor pc) {
		// TODO Auto-generated method stub
		return productColorRespository.save(pc);
	}

	@Override
	public void remove(int id) {
		productColorRespository.deleteById(id);

	}

	@Override
	public List<ProductColor> getColorByProId(int id) {
		// TODO Auto-generated method stub
		return productColorRespository.getColorByProId(id);
	}

	@Override
	public List<ProductColor> getProColor(Pageable pageable) {
		// TODO Auto-generated method stub
		return productColorRespository.getProColor(pageable);
	}

	@Override
	public int countProductColor() {
		// TODO Auto-generated method stub
		return productColorRespository.countProductColor();
	}

}
