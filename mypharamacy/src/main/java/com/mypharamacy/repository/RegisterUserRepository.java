package com.mypharamacy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mypharamacy.entity.User;


@Repository
public interface RegisterUserRepository extends CrudRepository<User , Long>{

	//boolean isExistsss(User pUser);

}
