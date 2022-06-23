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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bkap.entities.Customer;
import com.bkap.request.LoginCustomer;
import com.bkap.services.CustomerService;

@RestController
@RequestMapping(value = "api")
public class CustomerController {
	@Autowired
	private CustomerService service;

	// Đếm sản phẩm
	@GetMapping(value = "/user/customer/count")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public int countProducts() {
		return service.countCustomer();
	}

	@GetMapping(value = "/user/customer")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<Customer> get() {
		return service.findAll();
	}

	@GetMapping(value = "/user/customer/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public Customer get(@PathVariable("id") int id) {
		return service.findId(id);
	}

	@GetMapping(value = "/user/customer/getEmail/{email}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public Customer getByEmail(@PathVariable("email") String email) {
		return service.getByEmail(email);
	}

	@GetMapping(value = "/user/customer/get/")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public Customer get(@RequestParam(name = "phone", required = false, defaultValue = "0") String phone,
			@RequestParam(name = "email", required = false, defaultValue = "0") String email) {
		return service.getByPhoneOrEmail(phone, email);
	}

	@GetMapping(value = "/user/customer/eamil/{email}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public List<Customer> get(@PathVariable("email") String email) {
		return service.findByEmail(email);
	}

//	@GetMapping(value = "/user/customer/find")
//	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
//	public List<Customer> getList(@RequestParam(name = "phone", required = false, defaultValue = "xxx") String phone,@RequestParam(name = "email", required = false, defaultValue = "xxx") String email) {
//		return service.findByPhoneOrEmail(phone, email);
//	}

	@PostMapping(value = "/user/customer")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.POST)
	public Customer post(@RequestBody Customer p) {
		return service.save(p);
	}

	@PostMapping(value = "/user/customer/login/")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.POST)
	public Customer login(@RequestBody LoginCustomer obj) {
		Customer customer = new Customer();
		customer = service.getByEmail(obj.getEmail());
		if (customer.getPassword().equalsIgnoreCase(obj.getPassword())) {
//			customer.setPassword(null);
			return customer;
		} else {
			return null;
		}

	}

	@PutMapping(value = "/user/customer")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.PUT)
	public Customer put(@RequestBody Customer p) {
		return service.update(p);
	}

	@DeleteMapping(value = "/admin/customer/{id}")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.DELETE)
	public Customer delete(@PathVariable("id") int id) {
		Customer p = service.findId(id);
		if (p != null) {
			service.remove(id);
		}
		return null;
	}
}
