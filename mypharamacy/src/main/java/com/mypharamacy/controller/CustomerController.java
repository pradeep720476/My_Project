package com.mypharamacy.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mypharamacy.service.CustomerService;

@RestController("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping(value = "/customer/upload-preception")
	public ResponseEntity<Object> uploadImage(@RequestParam("image") MultipartFile imageFile) throws IOException {

		String filename = imageFile.getOriginalFilename();
		if (filename.contains("..")) {
			// Throw Exception
		}

		customerService.upload(imageFile);

		return new ResponseEntity<Object>(HttpStatus.OK);

	}

}
