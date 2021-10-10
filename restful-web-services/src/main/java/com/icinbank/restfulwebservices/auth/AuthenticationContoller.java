package com.icinbank.restfulwebservices.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.icinbank.restfulwebservices.model.UserProfile;
import com.icinbank.restfulwebservices.services.UserProfileServiceImpl;

//Controller
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class AuthenticationContoller {

	@Autowired
	private UserProfileServiceImpl profileService;
	
	@GetMapping(path = "/basicauth")
	public AuthenticationBean authBean() {
		//throw new RuntimeException("Some Error has Happened! Contact Support at ***-***");
		return new AuthenticationBean("You are authenticated");
		// return null;
	}
	
	@PostMapping(path = "/registeruser")
	public ResponseEntity<UserProfile> RegisterProfile(@RequestBody UserProfile profile){
		UserProfile profileUpdated = profileService.save(profile);
		
		return new ResponseEntity<UserProfile>(profileUpdated, HttpStatus.OK);
	}	
}
