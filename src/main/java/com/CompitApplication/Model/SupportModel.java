package com.CompitApplication.Model;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="support_model")
public class SupportModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int supportid;

	 
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties("fromsuppId")
	private ProfileModel supportingId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties("toSupportId")
	private ProfileModel supportGettingId;

	public SupportModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SupportModel(int supportid, ProfileModel supportingId, ProfileModel supportGettingId) {
		super();
		this.supportid = supportid;
		this.supportingId = supportingId;
		this.supportGettingId = supportGettingId;
	}

	@Override
	public String toString() {
		return "SupportModel [supportid=" + supportid + ", supportingId=" + supportingId + ", supportGettingId="
				+ supportGettingId + "]";
	}

	public int getSupportid() {
		return supportid;
	}

	public void setSupportid(int supportid) {
		this.supportid = supportid;
	}

	public ProfileModel getSupportingId() {
		return supportingId;
	}

	public void setSupportingId(ProfileModel supportingId) {
		this.supportingId = supportingId;
	}

	public ProfileModel getSupportGettingId() {
		return supportGettingId;
	}

	public void setSupportGettingId(ProfileModel supportGettingId) {
		this.supportGettingId = supportGettingId;
	}
	
	
	
	
}
