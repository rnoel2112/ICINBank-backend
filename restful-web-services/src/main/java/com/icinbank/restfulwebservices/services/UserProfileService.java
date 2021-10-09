package com.icinbank.restfulwebservices.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.icinbank.restfulwebservices.model.UserProfile;


@Service
public interface UserProfileService {
	
	List <UserProfile> 	findAll();
	UserProfile	getByUsername(String username);
	UserProfile save(UserProfile account);
	UserProfile deleteById (long id);
	UserProfile findById (long id);
}

