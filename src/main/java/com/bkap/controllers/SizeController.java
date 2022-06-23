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

import com.bkap.entities.Size;
import com.bkap.services.SizeService;

@RestController
@RequestMapping(value = "api")
public class SizeController {
	@Autowired
	private SizeService service;

	@GetMapping(value = "/user/size")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<Size> get() {
		return service.findAll();
	}

	@GetMapping(value = "/user/size/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public Size get(@PathVariable("id") int id) {
		return service.findId(id);
	}

	@GetMapping(value = "/user/size/{size}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<Size> get(@PathVariable("color") String size) {
		return service.findBySize(size);
	}

	@PostMapping(value = "/admin/size")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.POST)
	public Size post(@RequestBody Size s) {
		return service.save(s);
	}

	@PutMapping(value = "/admin/size")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.PUT)
	public Size put(@RequestBody Size s) {
		return service.update(s);
	}

	@DeleteMapping(value = "/admin/size/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.DELETE)
	public Size delete(@PathVariable("id") int id) {
		Size p = service.findId(id);
		if (p != null) {
			service.remove(id);
		}
		return null;
	}
}
