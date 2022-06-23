package com.bkap.reponsitories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bkap.entities.Brand;

@Repository
public interface BrandRespository extends JpaRepository<Brand, Integer> {
	@Query("SELECT b from Brand b Where b.name like %:name%")
	List<Brand> findByName(@Param("name") String name);
}
