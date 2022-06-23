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

import com.bkap.entities.ProductStyle;
import com.bkap.services.ProductStyleService;

@RestController
@RequestMapping(value = "api")
public class ProductStyleController {
	@Autowired
	private ProductStyleService service;

	// Đếm sản phẩm
	@GetMapping(value = "/user/productStyle/count")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public int countProducts() {
		return service.countProductStyle();
	}

	@GetMapping(value = "/user/productStyle")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<ProductStyle> get() {
		return service.findAll();
	}

	@GetMapping(value = "/user/productStyle/page")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<ProductStyle> get(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
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
		return service.getProStyle(pageable);
	}

	@GetMapping(value = "/user/productStyle/byProductId/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<ProductStyle> getProductSizeByProId(@PathVariable("id") int id) {
		return service.getStyleByProId(id);
	}

	@GetMapping(value = "/user/productStyle/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public ProductStyle get(@PathVariable("id") int id) {
		return service.findId(id);
	}

	@PostMapping(value = "/admin/productStyle")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.POST)
	public ProductStyle post(@RequestBody ProductStyle p) {
		return service.save(p);
	}

	@PutMapping(value = "/admin/productStyle")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.PUT)
	public ProductStyle put(@RequestBody ProductStyle p) {
		return service.update(p);
	}

	@DeleteMapping(value = "/admin/productStyle/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.DELETE)
	public ProductStyle delete(@PathVariable("id") int id) {
		ProductStyle p = service.findId(id);
		if (p != null) {
			service.remove(id);
		}
		return null;
	}

}
