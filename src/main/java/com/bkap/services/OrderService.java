package com.bkap.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.bkap.entities.Orders;

public interface OrderService {
	List<Orders> findAll();

	List<Orders> getOrderStatus(boolean stauts, Pageable pageable);

	List<Orders> getOrderByCustomerId(int id, Pageable pageable);

	Orders findId(int id);

	Orders save(Orders o);

	Orders update(Orders o);

	void remove(int id);

	int countOrderStatus(boolean status);
	
}
