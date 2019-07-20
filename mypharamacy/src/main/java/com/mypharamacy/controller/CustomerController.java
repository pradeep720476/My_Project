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
	public ResponseEntity<Object> addUser(@RequestBody User pUser) {
		
		int cusId = isUserValid(pUser);
		
		 if(cusId > 0) {
			 return new ResponseEntity<Object>("USER ALREADY EXIST",HttpStatus.CONFLICT);
		 }
		 else {
			 customerService.registerUser(pUser);
			 cusId = isUserValid(pUser);
			 HttpHeaders headers = new HttpHeaders();
			 pUser.setCustomerid(cusId);
             return new ResponseEntity<Object>(pUser,headers, HttpStatus.CREATED);
		 }
	}
	
	@PostMapping("/validate")
	public ResponseEntity<Object> validateUser(@RequestBody User pUser){
		 HttpHeaders headers = new HttpHeaders();
		
		 int cusId =   isUserValid(pUser);
		 if(cusId > 0) {
			 pUser.setCustomerid(cusId);
			 return new ResponseEntity<Object>(pUser,headers, HttpStatus.OK);
		 }
		 else {
			 return new ResponseEntity<Object>("INVALID CREDENTIALS",HttpStatus.BAD_REQUEST);
		 }
	}
	
	private int isUserValid(User pUser) {
		 Object  present =  customerService.validate(pUser);
		 if(null != present) {
			 return  Integer.parseInt(present.toString());	 
		 }
		 else {
			 return 0;
		 }
		 
	}

}
