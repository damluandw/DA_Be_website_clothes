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

import com.bkap.entities.Category;
import com.bkap.services.CategoryService;

@RestController
@RequestMapping(value = "api")
public class CategoriesController {
	@Autowired
	private CategoryService service;

	@GetMapping(value = "/user/category")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<Category> get() {
		return service.findAll();
	}
	@GetMapping(value = "/user/category/product")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<Category> getShowCategoryProduct() {
		return service.getShowCategoryProduct();
	}
	@GetMapping(value = "/user/category/byProductId/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<Category> getCategotiesByProId(@PathVariable("id") int id) {
		return service.getCateByProId(id);
	}

	@GetMapping(value = "/user/category/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public Category get(@PathVariable("id") int id) {
		return service.findId(id);
	}

	@GetMapping(value = "/user/category/getName/{name}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<Category> get(@PathVariable("name") String name) {
		return service.findByName(name);
	}

	@PostMapping(value = "/admin/category")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.POST)
	public Category post(@RequestBody Category p) {
		return service.save(p);
	}

	@PutMapping(value = "/admin/category")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.PUT)
	public Category put(@RequestBody Category p) {
		return service.update(p);
	}

	@DeleteMapping(value = "/admin/category/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.DELETE)
	public Category delete(@PathVariable("id") int id) {
		Category p = service.findId(id);
		if (p != null) {
			service.remove(id);
		}
		return null;
	}
}
