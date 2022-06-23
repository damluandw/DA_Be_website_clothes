package com.bkap.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bkap.entities.SliderHome;
import com.bkap.services.SliderHomeService;

@RestController
@RequestMapping(value = "api")
public class SliderHomeController {
	@Autowired
	private SliderHomeService service;

	@GetMapping(value = "/user/sliderHome")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<SliderHome> get() {
		return service.findAll();
	}

	@GetMapping(value = "/user/sliderHome/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public SliderHome get(@PathVariable("id") int id) {
		return service.findId(id);
	}

	@PostMapping(value = "/admin/sliderHome")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.POST)
	public SliderHome post(@RequestBody SliderHome s) {
		return service.save(s);
	}

	@PutMapping(value = "/admin/sliderHome")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.PUT)
	public SliderHome put(@RequestBody SliderHome s) {
		return service.update(s);
	}

	@DeleteMapping(value = "/admin/sliderHome/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.DELETE)
	public SliderHome delete(@PathVariable("id") int id) {
		SliderHome p = service.findId(id);
		if (p != null) {
			service.remove(id);
		}
		return null;
	}
}
