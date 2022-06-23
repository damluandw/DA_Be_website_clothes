package com.bkap.reponsitories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bkap.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query("SELECT DISTINCT p from Product p")
	List<Product> getAll(Pageable pageable);

	@Query("SELECT DISTINCT COUNT(ProductId) AS NumberOfProducts from Product ")
	int countProduct();

	@Query("SELECT DISTINCT p from Product p Where p.name like %:name%")
	List<Product> findByName(@Param("name") String name, Pageable pageable);

	@Query("SELECT DISTINCT p from Product p Where p.id = :id")
	Product findById(@Param("id") int id);

	@Query(value = "SELECT DISTINCT p.* FROM Product p JOIN Product_Category pc ON  pc.ProductId = p.ProductId"
			+ "	JOIN Category c ON pc.CategoryId = c.CategoryId Where c.CategoryName like %:name% AND p.showHome= 1", nativeQuery = true)
	List<Product> getProCategoryShowHome(@Param("name") String name);

	@Query(value = "SELECT DISTINCT  p.* FROM Product p JOIN Product_Category pc ON  pc.ProductId = p.ProductId"
			+ "	JOIN Category c ON pc.CategoryID = c.CategoryID" + "	JOIN Brand b ON p.BrandId = b.BrandId"
			+ "	JOIN Provider pv ON p.ProviderId = pv.ProviderId"
			+ "	JOIN Product_Size ps ON p.ProductId = ps.ProductId" + "	JOIN Size sz ON sz.SizeId = ps.SizeId"
			+ "	JOIN Product_Style pst ON p.ProductId = pst.ProductId" + "	JOIN Style st ON st.StyleId = pst.StyleId"
			+ "	JOIN Product_Color pcl ON p.ProductId = pcl.ProductId" + "	JOIN Color cl ON pcl.ColorId = cl.ColorId"
			+ "	JOIN Provider provider ON provider.ProviderId = p.ProviderId"
			+ "	JOIN Brand br ON br.BrandId = p.BrandId", nativeQuery = true)
	List<Product> getProView();

	@Query(value = "SELECT DISTINCT p.* FROM Product p Where p.PriceOut BETWEEN :minPrice AND :maxPrice", nativeQuery = true)
	List<Product> getProPrice(@Param("minPrice") float minPrice, @Param("maxPrice") float maxPrice, Pageable pageable);

	@Query(value = "SELECT DISTINCT COUNT(p.ProductId) AS NumberOfProducts from Product p Where p.PriceOut BETWEEN :minPrice AND :maxPrice", nativeQuery = true)
	int countProPrice(@Param("minPrice") float minPrice, @Param("maxPrice") float maxPrice);

	@Query(value = "SELECT DISTINCT p.* FROM Product p JOIN Product_Category pc ON  pc.ProductId = p.ProductId"
			+ "	JOIN Category c ON pc.CategoryId = c.CategoryId Where c.CategoryName = :name", nativeQuery = true)
	List<Product> getProCategory(@Param("name") String name, Pageable pageable);

	@Query(value = "SELECT DISTINCT p.* FROM Product p JOIN Product_Color pc ON  pc.ProductId = p.ProductId"
			+ "	JOIN Color c ON pc.ColorId = c.ColorId Where c.color = :color ", nativeQuery = true)
	List<Product> getProColor(@Param("color") String color, Pageable pageable);

	@Query(value = "SELECT DISTINCT p.* FROM Product p JOIN Product_Size ps ON  ps.ProductId = p.ProductId"
			+ "	JOIN Size s ON s.SizeId = ps.SizeId Where s.size  =:size", nativeQuery = true)
	List<Product> getProSize(@Param("size") String size, Pageable pageable);

	@Query(value = "SELECT DISTINCT p.* FROM Product p JOIN Brand b ON b.BrandId = p.BrandId Where b.BrandName like %:name%", nativeQuery = true)
	List<Product> getProBrand(@Param("name") String name, Pageable pageable);

	@Query(value = "SELECT DISTINCT p.* FROM Product p JOIN Provider pv ON pv.ProviderId = p.ProviderId Where pv.ProviderName like %:name%", nativeQuery = true)
	List<Product> getProProvider(@Param("name") String name, Pageable pageable);

	@Query(value = "SELECT DISTINCT p.* FROM Product p JOIN Product_Style ps ON  ps.ProductId = p.ProductId"
			+ "	JOIN Style  s ON s.StyleId = ps.StyleId Where s.styleName = :name", nativeQuery = true)
	List<Product> getProStyle(@Param("name") String name, Pageable pageable);

	@Query(value = "SELECT DISTINCT  p.* FROM Product p JOIN Product_Category pc ON  pc.ProductId = p.ProductId"
			+ "	JOIN Category c ON pc.CategoryID = c.CategoryID" + "	JOIN Brand b ON p.BrandId = b.BrandId"
			+ "	JOIN Provider pv ON p.ProviderId = pv.ProviderId"
			+ "	JOIN Product_Size ps ON p.ProductId = ps.ProductId" + "	JOIN Size sz ON sz.SizeId = ps.SizeId"
			+ "	JOIN Product_Style pst ON p.ProductId = pst.ProductId" + "	JOIN Style st ON st.StyleId = pst.StyleId"
			+ "	JOIN Product_Color pcl ON p.ProductId = pcl.ProductId" + "	JOIN Color cl ON pcl.ColorId = cl.ColorId"
			+ "	JOIN Provider provider ON provider.ProviderId = p.ProviderId"
			+ "	JOIN Brand br ON br.BrandId = p.BrandId", nativeQuery = true)
	List<Product> getProAll();

	@Query(value = "SELECT DISTINCT  p.* FROM Product p JOIN Product_Category pc ON  pc.ProductId = p.ProductId"
			+ "	JOIN Category c ON pc.CategoryID = c.CategoryID	JOIN Brand b ON p.BrandId = b.BrandId"
			+ "	JOIN Provider pv ON p.ProviderId = pv.ProviderId"
			+ "	JOIN Product_Size ps ON p.ProductId = ps.ProductId JOIN Size sz ON sz.SizeId = ps.SizeId"
			+ "	JOIN Product_Style pst ON p.ProductId = pst.ProductId JOIN Style st ON st.StyleId = pst.StyleId"
			+ "	JOIN Product_Color pcl ON p.ProductId = pcl.ProductId JOIN Color cl ON pcl.ColorId = cl.ColorId"
			+ "	JOIN Provider provider ON provider.ProviderId = p.ProviderId"
			+ "	WHERE p.priceOut BETWEEN :minPrice AND :maxPrice OR c.CategoryName = :categoryName	OR cl.Color = :color OR sz.Size  = :size OR b.BrandName like :brandName OR st.StyleName like :styleName", nativeQuery = true)
	List<Product> getProFilter(@Param("minPrice") float minPrice, @Param("maxPrice") float maxPrice,
			@Param("categoryName") String categoryName, @Param("color") String color, @Param("size") String size,
			@Param("brandName") String brandName, @Param("styleName") String styleName, Pageable pageable);

	@Query(value = "SELECT DISTINCT COUNT(p.ProductId) AS NumberOfProducts from Product p JOIN Product_Category pc ON  pc.ProductId = p.ProductId"
			+ "	JOIN Category c ON pc.CategoryID = c.CategoryID	JOIN Brand b ON p.BrandId = b.BrandId"
			+ "	JOIN Provider pv ON p.ProviderId = pv.ProviderId"
			+ "	JOIN Product_Size ps ON p.ProductId = ps.ProductId JOIN Size sz ON sz.SizeId = ps.SizeId"
			+ "	JOIN Product_Style pst ON p.ProductId = pst.ProductId JOIN Style st ON st.StyleId = pst.StyleId"
			+ "	JOIN Product_Color pcl ON p.ProductId = pcl.ProductId JOIN Color cl ON pcl.ColorId = cl.ColorId"
			+ "	JOIN Provider provider ON provider.ProviderId = p.ProviderId"
			+ "	WHERE p.priceOut BETWEEN :minPrice AND :maxPrice AND (c.CategoryName = :categoryName OR cl.Color = :color OR sz.Size  = :size OR b.BrandName = :brandName OR st.StyleName = :styleName)", nativeQuery = true)
	int countProductFilter(@Param("minPrice") float minPrice, @Param("maxPrice") float maxPrice,
			@Param("categoryName") String categoryName, @Param("color") String color, @Param("size") String size,
			@Param("brandName") String brandName, @Param("styleName") String styleName);

}
