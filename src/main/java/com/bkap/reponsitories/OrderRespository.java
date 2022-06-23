package com.bkap.reponsitories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bkap.entities.Orders;



@Repository
public interface OrderRespository extends JpaRepository<Orders, Integer> {
	@Query("SELECT DISTINCT o from Orders o Where o.status = :status")
	List<Orders> getOrderStatus(@Param("status") boolean status,Pageable pageable);
	
//	@Query("SELECT DISTINCT o FROM Orders o JOIN Customer c ON c.id = o.id Where c.id = :id")
//	List<Orders> getOrderByCustomerId(@Param("id") int id, Pageable pageable);
	
	@Query(value = "SELECT DISTINCT o.* FROM Orders o JOIN Customer c ON o.CustomerId = c.CustomerId Where c.CustomerId = :CustomerId",nativeQuery = true)
	List<Orders> getOrderByCustomerId(@Param("CustomerId") int id, Pageable pageable);
	
	@Query(value = "SELECT DISTINCT COUNT(OrderId) AS countOrder from Orders o Where o.status = :status",nativeQuery = true)
	int countOrderStatus(boolean status);

}
