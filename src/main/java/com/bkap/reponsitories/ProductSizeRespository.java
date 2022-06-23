package com.bkap.reponsitories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bkap.entities.ProductSize;

@Repository
public interface ProductSizeRespository extends JpaRepository<ProductSize, Integer> {
	@Query(value = "SELECT DISTINCT ps.* FROM Product_Size ps JOIN Product p ON  ps.ProductId = p.ProductId"
			+ "	JOIN Size s ON ps.SizeId = s.SizeId where p.ProductId = :id", nativeQuery = true)
	List<ProductSize> getSizeByProId(@Param("id") int id);

	@Query(value = "SELECT DISTINCT ps.* FROM Product_Size ps" + "	JOIN Product p ON  ps.ProductId = p.ProductId"
			+ "	JOIN Size s ON ps.SizeId = s.SizeId", nativeQuery = true)
	List<ProductSize> getProSize(Pageable pageable);

	@Query("SELECT DISTINCT COUNT(ProductSizeId) AS NumberOfProductSizes from ProductSize ")
	int countProductSize();
}
