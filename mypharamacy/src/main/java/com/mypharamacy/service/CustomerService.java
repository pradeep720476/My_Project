package com.mypharamacy.service;

import org.springframework.web.multipart.MultipartFile;

import com.mypharamacy.entity.User;

 

public interface CustomerService {
	
	public int upload(MultipartFile file) throws Exception;
	public void registerUser(User pUser);
	public Object validate(User pUser);

}
