
package com.wiz.demo.sc.api_user.web.bean;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class LoginForm {

	@NotEmpty
	@Size(min=4, max=20)
	private String username = null;

	@NotEmpty
	@Size(min=6, max=20)
	private String password = null;

	public LoginForm() {
		
	}

	@Override
	public String toString() {
		return "LoginForm#{username=" + username + ",password=" + password + "}";
	}
}