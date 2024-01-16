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
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "creative_Video_model_table")
public class CreativeVideoModel  implements Serializable {

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
	@JsonIgnoreProperties("creativeVideoList")
	private ProfileModel crprofilemodel;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "crvideoId")
	@JsonIgnoreProperties("crvideoId")
	private LikesModel crvideolikeid;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "crvideomodel", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("crvideomodel")
	private List<CommentsModel> crcommentList = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="bgmusic_id", referencedColumnName ="bgMusicId")
	@JsonIgnoreProperties("creativeVideoList")
	private BackGroundMusicModel backGroundMusicModel;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="dfmusic_id", referencedColumnName ="defMsusicId")
	@JsonIgnoreProperties("creativeVideoModelsList")
	private DefaultMusicModel creativeDefaultMusicModel;


	public CreativeVideoModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CreativeVideoModel(int videoId, String videoName, String videoDescription, String videoUrl,
			ProfileModel crprofilemodel, LikesModel crvideolikeid, List<CommentsModel> crcommentList,
			BackGroundMusicModel backGroundMusicModel, DefaultMusicModel creativeDefaultMusicModel) {
		super();
		this.videoId = videoId;
		this.videoName = videoName;
		VideoDescription = videoDescription;
		this.videoUrl = videoUrl;
		this.crprofilemodel = crprofilemodel;
		this.crvideolikeid = crvideolikeid;
		this.crcommentList = crcommentList;
		this.backGroundMusicModel = backGroundMusicModel;
		this.creativeDefaultMusicModel = creativeDefaultMusicModel;
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


	public ProfileModel getCrprofilemodel() {
		return crprofilemodel;
	}


	public void setCrprofilemodel(ProfileModel crprofilemodel) {
		this.crprofilemodel = crprofilemodel;
	}


	public LikesModel getCrvideolikeid() {
		return crvideolikeid;
	}


	public void setCrvideolikeid(LikesModel crvideolikeid) {
		this.crvideolikeid = crvideolikeid;
	}


	public List<CommentsModel> getCrcommentList() {
		return crcommentList;
	}


	public void setCrcommentList(List<CommentsModel> crcommentList) {
		this.crcommentList = crcommentList;
	}


	public BackGroundMusicModel getBackGroundMusicModel() {
		return backGroundMusicModel;
	}


	public void setBackGroundMusicModel(BackGroundMusicModel backGroundMusicModel) {
		this.backGroundMusicModel = backGroundMusicModel;
	}


	public DefaultMusicModel getCreativeDefaultMusicModel() {
		return creativeDefaultMusicModel;
	}


	public void setCreativeDefaultMusicModel(DefaultMusicModel creativeDefaultMusicModel) {
		this.creativeDefaultMusicModel = creativeDefaultMusicModel;
	}


	
}