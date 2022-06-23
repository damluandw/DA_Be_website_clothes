package com.bkap.reponsitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bkap.entities.SliderHome;

@Repository
public interface SliderHomeRespository extends JpaRepository<SliderHome, Integer> {

}
