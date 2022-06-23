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

import com.bkap.entities.Orders;
import com.bkap.services.OrderService;

@RestController
@RequestMapping(value = "api")
public class OrderController {
	@Autowired
	private OrderService service;

	// Đếm sản phẩm
	@GetMapping(value = "/user/orderStatus/count/{status}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public int countProducts(@PathVariable("status") boolean status) {
		return service.countOrderStatus(status);
	}

	@GetMapping(value = "/user/order")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<Orders> get() {
		return service.findAll();
	}

	// Lấy danh sách order theo page
	@GetMapping(value = "/user/order/page/{status}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<Orders> get(@PathVariable("status") boolean status,
			@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
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
		return service.getOrderStatus(status, pageable);
	}

	@GetMapping(value = "/user/order/byCustomerId/{customerId}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<Orders> getOrderbyCustomerId(@PathVariable("customerId") int customerId,
			@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(name = "sizePage", required = false, defaultValue = "99") Integer sizePage,
			@RequestParam(name = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(name = "sortBy", required = false, defaultValue = "createDate") String sortBy) {
		Sort sortable = null;
		if (sort.equals("ASC")) {
			sortable = Sort.by(sortBy).ascending();
		}
		if (sort.equals("DESC")) {
			sortable = Sort.by(sortBy).descending();
		}
		Pageable pageable = PageRequest.of(page, sizePage, sortable);
		return service.getOrderByCustomerId(customerId, pageable);
	}

	@GetMapping(value = "/user/order/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public Orders get(@PathVariable("id") int id) {
		return service.findId(id);
	}

	@PostMapping(value = "/user/order")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.POST)
	public Orders post(@RequestBody Orders o) {
		return service.save(o);
	}

	@PutMapping(value = "/user/order")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.PUT)
	public Orders put(@RequestBody Orders o) {
		return service.update(o);
	}

	@DeleteMapping(value = "/user/order/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.DELETE)
	public Orders delete(@PathVariable("id") int id) {
		Orders p = service.findId(id);
		if (p != null) {
			service.remove(id);
		}
		return null;
	}
}
