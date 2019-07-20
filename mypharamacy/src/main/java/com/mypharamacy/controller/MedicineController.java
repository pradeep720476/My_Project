package com.mypharamacy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mypharamacy.entity.Medicine;
import com.mypharamacy.service.MedicineService;

@RestController
@RequestMapping("/pharmacy")
public class MedicineController {
	@Autowired
	MedicineService medicineService;
	 
	@RequestMapping(value = "/getMedicine", method = RequestMethod.GET)
	public ResponseEntity<List<Medicine>> getMedicineDetails() {
		System.out.println("Entering");
		List<Medicine> medicineList = medicineService.getMedicineDetails();
		if (medicineList.isEmpty()) {
			//throw new PartnerNotFoundException("No medicne found");
		}

		return new ResponseEntity<List<Medicine>>(medicineList, HttpStatus.OK);

	}

	//public List<Medicine> 

}
