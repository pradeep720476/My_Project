package com.mypharamacy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mypharamacy.entity.Medicine;
@Service
public interface MedicineService {
	List<Medicine> getMedicineDetails();

}
