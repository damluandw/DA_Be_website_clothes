package com.bkap.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bkap.entities.Product;
import com.bkap.entities.ProductCategory;
import com.bkap.reponsitories.ProductCategoryRespository;

@Service
public class ProductCategoryServiceImp implements ProductCategoryService {
	@Autowired
	private ProductCategoryRespository productCategoryRespository;

	@Override
	public List<ProductCategory> findAll() {
		// TODO Auto-generated method stub
		return productCategoryRespository.findAll();
	}

	@Override
	public ProductCategory findId(int id) {
		// TODO Auto-generated method stub
		return productCategoryRespository.getById(id);
	}

	@Override
	public ProductCategory save(ProductCategory pc) {
		// TODO Auto-generated method stub
		return productCategoryRespository.save(pc);
	}

	@Override
	public ProductCategory update(ProductCategory pc) {
		// TODO Auto-generated method stub
		return productCategoryRespository.save(pc);
	}

	@Override
	public void remove(int id) {
		productCategoryRespository.deleteById(id);

	}

	@Override
	public List<Product> findProShowHome(String nameCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductCategory> getProCate(Pageable pageable) {
		// TODO Auto-generated method stub
		return productCategoryRespository.getProCategory(pageable);
	}

	@Override
	public List<ProductCategory> getCateByProId(int id) {
		// TODO Auto-generated method stub
		return productCategoryRespository.getCategoryByProId(id);
	}

	@Override
	public int countProductCategory() {
		// TODO Auto-generated method stub
		return productCategoryRespository.countProductCategory();
	}

}
