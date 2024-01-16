package com.CompitApplication.Model;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.twilio.rest.api.v2010.account.availablephonenumbercountry.Local;

@Entity
@Table(name="challenge_model_table")
public class ChallengeModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long challengeId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties("fromchallengeModel")
	private ProfileModel challengeFromId;
	
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties("tochallengeModel")
	private ProfileModel challengeToID;
	
	
	private int challengeAcceptanceflag;
	//date fromat error will come have to resolve it 
	
	private LocalDate challengeAcceptedDate;
	
	private LocalTime challengeAcceptedtime;
	
	private LocalDate challengeEndDate;
	
	private LocalTime challengeEndTime;
	
	

	public ChallengeModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChallengeModel(long challengeId, ProfileModel challengeFromId, ProfileModel challengeToID,
			int challengeAcceptanceflag, LocalDate challengeAcceptedDate, LocalTime challengeAcceptedtime,
			LocalDate challengeEndDate, LocalTime challengeEndTime) {
		super();
		this.challengeId = challengeId;
		this.challengeFromId = challengeFromId;
		this.challengeToID = challengeToID;
		this.challengeAcceptanceflag = challengeAcceptanceflag;
		this.challengeAcceptedDate = challengeAcceptedDate;
		this.challengeAcceptedtime = challengeAcceptedtime;
		this.challengeEndDate = challengeEndDate;
		this.challengeEndTime = challengeEndTime;
	}

	@Override
	public String toString() {
		return "ChallengeModel [challengeId=" + challengeId + ", challengeFromId=" + challengeFromId
				+ ", challengeToID=" + challengeToID + ", challengeAcceptanceflag=" + challengeAcceptanceflag
				+ ", challengeAcceptedDate=" + challengeAcceptedDate + ", challengeAcceptedtime="
				+ challengeAcceptedtime + ", challengeEndDate=" + challengeEndDate + ", challengeEndTime="
				+ challengeEndTime + "]";
	}

	public long getChallengeId() {
		return challengeId;
	}

	public void setChallengeId(long challengeId) {
		this.challengeId = challengeId;
	}

	public ProfileModel getChallengeFromId() {
		return challengeFromId;
	}

	public void setChallengeFromId(ProfileModel challengeFromId) {
		this.challengeFromId = challengeFromId;
	}

	public ProfileModel getChallengeToID() {
		return challengeToID;
	}

	public void setChallengeToID(ProfileModel challengeToID) {
		this.challengeToID = challengeToID;
	}

	public int getChallengeAcceptanceflag() {
		return challengeAcceptanceflag;
	}

	public void setChallengeAcceptanceflag(int challengeAcceptanceflag) {
		this.challengeAcceptanceflag = challengeAcceptanceflag;
	}

	public LocalDate getChallengeAcceptedDate() {
		return challengeAcceptedDate;
	}

	public void setChallengeAcceptedDate(LocalDate challengeAcceptedDate) {
		this.challengeAcceptedDate = challengeAcceptedDate;
	}

	public LocalTime getChallengeAcceptedtime() {
		return challengeAcceptedtime;
	}

	public void setChallengeAcceptedtime(LocalTime challengeAcceptedtime) {
		this.challengeAcceptedtime = challengeAcceptedtime;
	}

	public LocalDate getChallengeEndDate() {
		return challengeEndDate;
	}

	public void setChallengeEndDate(LocalDate challengeEndDate) {
		this.challengeEndDate = challengeEndDate;
	}

	public LocalTime getChallengeEndTime() {
		return challengeEndTime;
	}

	public void setChallengeEndTime(LocalTime challengeEndTime) {
		this.challengeEndTime = challengeEndTime;
	}

	
	

	

	

}
