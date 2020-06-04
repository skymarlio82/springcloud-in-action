
package com.wiz.demo.sc.api_user.web.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wiz.demo.sc.api_user.service.UserTokenService;

@RestController
@RequestMapping("/user/token")
public class TokenController {

	private final static Logger logger = LoggerFactory.getLogger(TokenController.class);

	@Autowired
	private UserTokenService userTokenService = null;
 
//	@RequestMapping("/validate")
//	public String validateToken(@RequestParam String token) {
//		boolean result = userTokenService.validateToken(token);
//		logger.info("===> token:{},result:{}", token, result);
//		return result ? "Success" : "Failure";
//	}

//	@PostMapping("/validate")
//	public String validateToken(@RequestBody String token) {
//		boolean result = userTokenService.validateToken(token);
//		logger.info("===> token:{},result:{}", token, result);
//		return result ? "Success" : "Failure";
//	}

	@PostMapping("/validate")
	public String validateToken(@RequestBody Map<String, Object> inputs) {
		String token = (String)inputs.get("token");
		boolean result = userTokenService.validateToken(token);
		logger.info("===> token:{},result:{}", token, result);
		return result ? "Success" : "Failure";
	}
}