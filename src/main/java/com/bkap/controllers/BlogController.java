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

import com.bkap.entities.Blog;
import com.bkap.services.BlogService;

@RestController
@RequestMapping(value = "api")
public class BlogController {
	@Autowired
	private BlogService service;

	@GetMapping(value = "/user/blog")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<Blog> get() {
		return service.findAll();
	}

	@GetMapping(value = "/user/blog/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public Blog get(@PathVariable("id") int id) {
		return service.findId(id);
	}

	@GetMapping(value = "/user/blog/{name}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<Blog> get(@PathVariable("name") String name) {
		return service.findByName(name);
	}

	@PostMapping(value = "/admin/blog")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.POST)
	public Blog post(@RequestBody Blog p) {
		return service.save(p);
	}

	@PutMapping(value = "/admin/blog")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.PUT)
	public Blog put(@RequestBody Blog p) {
		return service.update(p);
	}

	@DeleteMapping(value = "/admin/blog/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.DELETE)
	public Blog delete(@PathVariable("id") int id) {
		Blog p = service.findId(id);
		if (p != null) {
			service.remove(id);
		}
		return null;
	}

}
