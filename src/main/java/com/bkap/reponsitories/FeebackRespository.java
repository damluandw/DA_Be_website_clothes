package com.bkap.reponsitories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bkap.entities.Feeback;

@Repository
public interface FeebackRespository extends JpaRepository<Feeback, Integer> {
	@Query("SELECT DISTINCT f from Feeback f Where f.fullName like %:name%")
	List<Feeback> findByName(@Param("name") String name);

	@Query(value = "SELECT DISTINCT f.* FROM Feeback f JOIN Product p ON  f.ProductId = p.ProductId where p.ProductId = :id", nativeQuery = true)
	List<Feeback> getFeebackByProId(@Param("id") int id);
	
	@Query("SELECT DISTINCT f from Feeback f")
	List<Feeback> getAll(Pageable pageable);
	
	@Query("SELECT DISTINCT COUNT(id) AS countFeeback from Feeback ")
	int countFeeback();
}
