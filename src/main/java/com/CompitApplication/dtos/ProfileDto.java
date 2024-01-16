package com.CompitApplication.dtos;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class ProfileDto {

	@JsonIgnore
	private Long ProfileId;
	
	@Valid
	@NotNull
	@NotBlank(message = "Please Pick your username")
	private String usernames;

	@Valid
    @Size(min = 10)
	@NotBlank
    @NotBlank(message="Please enter your phone number ")
	private String phnNumber;
	@Valid
	@NotNull
	@NotBlank(message = "Please enter your gmail ID ")
	@Email
	private String gmail;
	@Valid
	@NotNull
	@NotBlank(message = "The Password cannont be blank")
	private String password;

	private String dob;

	

	public String getUsernames() {
		return usernames;
	}

	public void setUsernames(String usernames) {
		this.usernames = usernames;
	}

	public String getPhnNumber() {
		return phnNumber;
	}

	public void setPhnNumber(String phnNumber) {
		this.phnNumber = phnNumber;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Long getProfileId() {
		return ProfileId;
	}

	public void setProfileId(Long profileId) {
		ProfileId = profileId;
	}

	public ProfileDto(@Valid @NotNull @NotBlank(message = "Please Pick your username") String usernames,
			@Valid @Size(min = 10) @NotBlank @NotBlank(message = "Please enter your phone number ") String phnNumber,
			@Valid @NotNull @NotBlank(message = "Please enter your gmail ID ") @Email String gmail,
			@Valid @NotNull @NotBlank(message = "The Password cannont be blank") String password, String dob,
			Long profileId) {
		super();
		this.usernames = usernames;
		this.phnNumber = phnNumber;
		this.gmail = gmail;
		this.password = password;
		this.dob = dob;
		ProfileId = profileId;
	}

	@Override
	public String toString() {
		return "ProfileDto [usernames=" + usernames + ", phnNumber=" + phnNumber + ", gmail=" + gmail + ", password="
				+ password + ", dob=" + dob + ", ProfileId=" + ProfileId + "]";
	}

	public ProfileDto() {
		super();
		
	}
	
	
	
}
