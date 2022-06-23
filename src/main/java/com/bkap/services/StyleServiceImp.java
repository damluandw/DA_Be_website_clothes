package com.bkap.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bkap.entities.Style;
import com.bkap.reponsitories.StyleRespository;

@Service
public class StyleServiceImp implements StyleService {
	@Autowired
	private StyleRespository styleRespository;

	@Override
	public List<Style> findAll() {
		// TODO Auto-generated method stub
		return styleRespository.findAll();
	}

	@Override
	public Style findId(int id) {
		// TODO Auto-generated method stub
		return styleRespository.getById(id);
	}

	@Override
	public List<Style> findByStyle(String style) {
		// TODO Auto-generated method stub
		return styleRespository.findByStyle(style);
	}

	@Override
	public Style save(Style s) {
		// TODO Auto-generated method stub
		return styleRespository.save(s);
	}

	@Override
	public Style update(Style s) {
		// TODO Auto-generated method stub
		return styleRespository.save(s);
	}

	@Override
	public void remove(int id) {
		styleRespository.deleteById(id);

	}

}
