package com.bkap.reponsitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bkap.entities.Favorite;

@Repository
public interface FavoriteRespository extends JpaRepository<Favorite, Integer> {

}
