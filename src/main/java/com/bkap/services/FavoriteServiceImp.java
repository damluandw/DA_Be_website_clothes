package com.bkap.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bkap.entities.Favorite;
import com.bkap.reponsitories.FavoriteRespository;

@Service
public class FavoriteServiceImp implements FavoriteService {
	@Autowired
	private FavoriteRespository favoriteRespository;

	@Override
	public List<Favorite> findAll() {
		// TODO Auto-generated method stub
		return favoriteRespository.findAll();
	}

	@Override
	public Favorite findId(int id) {
		// TODO Auto-generated method stub
		return favoriteRespository.getById(id);
	}

	@Override
	public Favorite save(Favorite f) {
		// TODO Auto-generated method stub
		return favoriteRespository.save(f);
	}

	@Override
	public Favorite update(Favorite f) {
		// TODO Auto-generated method stub
		return favoriteRespository.save(f);
	}

	@Override
	public void remove(int id) {
		favoriteRespository.deleteById(id);

	}
}
