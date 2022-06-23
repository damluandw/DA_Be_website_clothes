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

import com.bkap.entities.Color;
import com.bkap.services.ColorService;

@RestController
@RequestMapping(value = "api")
public class ColorController {
	@Autowired
	private ColorService service;

	@GetMapping(value = "/user/color")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<Color> get() {
		return service.findAll();
	}

	@GetMapping(value = "/user/color/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public Color get(@PathVariable("id") int id) {
		return service.findId(id);
	}

	@GetMapping(value = "/user/color/{color}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<Color> get(@PathVariable("color") String color) {
		return service.findByColor(color);
	}

	@PostMapping(value = "/admin/color")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.POST)
	public Color post(@RequestBody Color p) {
		return service.save(p);
	}

	@PutMapping(value = "/admin/color")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.PUT)
	public Color put(@RequestBody Color p) {
		return service.update(p);
	}

	@DeleteMapping(value = "/admin/color/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.DELETE)
	public Color delete(@PathVariable("id") int id) {
		Color p = service.findId(id);
		if (p != null) {
			service.remove(id);
		}
		return null;
	}

}
