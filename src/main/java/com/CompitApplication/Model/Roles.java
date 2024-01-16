package com.CompitApplication.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role_model_table")
public class Roles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleId;
	
	private String name;

	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roles(int roleId, String name) {
		super();
		this.roleId = roleId;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Roles [roleId=" + roleId + ", name=" + name + "]";
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
	
	

}
