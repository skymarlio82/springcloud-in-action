
package com.wiz.demo.sc.api_user.web.vo;

import lombok.Data;

@Data
public class UserInfo {

	private int userId = 0;
	private String userName = null;
	private String userToken = null;
	
	public UserInfo() {
		
	}

	public UserInfo(int userId, String userName, String userToken) {
		this.userId = userId;
		this.userName = userName;
		this.userToken = userToken;
	}
}