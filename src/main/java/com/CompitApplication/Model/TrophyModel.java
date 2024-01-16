package com.CompitApplication.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="trophy_model_table")
public class TrophyModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tophyId;
	
	private String trpohyName;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties("profileTrophyModel")
	private ProfileModel trophyProfileId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties("videoTrophyModel")
	private VideoModel trophyVideoId;

	public TrophyModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrophyModel(long tophyId, String trpohyName, ProfileModel trophyProfileId, VideoModel trophyVideoId) {
		super();
		this.tophyId = tophyId;
		this.trpohyName = trpohyName;
		this.trophyProfileId = trophyProfileId;
		this.trophyVideoId = trophyVideoId;
	}

	public long getTophyId() {
		return tophyId;
	}

	public void setTophyId(long tophyId) {
		this.tophyId = tophyId;
	}

	public String getTrpohyName() {
		return trpohyName;
	}

	public void setTrpohyName(String trpohyName) {
		this.trpohyName = trpohyName;
	}

	public ProfileModel getTrophyProfileId() {
		return trophyProfileId;
	}

	public void setTrophyProfileId(ProfileModel trophyProfileId) {
		this.trophyProfileId = trophyProfileId;
	}

	public VideoModel getTrophyVideoId() {
		return trophyVideoId;
	}

	public void setTrophyVideoId(VideoModel trophyVideoId) {
		this.trophyVideoId = trophyVideoId;
	}
	
	
}
