package com.CompitApplication.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Customer_contact")
public class SmsEntity {

	@Id
	private Integer id;
	
	@Column(name = "phn_number")
	private String phnnumber;
	
	@JsonIgnore
	@Column(name="Name")
	private String name;
	
	@JsonIgnore
	@Column(name="Gmail_id")
	private String  mailid;

	public SmsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SmsEntity(int id, String phnnumber, String name, String mailid) {
		super();
		this.id = id;
		this.phnnumber = phnnumber;
		this.name = name;
		this.mailid = mailid;
	}

	@Override
	public String toString() {
		return "SmsEntity [id=" + id + ", phnnumber=" + phnnumber + ", name=" + name + ", mailid=" + mailid + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhnnumber() {
		return phnnumber;
	}

	public void setPhnnumber(String phnnumber) {
		this.phnnumber = phnnumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
}