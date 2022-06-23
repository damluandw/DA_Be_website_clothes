package com.bkap.reponsitories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bkap.entities.Category;

@Repository
public interface CategoryRespository extends JpaRepository<Category, Integer> {
	@Query("SELECT DISTINCT c from Category c Where c.name like %:name%")
	List<Category> findByName(@Param("name") String name);

	@Query("SELECT DISTINCT c from Category c Where c.showCategory = true AND c.parentId = 1")
	List<Category> getShowCategoryProduct();

	@Query(value = "SELECT DISTINCT c.* FROM Category c"
			+ "	JOIN Product_Category pc ON pc.CategoryId = c.CategoryId"
			+ "	JOIN Product p ON  pc.ProductId = p.ProductId WHERE p.ProductId = :id", nativeQuery = true)
	List<Category> getCategoryByProId(@Param("id") int id);

}
