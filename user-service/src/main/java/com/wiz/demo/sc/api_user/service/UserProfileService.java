
package com.wiz.demo.sc.api_user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wiz.demo.sc.api_user.entity.UserProfile;
import com.wiz.demo.sc.api_user.repository.UserProfileRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserProfileService {

	@Autowired
	private UserProfileRepo userProfileRepo = null;

	@Transactional(readOnly=true)
	public UserProfile getUserByName(String username) {
		UserProfile user = userProfileRepo.findByUsername(username);
		log.debug("===> getUserByName ({}) := {}", username, user);
		return user;
	}
}