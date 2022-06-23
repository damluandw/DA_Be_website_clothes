package com.bkap.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bkap.entities.Feeback;
import com.bkap.services.FeebackService;

@RestController
@RequestMapping(value = "api/user/feeback")
public class FeebackController {
	@Autowired
	private FeebackService service;

	// Đếm sản phẩm
	@GetMapping(value = "/count")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public int countProducts() {
		return service.countFeeback();
	}

	// Lấy danh sách sản phẩm theo page
	@GetMapping(value = "/page")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<Feeback> get(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(name = "sizePage", required = false, defaultValue = "9") Integer sizePage,
			@RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
			@RequestParam(name = "sortBy", required = false, defaultValue = "createDate") String sortBy) {
		Sort sortable = null;
		if (sort.equals("ASC")) {
			sortable = Sort.by(sortBy).ascending();
		}
		if (sort.equals("DESC")) {
			sortable = Sort.by(sortBy).descending();
		}
		Pageable pageable = PageRequest.of(page, sizePage, sortable);
		return service.getAll(pageable);
	}

	@GetMapping
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<Feeback> get() {
		return service.findAll();
	}

	@GetMapping(value = "/byProductId/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<Feeback> getbyProductId(@PathVariable("id") int id) {
		return service.getFeebackByProId(id);
	}

	@GetMapping(value = "/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public Feeback get(@PathVariable("id") int id) {
		return service.findId(id);
	}

	@GetMapping(value = "/{name}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<Feeback> get(@PathVariable("name") String name) {
		return service.findByName(name);
	}

	@PostMapping
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.POST)
	public Feeback post(@RequestBody Feeback f) {
		return service.save(f);
	}

	@PutMapping
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.PUT)
	public Feeback put(@RequestBody Feeback f) {
		return service.update(f);
	}

	@DeleteMapping(value = "/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.DELETE)
	public Feeback delete(@PathVariable("id") int id) {
		Feeback p = service.findId(id);
		if (p != null) {
			service.remove(id);
		}
		return null;
	}
}
