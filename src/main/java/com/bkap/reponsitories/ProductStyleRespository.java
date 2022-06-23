package com.bkap.reponsitories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bkap.entities.ProductStyle;

@Repository
public interface ProductStyleRespository extends JpaRepository<ProductStyle, Integer> {
	@Query(value = "SELECT ps.* FROM Product_Style ps" + "	JOIN Product p ON  ps.ProductId = p.ProductId"
			+ "	JOIN Style s ON ps.StyleId = s.StyleId where p.ProductId = :id", nativeQuery = true)
	List<ProductStyle> getStyleByProId(@Param("id") int id);

	@Query(value = "SELECT DISTINCT ps.* FROM Product_Style ps" + "	JOIN Product p ON  ps.ProductId = p.ProductId"
			+ "	JOIN Style s ON ps.StyleId = s.StyleId", nativeQuery = true)
	List<ProductStyle> getProStyle(Pageable pageable);

	@Query("SELECT DISTINCT COUNT(ProductStyleId) AS NumberOfProductStyles from ProductStyle ")
	int countProductStyle();
}
