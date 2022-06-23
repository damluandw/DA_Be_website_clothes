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

import com.bkap.entities.OrderDetail;
import com.bkap.services.OrderDetailService;

@RestController
@RequestMapping(value = "api/user/orderDetail")
public class OrderDetailController {
	@Autowired
	private OrderDetailService service;

	@GetMapping
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<OrderDetail> get() {
		return service.findAll();
	}

	@GetMapping(value = "/byOrderId/{orderId}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<OrderDetail> getOrderDetailByOrderId(@PathVariable("orderId") int orderId) {
		return service.getOrderDetailByOrderId(orderId);
	}

	// Lấy danh sách orderDetail theo page
	@GetMapping(value = "/byCustomerId/{customerId}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<OrderDetail> getOrderbyCustomerId(@PathVariable("customerId") int customerId,
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
		return service.getOrderDetailByCustomerId(customerId, pageable);
	}

	@GetMapping(value = "/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public OrderDetail get(@PathVariable("id") int id) {
		return service.findId(id);
	}

	@PostMapping
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.POST)
	public OrderDetail post(@RequestBody OrderDetail o) {
		return service.save(o);
	}

	@PutMapping
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.PUT)
	public OrderDetail put(@RequestBody OrderDetail o) {
		return service.update(o);
	}

	@DeleteMapping(value = "/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.DELETE)
	public OrderDetail delete(@PathVariable("id") int id) {
		OrderDetail p = service.findId(id);
		if (p != null) {
			service.remove(id);
		}
		return null;
	}

}
