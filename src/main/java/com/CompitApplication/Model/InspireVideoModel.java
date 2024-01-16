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

import com.CompitApplication.BgMusicModel.BackGroundMusicModel;
import com.CompitApplication.BgMusicModel.DefaultMusicModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Entity
@Table(name = "inspire_Video_model_table")
public class InspireVideoModel implements Serializable {

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
	@JsonIgnoreProperties("inspireVideoList")
	private ProfileModel insprofilemodel;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "insvideoId")
	@JsonIgnoreProperties("insvideoId")
	private LikesModel insvideolikeid;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insvideomodel", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("insvideomodel")
	private List<CommentsModel> inscommentList = new ArrayList<>();

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="bgmusic_id", referencedColumnName ="bgMusicId")
	@JsonIgnoreProperties("inspireVideoList")
	private BackGroundMusicModel backGroundMusicModel;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="defBgMusic_id" , referencedColumnName = "defMsusicId")
	@JsonIgnoreProperties("defInspireVideoList")
	private DefaultMusicModel defaultMusicModel;


	public InspireVideoModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public InspireVideoModel(int videoId, String videoName, String videoDescription, String videoUrl,
			ProfileModel insprofilemodel, LikesModel insvideolikeid, List<CommentsModel> inscommentList,
			BackGroundMusicModel backGroundMusicModel, DefaultMusicModel defaultMusicModel) {
		super();
		this.videoId = videoId;
		this.videoName = videoName;
		VideoDescription = videoDescription;
		this.videoUrl = videoUrl;
		this.insprofilemodel = insprofilemodel;
		this.insvideolikeid = insvideolikeid;
		this.inscommentList = inscommentList;
		this.backGroundMusicModel = backGroundMusicModel;
		this.defaultMusicModel = defaultMusicModel;
	}


	@Override
	public String toString() {
		return "InspireVideoModel [videoId=" + videoId + ", videoName=" + videoName + ", VideoDescription="
				+ VideoDescription + ", videoUrl=" + videoUrl + ", insprofilemodel=" + insprofilemodel
				+ ", insvideolikeid=" + insvideolikeid + ", inscommentList=" + inscommentList
				+ ", backGroundMusicModel=" + backGroundMusicModel + ", defaultMusicModel=" + defaultMusicModel + "]";
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


	public ProfileModel getInsprofilemodel() {
		return insprofilemodel;
	}


	public void setInsprofilemodel(ProfileModel insprofilemodel) {
		this.insprofilemodel = insprofilemodel;
	}


	public LikesModel getInsvideolikeid() {
		return insvideolikeid;
	}


	public void setInsvideolikeid(LikesModel insvideolikeid) {
		this.insvideolikeid = insvideolikeid;
	}


	public List<CommentsModel> getInscommentList() {
		return inscommentList;
	}


	public void setInscommentList(List<CommentsModel> inscommentList) {
		this.inscommentList = inscommentList;
	}


	public BackGroundMusicModel getBackGroundMusicModel() {
		return backGroundMusicModel;
	}


	public void setBackGroundMusicModel(BackGroundMusicModel backGroundMusicModel) {
		this.backGroundMusicModel = backGroundMusicModel;
	}


	public DefaultMusicModel getDefaultMusicModel() {
		return defaultMusicModel;
	}


	public void setDefaultMusicModel(DefaultMusicModel defaultMusicModel) {
		this.defaultMusicModel = defaultMusicModel;
	}

	
}
