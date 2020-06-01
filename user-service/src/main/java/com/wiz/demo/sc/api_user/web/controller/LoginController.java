
package com.wiz.demo.sc.api_user.web.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wiz.demo.sc.api_user.web.bean.LoginForm;
import com.wiz.demo.sc.util.ResponseUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user/auth")
public class LoginController {

	@PostMapping("/login")
	public Object login(@RequestBody @Valid LoginForm loginForm) {
		log.debug("LoginForm := {}", loginForm);
		return ResponseUtil.ok("200", "Success", loginForm);
	}
}