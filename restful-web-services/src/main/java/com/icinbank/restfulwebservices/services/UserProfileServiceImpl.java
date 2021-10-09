package com.icinbank.restfulwebservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinbank.restfulwebservices.model.UserProfile;
import com.icinbank.restfulwebservices.repository.UserProfileRepository;

@Service
public class UserProfileServiceImpl implements UserProfileService{

	@Autowired 
	private UserProfileRepository userProfileRepository;
	
	@Override
	public List<UserProfile> findAll() {
		return this.userProfileRepository.findAll();
	}

	@Override
	public UserProfile getByUsername(String username) {
		return this.userProfileRepository.getByUsername(username);
	}

	@Override
	public UserProfile save(UserProfile profile) {
		return this.userProfileRepository.save(profile);
	}

	@Override
	public UserProfile deleteById(long id) {
		return this.userProfileRepository.deleteById(id);
	}

	@Override
	public UserProfile findById(long id) {
		return this.userProfileRepository.findById(id);
	}
	
}
