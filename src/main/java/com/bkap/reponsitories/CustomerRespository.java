package com.bkap.reponsitories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bkap.entities.Customer;

@Repository
public interface CustomerRespository extends JpaRepository<Customer, Integer> {
	@Query(value = "SELECT DISTINCT c from Customer c Where c.email like %:email%", nativeQuery = true)
	List<Customer> findByEmail(@Param("email") String email);

	@Query("SELECT c from Customer c Where c.email = :email")
	Customer getByEmail(@Param("email") String email);

	@Query(value = "SELECT DISTINCT c from Customer c Where c.phone like %:phone%", nativeQuery = true)
	List<Customer> findByPhone(@Param("phone") String phone);

//	@Query("SELECT DISTINCT c from Customer c Where c.phone like %:phone% or c.email like %:email%")
//	List<Customer> findByPhoneOrEmail(@Param("phone") String phone, @Param("email") String email);

	@Query(value = "SELECT DISTINCT c from Customer c Where c.phone = %:phone% or c.email = %:email%", nativeQuery = true)
	Customer getByPhoneOrEmail(@Param("phone") String phone, @Param("email") String email);
	
	
	@Query(value = "SELECT DISTINCT c from Customer c", nativeQuery = true)
	List<Customer> getAll(Pageable pageable);
	
	@Query("SELECT DISTINCT COUNT(CustomerId) AS countCustomer from Customer ")
	int countCustomer();
	
}
