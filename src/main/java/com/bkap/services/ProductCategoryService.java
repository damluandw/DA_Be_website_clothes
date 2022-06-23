package com.bkap.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.bkap.entities.Product;
import com.bkap.entities.ProductCategory;

public interface ProductCategoryService {
	List<ProductCategory> findAll();
	
	List<ProductCategory> getProCate(Pageable pageable);
	
	List<ProductCategory> getCateByProId(int id);

	ProductCategory findId(int id);

	List<Product> findProShowHome(String nameCategory);

	ProductCategory save(ProductCategory pc);

	ProductCategory update(ProductCategory pc);

	void remove(int id);
	
	int countProductCategory();
}
