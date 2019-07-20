package com.mypharamacy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mypharamacy.entity.Image;
import com.mypharamacy.entity.User;

@Repository("customerRepository")
public class CustomerRepositoryImpl implements CustomerRepository {
	@Autowired
	private RegisterUserRepository registerUserRepository;

	@Autowired
	private UploadRepository uploadRespository;

	@Override
	public Image upload(Image image) {

		return uploadRespository.save(image);
	}

	@Override
	public User save(User pUser) {
		// TODO Auto-generated method stub
		return registerUserRepository.save(pUser);
	}

	@Override
	public User validate(User pUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object isUserExist(String customername) {
		 
		return  registerUserRepository.isUserExist(customername);
	}


}
