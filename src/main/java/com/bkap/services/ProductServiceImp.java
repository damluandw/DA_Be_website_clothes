package com.bkap.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bkap.entities.Product;
import com.bkap.reponsitories.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> getAll(Pageable pageable) {
		return productRepository.getAll(pageable);
	}

	@Override
	public Product findId(int id) {
		return productRepository.getById(id);
	}

	@Override
	public List<Product> findByName(String name, Pageable pageable) {
		return productRepository.findByName(name, pageable);
	}

	@Override
	public Product save(Product p) {
		return productRepository.save(p);
	}

	@Override
	public Product update(Product p) {
		return productRepository.save(p);
	}

	@Override
	public void remove(int id) {
		productRepository.deleteById(id);
	}

	@Override
	public List<Product> getProView() {
		// TODO Auto-generated method stub
		return productRepository.getProView();
	}

//	@Override
//	public List<Product> getProCategory() {
//		// TODO Auto-generated method stub
//		return productRepository.getProCategory();
//	}

	@Override
	public List<Product> getProCategory(String name, Pageable pageable) {
		return productRepository.getProCategory(name, pageable);
	}

	@Override
	public List<Product> getProColor(String color, Pageable pageable) {

		return productRepository.getProColor(color, pageable);
	}

	@Override
	public List<Product> getProSize(String size, Pageable pageable) {

		return productRepository.getProSize(size, pageable);
	}

	@Override
	public List<Product> getProBrand(String brand, Pageable pageable) {

		return productRepository.getProBrand(brand, pageable);
	}

	@Override
	public List<Product> getProProvider(String name, Pageable pageable) {

		return productRepository.getProProvider(name, pageable);
	}

	@Override
	public List<Product> getProStyle(String name, Pageable pageable) {

		return productRepository.getProStyle(name, pageable);
	}

	@Override
	public List<Product> getProPrice(float minPrice, float maxPrice, Pageable pageable) {

		return productRepository.getProPrice(minPrice, maxPrice, pageable);
	}

	@Override
	public int countProduct() {
		// TODO Auto-generated method stub
		return productRepository.countProduct();
	}

	@Override
	public List<Product> getProFilter(float minPrice, float maxPrice, String category, String color, String size,
			String brand, String style, Pageable pageable) {
		// TODO Auto-generated method stub
		return productRepository.getProFilter(minPrice, maxPrice, category, color, size, brand, style, pageable);
	}

	@Override
	public List<Product> getProCategoryShowHome(String name) {
		// TODO Auto-generated method stub
		return productRepository.getProCategoryShowHome(name);
	}

	@Override
	public int countProFilter(float minPrice, float maxPrice, String category, String color, String size, String brand,
			String style) {
		// TODO Auto-generated method stub
		return productRepository.countProductFilter(minPrice, maxPrice, category, color, size, brand, style);
	}

	@Override
	public int countProPrice(float minPrice, float maxPrice) {
		// TODO Auto-generated method stub
		return productRepository.countProPrice(minPrice, maxPrice);
	}

}
