package com.bkap.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.bkap.entities.Customer;

public interface CustomerService {
	List<Customer> findAll();

	Customer findId(int id);

	List<Customer> findByEmail(String email);

	Customer getByEmail(String email);

	List<Customer> findByPhone(String phone);

//	List<Customer> findByPhoneOrEmail(String phone, String email);

	Customer getByPhoneOrEmail(String phone, String email);

	Customer save(Customer c);

	Customer update(Customer c);

	void remove(int id);

	List<Customer> getAll(Pageable pageable);

	int countCustomer();
}
