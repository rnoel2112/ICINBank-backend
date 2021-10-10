package com.icinbank.restfulwebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.icinbank.restfulwebservices.auth.AuthenticationBean;
import com.icinbank.restfulwebservices.model.UserProfile;
import com.icinbank.restfulwebservices.services.UserProfileServiceImpl;



@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserProfileController {
	
	@Autowired
	private UserProfileServiceImpl profileService;
	

	@GetMapping("/users/{username}/profiledetails")
	public List <UserProfile> getAllProfilesByUser(@PathVariable String username){
		return profileService.findAll();
	}
	
	
	@GetMapping("/users/{username}/profiledetail")
	public ResponseEntity<UserProfile> getProfile(@PathVariable String username){
		UserProfile profile = profileService.getByUsername(username);
		if (profile != null) {
			return new ResponseEntity<UserProfile>(profile, HttpStatus.OK);
		}
		return ResponseEntity.noContent().build();

	}
	
	@GetMapping("/users/userprofiles")
	public List <UserProfile> getAllProfiles(){
		return profileService.findAll();
	}
	
	
	@GetMapping("/users/{username}/profiledetail/{id}")
	public ResponseEntity<UserProfile> getProfile(@PathVariable String username,@PathVariable long id){
		UserProfile profile = profileService.findById(id);
		if (profile != null) {
			return new ResponseEntity<UserProfile>(profile, HttpStatus.OK);
		}
		return ResponseEntity.noContent().build();

	}
	
	
	@DeleteMapping("/users/{username}/profiledetail/{id}")
	public ResponseEntity<Void> deleteProfile(@PathVariable String username, @PathVariable long id){
		UserProfile profile = profileService.deleteById(id);
		if (profile != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/users/{username}/profiledetail/{id}")
	public ResponseEntity<UserProfile> updateProfile(@PathVariable String username, @PathVariable long id,
			@RequestBody UserProfile profile){
		UserProfile profileUpdated = profileService.save(profile);
		
		return new ResponseEntity<UserProfile>(profileUpdated, HttpStatus.OK);
	}

	
	@PostMapping("/users/{username}/profiledetail")
	public ResponseEntity<UserProfile> createProfile(@PathVariable String username,
			@RequestBody UserProfile profile){
		UserProfile profileUpdated = profileService.save(profile);
		
		return new ResponseEntity<UserProfile>(profileUpdated, HttpStatus.OK);
	}
	
//	@PreAuthorize("permitAll()")  
//	@PostMapping(path = "/registerusers")
//	@ResponseBody 
//	public ResponseEntity<UserProfile> RegisterProfile(@RequestBody UserProfile profile){
//		UserProfile profileUpdated = profileService.save(profile);
//		
//		return new ResponseEntity<UserProfile>(profileUpdated, HttpStatus.OK);
//	}
}
