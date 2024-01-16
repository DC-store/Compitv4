package com.CompitApplication.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.CompitApplication.BgMusicModel.DefaultMusicModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Entity
@Table(name = "music_Video_model_table")
public class MusicVideoModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2228784815938588107L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int videoId;
	@Column(name = "video_name")

	private String videoName;

	private String VideoDescription;

	private String videoUrl;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "profile_id", referencedColumnName = "profileId")
	@JsonIgnoreProperties("musicVideoList")
	private ProfileModel muprofilemodel;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "muvideoId")
	@JsonIgnoreProperties("muvideoId")
	private LikesModel muvideolikeid;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "muvideomodel", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("muvideomodel")
	private List<CommentsModel> mucommentList = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="defBgMusic_id" , referencedColumnName = "defMsusicId")
	@JsonIgnoreProperties("defMusicVideoList")
	private DefaultMusicModel musicDefaultMusicModel;

	public MusicVideoModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MusicVideoModel(int videoId, String videoName, String videoDescription, String videoUrl,
			ProfileModel muprofilemodel, LikesModel muvideolikeid, List<CommentsModel> mucommentList,
			DefaultMusicModel musicDefaultMusicModel) {
		super();
		this.videoId = videoId;
		this.videoName = videoName;
		VideoDescription = videoDescription;
		this.videoUrl = videoUrl;
		this.muprofilemodel = muprofilemodel;
		this.muvideolikeid = muvideolikeid;
		this.mucommentList = mucommentList;
		this.musicDefaultMusicModel = musicDefaultMusicModel;
	}

	@Override
	public String toString() {
		return "MusicVideoModel [videoId=" + videoId + ", videoName=" + videoName + ", VideoDescription="
				+ VideoDescription + ", videoUrl=" + videoUrl + ", muprofilemodel=" + muprofilemodel
				+ ", muvideolikeid=" + muvideolikeid + ", mucommentList=" + mucommentList + ", musicDefaultMusicModel="
				+ musicDefaultMusicModel + "]";
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getVideoDescription() {
		return VideoDescription;
	}

	public void setVideoDescription(String videoDescription) {
		VideoDescription = videoDescription;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public ProfileModel getMuprofilemodel() {
		return muprofilemodel;
	}

	public void setMuprofilemodel(ProfileModel muprofilemodel) {
		this.muprofilemodel = muprofilemodel;
	}

	public LikesModel getMuvideolikeid() {
		return muvideolikeid;
	}

	public void setMuvideolikeid(LikesModel muvideolikeid) {
		this.muvideolikeid = muvideolikeid;
	}

	public List<CommentsModel> getMucommentList() {
		return mucommentList;
	}

	public void setMucommentList(List<CommentsModel> mucommentList) {
		this.mucommentList = mucommentList;
	}

	public DefaultMusicModel getMusicDefaultMusicModel() {
		return musicDefaultMusicModel;
	}

	public void setMusicDefaultMusicModel(DefaultMusicModel musicDefaultMusicModel) {
		this.musicDefaultMusicModel = musicDefaultMusicModel;
	}

	
}
