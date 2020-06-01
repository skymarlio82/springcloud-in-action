
package com.wiz.demo.sc.api_user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wiz.demo.sc.api_user.entity.UserProfile;

@Repository
public interface UserProfileRepo extends JpaRepository<UserProfile, Integer> {

	@Query("from UserProfile up order by up.username")
	List<UserProfile> findAll();
	UserProfile findByUsername(String username);
}