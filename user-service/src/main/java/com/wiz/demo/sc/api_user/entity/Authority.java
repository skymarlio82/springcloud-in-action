
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
@Table(name="scd_authority_tab")
public class Authority implements Serializable {

	private static final long serialVersionUID = -7646395196795772953L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id = 0;
    private String name = null;

    public Authority() {

    }

	@Override
	public String toString() {
		return "Authority#{id=" + id + ",name=" + name + "}";
	}
}