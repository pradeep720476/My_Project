package com.mypharamacy.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mypharamacy.entity.Image;
import com.mypharamacy.entity.User;
import com.mypharamacy.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public int upload(MultipartFile imageFile) throws Exception {

		try {
			Image presciption = new Image(imageFile.getBytes());
			presciption.setStatus('N');
			customerRepository.upload(presciption);
		} catch (IOException e) {
			throw new Exception("Error while imaging upload");
		}

		return 0;
	}

	@Override
	public void registerUser(User pUser) {
		boolean isUserExists = false;//registerUserRepo.isExist(pUser);
		if(!isUserExists) {
			customerRepository.save(pUser);
		}
		else {
			System.out.println("Data Already available");
		}
		
	}

	@Override
	public Object validate(User pUser) {
		return customerRepository.isUserExist(pUser.getCustomername());
	}

}
