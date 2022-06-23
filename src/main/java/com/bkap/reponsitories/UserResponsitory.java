package com.bkap.reponsitories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bkap.entities.Users;

@Repository
public interface UserResponsitory extends JpaRepository<Users, Integer> {
	Users findByName(String name);

	List<Users> findByEmailAndPassword(String name, String password);

	List<Users> findByEmail(String name);
}
