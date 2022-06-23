package com.bkap.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bkap.entities.Feeback;
import com.bkap.reponsitories.FeebackRespository;

@Service
public class FeebackServiceImp implements FeebackService {
	@Autowired
	private FeebackRespository feebackRespository;

	@Override
	public List<Feeback> findAll() {
		// TODO Auto-generated method stub
		return feebackRespository.findAll();
	}

	@Override
	public Feeback findId(int id) {
		// TODO Auto-generated method stub
		return feebackRespository.getById(id);
	}

	@Override
	public List<Feeback> findByName(String name) {
		// TODO Auto-generated method stub
		return feebackRespository.findByName(name);
	}

	@Override
	public Feeback save(Feeback f) {
		// TODO Auto-generated method stub
		return feebackRespository.save(f);
	}

	@Override
	public Feeback update(Feeback f) {
		// TODO Auto-generated method stub
		return feebackRespository.save(f);
	}

	@Override
	public void remove(int id) {
		feebackRespository.deleteById(id);

	}

	@Override
	public List<Feeback> getFeebackByProId(int id) {
		// TODO Auto-generated method stub
		return feebackRespository.getFeebackByProId(id);
	}

	@Override
	public List<Feeback> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return feebackRespository.getAll(pageable);
	}

	@Override
	public int countFeeback() {
		// TODO Auto-generated method stub
		return feebackRespository.countFeeback();
	}

}
