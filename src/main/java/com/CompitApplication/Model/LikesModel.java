package com.CompitApplication.Model;

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
@Table(name="like_model_table")
public class LikesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int likesId;

	private int videoPostId;

	private int userId;

	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties("likeid")
	private ProfileModel lprofileId;

	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties("videolikeid")
	private VideoModel lvideoId;

	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties("cvideolikeid")
	private ComedyVideoModel cvideoId;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties("rvideolikeid")
	private ReelsVideoModel rvideoId;


	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties("crvideolikeid")
	private CreativeVideoModel crvideoId;

	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties("insvideolikeid")
	private InspireVideoModel insvideoId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties("muvideolikeid")
	private	MusicVideoModel muvideoId;

	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties("singvideolikeid")
	private	SingingVideoModel singvideoId;

	public LikesModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LikesModel(int likesId, int videoPostId, int userId, ProfileModel lprofileId, VideoModel lvideoId,
			ComedyVideoModel cvideoId, ReelsVideoModel rvideoId, CreativeVideoModel crvideoId,
			InspireVideoModel insvideoId, MusicVideoModel muvideoId, SingingVideoModel singvideoId) {
		super();
		this.likesId = likesId;
		this.videoPostId = videoPostId;
		this.userId = userId;
		this.lprofileId = lprofileId;
		this.lvideoId = lvideoId;
		this.cvideoId = cvideoId;
		this.rvideoId = rvideoId;
		this.crvideoId = crvideoId;
		this.insvideoId = insvideoId;
		this.muvideoId = muvideoId;
		this.singvideoId = singvideoId;
	}

	@Override
	public String toString() {
		return "LikesModel [likesId=" + likesId + ", videoPostId=" + videoPostId + ", userId=" + userId
				+ ", lprofileId=" + lprofileId + ", lvideoId=" + lvideoId + ", cvideoId=" + cvideoId + ", rvideoId="
				+ rvideoId + ", crvideoId=" + crvideoId + ", insvideoId=" + insvideoId + ", muvideoId=" + muvideoId
				+ ", singvideoId=" + singvideoId + "]";
	}

	public int getLikesId() {
		return likesId;
	}

	public void setLikesId(int likesId) {
		this.likesId = likesId;
	}

	public int getVideoPostId() {
		return videoPostId;
	}

	public void setVideoPostId(int videoPostId) {
		this.videoPostId = videoPostId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ProfileModel getLprofileId() {
		return lprofileId;
	}

	public void setLprofileId(ProfileModel lprofileId) {
		this.lprofileId = lprofileId;
	}

	public VideoModel getLvideoId() {
		return lvideoId;
	}

	public void setLvideoId(VideoModel lvideoId) {
		this.lvideoId = lvideoId;
	}

	public ComedyVideoModel getCvideoId() {
		return cvideoId;
	}

	public void setCvideoId(ComedyVideoModel cvideoId) {
		this.cvideoId = cvideoId;
	}

	public ReelsVideoModel getRvideoId() {
		return rvideoId;
	}

	public void setRvideoId(ReelsVideoModel rvideoId) {
		this.rvideoId = rvideoId;
	}

	public CreativeVideoModel getCrvideoId() {
		return crvideoId;
	}

	public void setCrvideoId(CreativeVideoModel crvideoId) {
		this.crvideoId = crvideoId;
	}

	public InspireVideoModel getInsvideoId() {
		return insvideoId;
	}

	public void setInsvideoId(InspireVideoModel insvideoId) {
		this.insvideoId = insvideoId;
	}

	public MusicVideoModel getMuvideoId() {
		return muvideoId;
	}

	public void setMuvideoId(MusicVideoModel muvideoId) {
		this.muvideoId = muvideoId;
	}

	public SingingVideoModel getSingvideoId() {
		return singvideoId;
	}

	public void setSingvideoId(SingingVideoModel singvideoId) {
		this.singvideoId = singvideoId;
	}
	
}
