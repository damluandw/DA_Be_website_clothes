package com.bkap.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.bkap.entities.Feeback;

public interface FeebackService {
	List<Feeback> findAll();

	Feeback findId(int id);
	
	
	List<Feeback> getFeebackByProId(int id);

	List<Feeback> findByName(String name);

	Feeback save(Feeback f);

	Feeback update(Feeback f);

	void remove(int id);
	
	List<Feeback> getAll(Pageable pageable);

	int countFeeback();
}
