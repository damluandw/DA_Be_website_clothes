package com.bkap.services;

import java.util.List;

import com.bkap.entities.Provider;

public interface ProviderService {
	List<Provider> findAll();

	Provider findId(int id);

	List<Provider> findByName(String name);

	Provider save(Provider p);

	Provider update(Provider p);

	void remove(int id);
}
