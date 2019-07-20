package com.mypharamacy.repository;

import org.springframework.data.jpa.repository.Query;

import com.mypharamacy.entity.Image;
import com.mypharamacy.entity.User;

public interface CustomerRepository {
	public Image upload(Image image);

	public User save(User pUser);
	public User validate(User pUser);
	
	@Query(value = "SELECT customerid FROM customers where customername = ?1" , nativeQuery = true)
	public Object isUserExist(String customername);

}
