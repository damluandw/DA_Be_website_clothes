package com.bkap.services;

import java.util.List;

import com.bkap.entities.Favorite;

public interface FavoriteService {
	List<Favorite> findAll();

	Favorite findId(int id);

	Favorite save(Favorite f);

	Favorite update(Favorite f);

	void remove(int id);
}
