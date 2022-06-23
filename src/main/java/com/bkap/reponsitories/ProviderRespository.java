package com.bkap.reponsitories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bkap.entities.Provider;

@Repository
public interface ProviderRespository extends JpaRepository<Provider, Integer> {
	@Query("SELECT p from Provider p Where p.name like %:name%")
	List<Provider> findByName(@Param("name") String name);
}
