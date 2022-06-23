package com.bkap.reponsitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bkap.entities.BlogCategory;

@Repository
public interface BlogCategoryRespository extends JpaRepository<BlogCategory, Integer> {

}
