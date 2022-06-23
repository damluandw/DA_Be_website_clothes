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

import com.bkap.entities.Product;
import com.bkap.entities.ProductCategory;
import com.bkap.services.ProductCategoryService;

@RestController
@RequestMapping(value = "api")
public class ProductCategoryController {
	@Autowired
	private ProductCategoryService service;

	// Đếm sản phẩm
	@GetMapping(value = "/user/productCategory/count")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public int countProducts() {
		return service.countProductCategory();
	}

	@GetMapping(value = "/user/productCategory")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<ProductCategory> get() {

		return service.findAll();
	}

	@GetMapping(value = "/user/productCategory/page")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<ProductCategory> get(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
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
		return service.getProCate(pageable);
	}

	@GetMapping(value = "/user/productCategory/category/{name}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<Product> getProShowHome(@PathVariable("name") String name) {
		return service.findProShowHome(name);
	}

	@GetMapping(value = "/user/productCategory/byProductId/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<ProductCategory> getByNameCategory(@PathVariable("id") int id) {
		return service.getCateByProId(id);
	}

	@GetMapping(value = "/user/productCategory/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public ProductCategory get(@PathVariable("id") int id) {
		return service.findId(id);
	}

	@PostMapping(value = "/admin/productCategory")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.POST)
	public ProductCategory post(@RequestBody ProductCategory p) {
		return service.save(p);
	}

	@PutMapping(value = "/admin/productCategory")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.PUT)
	public ProductCategory put(@RequestBody ProductCategory p) {
		return service.update(p);
	}

	@DeleteMapping(value = "/admin/productCategory/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.DELETE)
	public ProductCategory delete(@PathVariable("id") int id) {
		ProductCategory p = service.findId(id);
		if (p != null) {
			service.remove(id);
		}
		return null;
	}
}
