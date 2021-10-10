package com.icinbank.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icinbank.restfulwebservices.model.UserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository <UserProfile, Long> {

	UserProfile getByUsername(String username);
	UserProfile	deleteById (long id);
	UserProfile findById (long id);
}
