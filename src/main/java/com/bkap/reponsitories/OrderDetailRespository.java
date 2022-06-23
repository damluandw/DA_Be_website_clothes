package com.bkap.reponsitories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bkap.entities.OrderDetail;

@Repository
public interface OrderDetailRespository extends JpaRepository<OrderDetail, Integer> {
	@Query(value = "SELECT DISTINCT od.* FROM OrderDetail od JOIN Orders o ON o.OrderId=od.OrderId JOIN Customer c ON o.CustomerId = c.CustomerId Where c.CustomerId = :CustomerId", nativeQuery = true)
	List<OrderDetail> getOrderDetailByCustomerId(@Param("CustomerId") int id, Pageable pageable);

	@Query(value = "SELECT DISTINCT od.* FROM OrderDetail od JOIN Orders o ON o.OrderId = od.OrderId Where o.OrderId = :OrderId", nativeQuery = true)
	List<OrderDetail> getOrderDetailByOrderId(@Param("OrderId") int id);
}
