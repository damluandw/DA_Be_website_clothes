package com.bkap.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.bkap.entities.ProductStyle;

public interface ProductStyleService {
	List<ProductStyle> findAll();

	List<ProductStyle> getProStyle(Pageable pageable);

	List<ProductStyle> getStyleByProId(int id);

	ProductStyle findId(int id);

	ProductStyle save(ProductStyle ps);

	ProductStyle update(ProductStyle ps);

	void remove(int id);
	
	int countProductStyle();
}
