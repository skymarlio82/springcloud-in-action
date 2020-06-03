
package com.wiz.demo.sc.api_user.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wiz.demo.sc.api_user.service.UserTokenService;

@RestController
@RequestMapping("/user/token")
public class TokenController {

	private final static Logger logger = LoggerFactory.getLogger(TokenController.class);

	@Autowired
	private UserTokenService userTokenService = null;
 
	@RequestMapping("/validate")
	public String validateToken(@RequestParam String token) {
		boolean result = userTokenService.validateToken(token);
		logger.info("===> token:{},result:{}", token, result);
		return result ? "Success" : "Failure";
	}
}