package com.mypharamacy.service;

import org.springframework.web.multipart.MultipartFile;

import com.mypharamacy.entity.User;

 

public interface CustomerService {
	
	public int upload(MultipartFile file);
	public void registerUser(User pUser);

}
