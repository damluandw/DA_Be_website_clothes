package com.bkap.services;

import java.util.List;

import com.bkap.entities.ProductFavorite;

public interface ProductFavoriteService {
	List<ProductFavorite> findAll();

	ProductFavorite findId(int id);

	ProductFavorite save(ProductFavorite pf);

	ProductFavorite update(ProductFavorite pf);

	void remove(int id);
}
