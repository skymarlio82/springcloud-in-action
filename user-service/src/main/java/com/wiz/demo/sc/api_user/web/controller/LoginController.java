
package com.wiz.demo.sc.api_user.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wiz.demo.sc.api_user.entity.UserProfile;
import com.wiz.demo.sc.api_user.service.UserProfileService;
import com.wiz.demo.sc.api_user.service.UserTokenService;
import com.wiz.demo.sc.api_user.web.form.LoginForm;
import com.wiz.demo.sc.api_user.web.vo.UserInfo;
import com.wiz.demo.sc.util.Md5PasswordEncoder;
import com.wiz.demo.sc.util.ResponseUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user/auth")
public class LoginController {

	@Autowired
	private UserProfileService userProfileService = null;

	@Autowired
	private UserTokenService userTokenService = null;

	@PostMapping("/login")
	public Object login(@RequestBody @Valid LoginForm loginForm) {
		log.debug("LoginForm := {}", loginForm);
		UserProfile user = userProfileService.getUserByName(loginForm.getUsername());
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		UserInfo userInfo = new UserInfo();
		if (md5.matches(loginForm.getPassword(), user.getPassword())) {
			userInfo.setUserId(user.getId());
			userInfo.setUserName(user.getUsername());
			userInfo.setUserToken(userTokenService.genToken(user.getId()));
		}
		return ResponseUtil.ok("200", "Success", userInfo);
	}
}