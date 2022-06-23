package com.bkap.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bkap.entities.Provider;
import com.bkap.reponsitories.ProviderRespository;

@Service
public class ProviderServiceImp implements ProviderService {
	@Autowired
	private ProviderRespository providerRespository;

	@Override
	public List<Provider> findAll() {
		// TODO Auto-generated method stub
		return providerRespository.findAll();
	}

	@Override
	public Provider findId(int id) {
		// TODO Auto-generated method stub
		return providerRespository.getById(id);
	}

	@Override
	public List<Provider> findByName(String name) {
		// TODO Auto-generated method stub
		return providerRespository.findByName(name);
	}

	@Override
	public Provider save(Provider p) {
		// TODO Auto-generated method stub
		return providerRespository.save(p);
	}

	@Override
	public Provider update(Provider p) {
		// TODO Auto-generated method stub
		return providerRespository.save(p);
	}

	@Override
	public void remove(int id) {
		providerRespository.deleteById(id);

	}

}
