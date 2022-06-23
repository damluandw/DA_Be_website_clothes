package com.bkap.reponsitories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bkap.entities.Product;
import com.bkap.entities.ProductCategory;

@Repository
public interface ProductCategoryRespository extends JpaRepository<ProductCategory, Integer> {
	@Query(value = "SELECT DISTINCT pc.* FROM Product_Category pc" + "	JOIN Product p ON  pc.ProductId = p.ProductId"
			+ "	JOIN Category c ON pc.CategoryID = c.CategoryID", nativeQuery = true)
	List<ProductCategory> getProCategory(Pageable pageable);

	@Query(value = "SELECT DISTINCT p.* FROM Product p" + "	JOIN Product_Category pc ON  pc.ProductId = p.ProductId"
			+ "	JOIN Category c ON pc.CategoryID = c.CategoryID Where c.name like %:name% AND p.showHome = true", nativeQuery = true)
	List<Product> getProShowHome(@Param("name") String name);

	@Query(value = "SELECT DISTINCT pc.* FROM Product_Category pc" + "	JOIN Product p ON  pc.ProductId = p.ProductId"
			+ "	JOIN Category c ON pc.CategoryId = c.CategoryId where p.ProductId = :id", nativeQuery = true)
	List<ProductCategory> getCategoryByProId(@Param("id") int id);

	@Query("SELECT DISTINCT COUNT(ProductCategoryId) AS NumberOfProductCategorys from ProductCategory ")
	int countProductCategory();
}
