package com.bkap.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bkap.entities.Color;
import com.bkap.reponsitories.ColorRespository;

@Service
public class ColorServiceImp implements ColorService {
	@Autowired
	private ColorRespository colorsRespository;

	@Override
	public List<Color> findAll() {
		// TODO Auto-generated method stub
		return colorsRespository.findAll();
	}

	@Override
	public Color findId(int id) {
		// TODO Auto-generated method stub
		return colorsRespository.getById(id);
	}

	@Override
	public List<Color> findByColor(String color) {
		// TODO Auto-generated method stub
		return colorsRespository.findByColor(color);
	}

	@Override
	public Color save(Color c) {
		// TODO Auto-generated method stub
		return colorsRespository.save(c);
	}

	@Override
	public Color update(Color c) {
		// TODO Auto-generated method stub
		return colorsRespository.save(c);
	}

	@Override
	public void remove(int id) {
		colorsRespository.deleteById(id);

	}
}
