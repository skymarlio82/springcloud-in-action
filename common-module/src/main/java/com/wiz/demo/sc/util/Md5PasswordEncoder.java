
package com.wiz.demo.sc.util;

public class Md5PasswordEncoder {

	public String encode(CharSequence rawPassword) {
		return Md5Parser.parseStrToMd5L32(rawPassword.toString());
	}

	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return encode(rawPassword).equals(encodedPassword);
	}
}