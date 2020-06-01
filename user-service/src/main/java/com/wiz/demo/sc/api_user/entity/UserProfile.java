
package com.wiz.demo.sc.api_user.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="scd_user_profile_tab")
public class UserProfile implements Serializable {

	private static final long serialVersionUID = -6731793885662233394L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id = 0;

	private String username = null;

	private String password = null;

	public UserProfile() {
		
	}

	@Override
	public String toString() {
		return "UserProfile#{id=" + id + ",username=" + username + ",password=" + password + "}";
	}
}
