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

import com.bkap.entities.Brand;
import com.bkap.services.BrandService;

@RestController
@RequestMapping(value = "api/")
public class BrandController {
	@Autowired
	private BrandService service;

	@GetMapping(value = "/user/brand")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<Brand> get() {
		return service.findAll();
	}

	@GetMapping(value = "/user/brand/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public Brand get(@PathVariable("id") int id) {
		return service.findId(id);
	}

	@GetMapping(value = "/user/brand/getName/{name}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<Brand> get(@PathVariable("name") String name) {
		return service.findByName(name);
	}

	@PostMapping(value = "/admin/brand")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.POST)
	public Brand post(@RequestBody Brand p) {
		return service.save(p);
	}

	@PutMapping(value = "/admin/brand")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.PUT)
	public Brand put(@RequestBody Brand p) {
		return service.update(p);
	}

	@DeleteMapping(value = "/admin/brand/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.DELETE)
	public Brand delete(@PathVariable("id") int id) {
		Brand p = service.findId(id);
		if (p != null) {
			service.remove(id);
		}
		return null;
	}
}
