package com.bkap.reponsitories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bkap.entities.ProductColor;

@Repository
public interface ProductColorRespository extends JpaRepository<ProductColor, Integer> {
	@Query(value = "SELECT pc.* FROM Product_Color pc" + "	JOIN Product p ON  pc.ProductId = p.ProductId"
			+ "	JOIN Color c ON pc.ColorId = c.ColorId where p.ProductId = :id", nativeQuery = true)
	List<ProductColor> getColorByProId(@Param("id") int id);

	@Query(value = "SELECT DISTINCT pc.* FROM Product_Color pc" + "	JOIN Product p ON  pc.ProductId = p.ProductId"
			+ "	JOIN Color c ON pc.ColorId = c.ColorId", nativeQuery = true)
	List<ProductColor> getProColor(Pageable pageable);
	
	@Query("SELECT DISTINCT COUNT(ProductColorId) AS NumberOfProductColors from ProductColor ")
	int countProductColor();
}
