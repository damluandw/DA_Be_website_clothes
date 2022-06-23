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

import com.bkap.entities.Favorite;
import com.bkap.services.FavoriteService;

@RestController
@RequestMapping(value = "api/user/favorite")
public class FavoriteController {
	@Autowired
	private FavoriteService service;

	@GetMapping
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<Favorite> get() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public Favorite get(@PathVariable("id") int id) {
		return service.findId(id);
	}

	@PostMapping
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.POST)
	public Favorite post(@RequestBody Favorite f) {
		return service.save(f);
	}

	@PutMapping
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.PUT)
	public Favorite put(@RequestBody Favorite f) {
		return service.update(f);
	}

	@DeleteMapping(value = "/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.DELETE)
	public Favorite delete(@PathVariable("id") int id) {
		Favorite p = service.findId(id);
		if (p != null) {
			service.remove(id);
		}
		return null;
	}
}
