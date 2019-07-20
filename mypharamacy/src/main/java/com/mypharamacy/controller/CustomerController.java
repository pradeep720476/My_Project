package com.mypharamacy.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mypharamacy.entity.User;
import com.mypharamacy.service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	/**
	 * Method to upload image for customer
	 * 
	 * @param imageFile
	 * @return
	 * @throws IOException
	 */
	@PostMapping(value = "/upload-preception")
	public ResponseEntity<Object> uploadImage(@RequestBody MultipartFile imageFile) {

		try {
			String filename = imageFile.getOriginalFilename();
			if (filename.contains("..")) {
				new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
			}
			customerService.upload(imageFile);
		} catch (Exception excpetion) {
			new ResponseEntity<Object>(excpetion.getMessage(), HttpStatus.FORBIDDEN);
		}

		return new ResponseEntity<Object>(HttpStatus.OK);

	}

	@GetMapping(value = "/get")
	public ResponseEntity<Object> get() throws IOException {

		return new ResponseEntity<Object>(HttpStatus.OK);

	}

	@PostMapping("/register")
	public ResponseEntity<Void> addUser(@RequestBody User pUser) {
		// IResigesterUserService registerUserService = new RegisterUserService();
		try {
			customerService.registerUser(pUser);
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

	}

}
