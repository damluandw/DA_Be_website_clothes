package com.bkap.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.bkap.entities.OrderDetail;

public interface OrderDetailService {
	List<OrderDetail> findAll();

	List<OrderDetail> getOrderDetailByCustomerId(int id, Pageable pageable);
	
	List<OrderDetail> getOrderDetailByOrderId(int id);

	OrderDetail findId(int id);

	OrderDetail save(OrderDetail o);

	OrderDetail update(OrderDetail o);

	void remove(int id);
}
