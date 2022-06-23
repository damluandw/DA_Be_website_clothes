package com.bkap.reponsitories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bkap.entities.Style;

@Repository
public interface StyleRespository extends JpaRepository<Style, Integer> {
	@Query("SELECT s from Style s Where s.style like %:style%")
	List<Style> findByStyle(@Param("style") String style);
}
