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

import com.bkap.entities.ProductSize;
import com.bkap.services.ProductSizeService;

@RestController
@RequestMapping(value = "api")
public class ProductSizeController {
	@Autowired
	private ProductSizeService service;

	// Đếm sản phẩm
	@GetMapping(value = "/user/productSize/count")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public int countProducts() {
		return service.countProductSize();
	}

	@GetMapping(value = "/user/productSize")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<ProductSize> get() {
		return service.findAll();
	}

	@GetMapping(value = "/user/productSize/page")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<ProductSize> get(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
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
		return service.getProSize(pageable);
	}

	@GetMapping(value = "/user/productSize/byProductId/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<ProductSize> getProductSizeByProId(@PathVariable("id") int id) {
		return service.getSizeByProId(id);
	}

	@GetMapping(value = "/user/productSize/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public ProductSize get(@PathVariable("id") int id) {
		return service.findId(id);
	}

	@PostMapping(value = "/admin/productSize")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.POST)
	public ProductSize post(@RequestBody ProductSize p) {
		return service.save(p);
	}

	@PutMapping(value = "/admin/productSize")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.PUT)
	public ProductSize put(@RequestBody ProductSize p) {
		return service.update(p);
	}

	@DeleteMapping(value = "/admin/productSize/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.DELETE)
	public ProductSize delete(@PathVariable("id") int id) {
		ProductSize p = service.findId(id);
		if (p != null) {
			service.remove(id);
		}
		return null;
	}

}
