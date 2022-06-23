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

import com.bkap.entities.Style;
import com.bkap.services.StyleService;

@RestController
@RequestMapping(value = "api")
public class StyleController {
	@Autowired
	private StyleService service;

	@GetMapping(value = "/user/style")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<Style> get() {
		return service.findAll();
	}

	@GetMapping(value = "/user/style/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public Style get(@PathVariable("id") int id) {
		return service.findId(id);
	}

	@GetMapping(value = "/user/style/{style}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<Style> get(@PathVariable("color") String style) {
		return service.findByStyle(style);
	}

	@PostMapping(value = "/admin/style")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.POST)
	public Style post(@RequestBody Style s) {
		return service.save(s);
	}

	@PutMapping(value = "/admin/style")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.PUT)
	public Style put(@RequestBody Style s) {
		return service.update(s);
	}

	@DeleteMapping(value = "/admin/style/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.DELETE)
	public Style delete(@PathVariable("id") int id) {
		Style p = service.findId(id);
		if (p != null) {
			service.remove(id);
		}
		return null;
	}
}
