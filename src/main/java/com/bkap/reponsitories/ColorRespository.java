package com.bkap.reponsitories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bkap.entities.Color;

@Repository
public interface ColorRespository extends JpaRepository<Color, Integer> {
	@Query("SELECT c from Color c Where c.color like %:Color%")
	List<Color> findByColor(@Param("Color") String color);
}
