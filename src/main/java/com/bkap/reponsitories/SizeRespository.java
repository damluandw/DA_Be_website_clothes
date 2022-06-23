package com.bkap.reponsitories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bkap.entities.Size;

@Repository
public interface SizeRespository extends JpaRepository<Size, Integer> {
	@Query("SELECT s from Size s Where s.size like %:size%")
	List<Size> findBySize(@Param("size") String size);
}
