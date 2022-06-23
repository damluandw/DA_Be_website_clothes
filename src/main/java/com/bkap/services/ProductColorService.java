package com.bkap.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.bkap.entities.ProductColor;

public interface ProductColorService {
	List<ProductColor> findAll();

	List<ProductColor> getProColor(Pageable pageable);

	List<ProductColor> getColorByProId(int id);

	ProductColor findId(int id);

	ProductColor save(ProductColor pc);

	ProductColor update(ProductColor pc);

	void remove(int id);
	
	int countProductColor();
}
