package com.bkap.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bkap.entities.OrderDetail;
import com.bkap.reponsitories.OrderDetailRespository;

@Service
public class OrderDetailServiceImp implements OrderDetailService {
	@Autowired
	private OrderDetailRespository orderDetailRespository;

	@Override
	public List<OrderDetail> findAll() {
		// TODO Auto-generated method stub
		return orderDetailRespository.findAll();
	}

	@Override
	public OrderDetail findId(int id) {
		// TODO Auto-generated method stub
		return orderDetailRespository.getById(id);
	}

	@Override
	public OrderDetail save(OrderDetail o) {
		// TODO Auto-generated method stub
		return orderDetailRespository.save(o);
	}

	@Override
	public OrderDetail update(OrderDetail o) {
		// TODO Auto-generated method stub
		return orderDetailRespository.save(o);
	}

	@Override
	public void remove(int id) {
		orderDetailRespository.deleteById(id);

	}

	@Override
	public List<OrderDetail> getOrderDetailByCustomerId(int id, Pageable pageable) {
		// TODO Auto-generated method stub
		return orderDetailRespository.getOrderDetailByCustomerId(id, pageable);
	}

	@Override
	public List<OrderDetail> getOrderDetailByOrderId(int id) {
		// TODO Auto-generated method stub
		return orderDetailRespository.getOrderDetailByOrderId(id);
	}
}
