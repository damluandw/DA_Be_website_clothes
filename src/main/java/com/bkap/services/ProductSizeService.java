package com.bkap.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.bkap.entities.ProductSize;

public interface ProductSizeService {
	List<ProductSize> findAll();

	List<ProductSize> getProSize(Pageable pageable);

	List<ProductSize> getSizeByProId(int id);

	ProductSize findId(int id);

	ProductSize save(ProductSize ps);

	ProductSize update(ProductSize ps);

	void remove(int id);

	int countProductSize();

}
