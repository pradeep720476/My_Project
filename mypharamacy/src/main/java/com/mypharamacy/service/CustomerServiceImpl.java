package com.mypharamacy.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.mypharamacy.entity.Presciption;
import com.mypharamacy.repository.CustomerRepository;

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public int upload(MultipartFile imageFile) {

		String filename = imageFile.getOriginalFilename();

		if (filename.contains("..")) {
			// throw exception
		}

		try {
			Presciption presciption = new Presciption(imageFile.getBytes());
			customerRepository.upload(presciption);
		} catch (IOException e) {

		}

		return 0;
	}

}
