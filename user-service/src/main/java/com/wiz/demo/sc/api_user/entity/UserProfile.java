
package com.wiz.demo.sc.api_user.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	private boolean enabled = false;
    private Date lastPasswordResetDate = null;
    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="scd_user_authority_tab",
		joinColumns={ @JoinColumn(name="user_id", nullable=false, updatable=false) },
		inverseJoinColumns={ @JoinColumn(name="authority_id", nullable=false, updatable=false) }
	)
    private List<Authority> authorities = null;

	public UserProfile() {
		
	}

	@Override
	public String toString() {
		return "UserProfile#{id=" + id + ",username=" + username + ",password=" + password + ",enabled=" + enabled + ",lastPasswordResetDate=" + lastPasswordResetDate + ",authorities=" + authorities + "}";
	}
}
