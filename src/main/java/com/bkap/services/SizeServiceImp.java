package com.bkap.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bkap.entities.Size;
import com.bkap.reponsitories.SizeRespository;

@Service
public class SizeServiceImp implements SizeService {
	@Autowired
	private SizeRespository sizeRespository;

	@Override
	public List<Size> findAll() {
		// TODO Auto-generated method stub
		return sizeRespository.findAll();
	}

	@Override
	public Size findId(int id) {
		// TODO Auto-generated method stub
		return sizeRespository.getById(id);
	}

	@Override
	public List<Size> findBySize(String size) {
		// TODO Auto-generated method stub
		return sizeRespository.findBySize(size);
	}

	@Override
	public Size save(Size s) {
		// TODO Auto-generated method stub
		return sizeRespository.save(s);
	}

	@Override
	public Size update(Size s) {
		// TODO Auto-generated method stub
		return sizeRespository.save(s);
	}

	@Override
	public void remove(int id) {
		sizeRespository.deleteById(id);

	}

}