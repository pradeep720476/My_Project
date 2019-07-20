package com.mypharamacy.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mypharamacy.entity.User;


@Repository
public interface RegisterUserRepository extends CrudRepository<User , Long>{

	@Query(value = "SELECT customerid FROM customers where customername = ?1" , nativeQuery = true)
	public Object isUserExist(String customername);


}
