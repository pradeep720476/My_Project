package com.mypharamacy.service;

import org.springframework.web.multipart.MultipartFile;

public interface CustomerService {
	
	public int upload(MultipartFile file);
	

}
