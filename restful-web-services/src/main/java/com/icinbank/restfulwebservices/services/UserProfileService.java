package com.icinbank.restfulwebservices.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.icinbank.restfulwebservices.model.UserProfile;



@Service
public class UserProfileService {
	
	private static List < UserProfile> userProfiles = new ArrayList<UserProfile>();
	private static int idCounter = 0;

	
	static {
		userProfiles.add( new UserProfile(++idCounter,"simplilearn","12345", new Date(),"password", false,false));
		userProfiles.add( new UserProfile(++idCounter,"user2","12346", new Date(),"password",false,false));
		userProfiles.add( new UserProfile(++idCounter,"user3","12347", new Date(),"password",false,false));
	}
	

	public List <UserProfile> findAll(){
		return userProfiles;
	}
	
	public UserProfile findUserProfile(String username){
	
		for (UserProfile profile:userProfiles) {
			if (profile.getUsername().equals(username)) {
				return profile;
			}
		}
		return null;	
	}
	
	public UserProfile save( UserProfile profile) {
		if(profile.getId() == -1) {
			profile.setId(++idCounter);
			userProfiles.add(profile);			
		}else {
			deleteById (profile.getId());
			userProfiles.add(profile);
		}
		return profile;
	}
	
	public UserProfile deleteById ( long id) {
		
		UserProfile profile = findById (id);
		if (profile ==null) return null;
		
		if (userProfiles.remove(profile)) {
			return profile;	
		}
		return null;
	}
	
	public UserProfile findById (long id) {
		
		for (UserProfile profile:userProfiles) {
			if (profile.getId() == id) {
				return profile;
			}
		}
		return null;
	}
	
}