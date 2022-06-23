package com.bkap.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bkap.entities.Customer;
import com.bkap.reponsitories.CustomerRespository;

@Service
public class CustomerServiceImp implements CustomerService {
	@Autowired
	private CustomerRespository customerRespository;

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerRespository.findAll();
	}

	@Override
	public Customer findId(int id) {
		// TODO Auto-generated method stub
		return customerRespository.getById(id);
	}

	@Override
	public Customer save(Customer c) {
		// TODO Auto-generated method stub
		return customerRespository.save(c);
	}

	@Override
	public Customer update(Customer c) {
		// TODO Auto-generated method stub
		return customerRespository.save(c);
	}

	@Override
	public void remove(int id) {
		customerRespository.deleteById(id);


	}

	@Override
	public List<Customer> findByEmail(String email) {
		// TODO Auto-generated method stub
		return customerRespository.findByEmail(email);
	}

	@Override
	public List<Customer> findByPhone(String phone) {
		// TODO Auto-generated method stub
		return customerRespository.findByPhone(phone);
	}

//	@Override
//	public List<Customer> findByPhoneOrEmail(String phone, String email) {
//		// TODO Auto-generated method stub
//		return customerRespository.findByPhoneOrEmail(phone, email);
//	}

	@Override
	public Customer getByPhoneOrEmail(String phone, String email) {
		// TODO Auto-generated method stub
		return customerRespository.getByPhoneOrEmail(phone, email);
	}

	@Override
	public Customer getByEmail(String email) {
		// TODO Auto-generated method stub
		return customerRespository.getByEmail(email);
	}

	@Override
	public List<Customer> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return customerRespository.getAll(pageable);
	}

	@Override
	public int countCustomer() {
		// TODO Auto-generated method stub
		return customerRespository.countCustomer();
	}

	

}
