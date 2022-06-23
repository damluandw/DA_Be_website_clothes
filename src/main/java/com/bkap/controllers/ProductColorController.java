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

import com.bkap.entities.ProductColor;
import com.bkap.services.ProductColorService;

@RestController
@RequestMapping(value = "api")
public class ProductColorController {
	@Autowired
	private ProductColorService service;

	// Đếm sản phẩm
	@GetMapping(value = "/user/productColor/count")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public int countProducts() {
		return service.countProductColor();
	}

	@GetMapping(value = "/user/productColor")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<ProductColor> get() {
		return service.findAll();
	}

	@GetMapping(value = "/user/productColor/page")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<ProductColor> get(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(name = "sizePage", required = false, defaultValue = "9") Integer sizePage,
			@RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
			@RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortBy) {
		Sort sortable = null;
		if (sort.equals("ASC")) {
			sortable = Sort.by(sortBy).ascending();
		}
		if (sort.equals("DESC")) {
			sortable = Sort.by(sortBy).descending();
		}
		Pageable pageable = PageRequest.of(page, sizePage, sortable);
		return service.getProColor(pageable);
	}

	@GetMapping(value = "/user/productColor/byProductId/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<ProductColor> getProductColorByProId(@PathVariable("id") int id) {
		return service.getColorByProId(id);
	}

	@GetMapping(value = "/user/productColor/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public ProductColor get(@PathVariable("id") int id) {
		return service.findId(id);
	}

	@PostMapping(value = "/admin/productColor")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.POST)
	public ProductColor post(@RequestBody ProductColor p) {
		return service.save(p);
	}

	@PutMapping(value = "/admin/productColor")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.PUT)
	public ProductColor put(@RequestBody ProductColor p) {
		return service.update(p);
	}

	@DeleteMapping(value = "/admin/productColor/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.DELETE)
	public ProductColor delete(@PathVariable("id") int id) {
		ProductColor p = service.findId(id);
		if (p != null) {
			service.remove(id);
		}
		return null;
	}
}
