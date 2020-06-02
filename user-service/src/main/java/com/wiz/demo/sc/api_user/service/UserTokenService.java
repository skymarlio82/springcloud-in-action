
package com.wiz.demo.sc.api_user.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.wiz.demo.sc.util.UserTokenManager;

@Service
public class UserTokenService {

	@Value("${jwt.secret.hs256}")
	private String secretHS256 = null;

	public String genToken(Integer userId) {
		return UserTokenManager.generateToken(userId, secretHS256);
	}

	public boolean checkToken(String token) {
		return UserTokenManager.getUserId(token, secretHS256) > 0 ? true : false;
	}
}