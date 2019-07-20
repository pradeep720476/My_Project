package com.mypharamacy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypharamacy.entity.Medicine;
import com.mypharamacy.repository.MedicineRepositoryImpl;
@Service("medicineService")
public class MedicineServiceImpl implements MedicineService {
	
	@Autowired
	MedicineRepositoryImpl medicineRepositoryImpl;
	@Override
	public List<Medicine> getMedicineDetails() {
		// TODO Auto-generated method stub
		System.out.println("Entering");
		List<Medicine> medicineList=medicineRepositoryImpl.getMedicineDetails();
		if(medicineList==null)
		{
			System.out.println("Not found");
		}
		return medicineList;
		
	}

}
