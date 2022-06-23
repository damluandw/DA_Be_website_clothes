package com.bkap.reponsitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bkap.entities.ProductFavorite;

@Repository
public interface ProductFavoriteRespository extends JpaRepository<ProductFavorite, Integer> {

}
