
package com.wiz.demo.sc.api_user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wiz.demo.sc.api_user.entity.UserProfile;
import com.wiz.demo.sc.api_user.repository.UserProfileRepo;

@Service
public class UserProfileService {

	private final static Logger logger = LoggerFactory.getLogger(UserProfileService.class);

	@Autowired
	private UserProfileRepo userProfileRepo = null;

	@Transactional(readOnly=true)
	public UserProfile getUserByName(String username) {
		UserProfile user = userProfileRepo.findByUsername(username);
		logger.debug("===> getUserByName ({}) := {}", username, user);
		return user;
	}
}