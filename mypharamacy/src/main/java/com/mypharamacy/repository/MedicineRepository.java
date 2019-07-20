package com.mypharamacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.mypharamacy.entity.Medicine;

@Repository
@EnableJpaRepositories
public interface MedicineRepository extends JpaRepository<Medicine, Integer> {
	

}
