package com.bkap.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bkap.entities.Orders;
import com.bkap.reponsitories.OrderRespository;

@Service
public class OrderServiceImp implements OrderService {
	@Autowired
	private OrderRespository orderRespository;

	@Override
	public List<Orders> findAll() {
		// TODO Auto-generated method stub
		return orderRespository.findAll();
	}

	@Override
	public Orders findId(int id) {
		// TODO Auto-generated method stub
		return orderRespository.getById(id);
	}

	@Override
	public Orders save(Orders o) {
		// TODO Auto-generated method stub
		return orderRespository.save(o);
	}

	@Override
	public Orders update(Orders o) {
		// TODO Auto-generated method stub
		return orderRespository.save(o);
	}

	@Override
	public void remove(int id) {
		orderRespository.deleteById(id);

	}

	@Override
	public List<Orders> getOrderStatus(boolean stauts, Pageable pageable) {
		// TODO Auto-generated method stub
		return orderRespository.getOrderStatus(stauts, pageable);
	}

	@Override
	public List<Orders> getOrderByCustomerId(int id, Pageable pageable) {
		// TODO Auto-generated method stub
		return orderRespository.getOrderByCustomerId(id, pageable);
	}

	@Override
	public int countOrderStatus(boolean status) {
		// TODO Auto-generated method stub
		return orderRespository.countOrderStatus(status);
	}

}
