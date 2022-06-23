package com.bkap.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bkap.entities.SliderHome;
import com.bkap.reponsitories.SliderHomeRespository;

@Service
public class SliderHomeServiceImp implements SliderHomeService {
	@Autowired
	private SliderHomeRespository sliderHomeRespository;

	@Override
	public List<SliderHome> findAll() {
		// TODO Auto-generated method stub
		return sliderHomeRespository.findAll();
	}

	@Override
	public SliderHome findId(int id) {
		// TODO Auto-generated method stub
		return sliderHomeRespository.getById(id);
	}

	@Override
	public SliderHome save(SliderHome s) {
		// TODO Auto-generated method stub
		return sliderHomeRespository.save(s);
	}

	@Override
	public SliderHome update(SliderHome s) {
		// TODO Auto-generated method stub
		return sliderHomeRespository.save(s);
	}

	@Override
	public void remove(int id) {
		sliderHomeRespository.deleteById(id);

	}
}
