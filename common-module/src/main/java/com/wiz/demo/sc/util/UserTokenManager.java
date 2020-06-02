
package com.wiz.demo.sc.util;

public class UserTokenManager {

	public static String generateToken(Integer id, String secret) {
		JwtHelper jwtHelper = new JwtHelper();
		return jwtHelper.createToken(id, secret);
	}
	
	public static String generateToken(Integer id) {
		JwtHelper jwtHelper = new JwtHelper();
		return jwtHelper.createToken(id);
	}

	public static Integer getUserId(String token, String secret) {
		JwtHelper jwtHelper = new JwtHelper();
		Integer userId = jwtHelper.verifyTokenAndGetUserId(token, secret);
		if (userId == null || userId == 0) {
			return null;
		}
		return userId;
	}

	public static Integer getUserId(String token) {
		JwtHelper jwtHelper = new JwtHelper();
		Integer userId = jwtHelper.verifyTokenAndGetUserId(token);
		if (userId == null || userId == 0) {
			return null;
		}
		return userId;
	}
}