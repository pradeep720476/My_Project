package com.mypharamacy.repository;

import com.mypharamacy.entity.Image;
import com.mypharamacy.entity.User;

public interface CustomerRepository {
	public Image upload(Image image);

	public User save(User pUser);

}
