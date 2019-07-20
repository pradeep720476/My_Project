package com.mypharamacy.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mypharamacy.entity.Medicine;

@Transactional
public class MedicineRepositoryImpl {
	@Autowired
	MedicineRepository repo;
	public List<Medicine> getMedicineDetails() {

	
		System.out.println("Entering");
		List<Medicine> getMedicineList = (List<Medicine>) repo.findAll();
		System.out.println("Repor"+getMedicineList);
		
		return getMedicineList ;
		
		
		
	}

}
