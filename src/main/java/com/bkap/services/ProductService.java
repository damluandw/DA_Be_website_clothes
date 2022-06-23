package com.bkap.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.bkap.entities.Product;

public interface ProductService {
	List<Product> findAll();

	int countProduct();

	List<Product> getProCategoryShowHome(String name);

	List<Product> getAll(Pageable pageable);

	List<Product> getProView();

	List<Product> getProPrice(float minPrice, float maxPrice, Pageable pageable);

	int countProPrice(float minPrice, float maxPrice);

	List<Product> getProCategory(String name, Pageable pageable);

	List<Product> getProColor(String color, Pageable pageable);

	List<Product> getProSize(String size, Pageable pageable);

	List<Product> getProBrand(String brand, Pageable pageable);

	List<Product> getProProvider(String name, Pageable pageable);

	List<Product> getProStyle(String name, Pageable pageable);

	List<Product> getProFilter(float minPrice, float maxPrice, String category, String color, String size, String brand,
			String style, Pageable pageable);

	int countProFilter(float minPrice, float maxPrice, String category, String color, String size, String brand,
			String style);

	Product findId(int id);

	List<Product> findByName(String name, Pageable pageable);

	Product save(Product p);

	Product update(Product p);

	void remove(int id);
}
