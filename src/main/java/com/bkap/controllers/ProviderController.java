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

import com.bkap.entities.Provider;
import com.bkap.services.ProviderService;

@RestController
@RequestMapping(value = "api/admin/provider")
public class ProviderController {
	@Autowired
	private ProviderService service;

	@GetMapping
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<Provider> get() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public Provider get(@PathVariable("id") int id) {
		return service.findId(id);
	}

	@GetMapping(value = "/{name}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<Provider> get(@PathVariable("name") String name) {
		return service.findByName(name);
	}

	@PostMapping
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.POST)
	public Provider post(@RequestBody Provider p) {
		return service.save(p);
	}

	@PutMapping
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.PUT)
	public Provider put(@RequestBody Provider p) {
		return service.update(p);
	}

	@DeleteMapping(value = "/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.DELETE)
	public Provider delete(@PathVariable("id") int id) {
		Provider p = service.findId(id);
		if (p != null) {
			service.remove(id);
		}
		return null;
	}
}
