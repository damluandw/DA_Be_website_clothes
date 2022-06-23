package com.bkap.reponsitories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bkap.entities.Blog;

@Repository
public interface BlogRespository extends JpaRepository<Blog, Integer> {
	@Query("SELECT b from Blog b Where b.title like %:BlogTitle%")
	List<Blog> findByName(@Param("BlogTitle") String blogTitle);
}
