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
@Table(name = "Comedy_Video_model_table")
public class ComedyVideoModel  implements Serializable {

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
	@JsonIgnoreProperties("comedyVideoList")
	private ProfileModel cprofilemodel;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "cvideoId")
	@JsonIgnoreProperties("cvideoId")
	private LikesModel cvideolikeid;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cvideomodel", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("cvideomodel")
	private List<CommentsModel> cdcommentList = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="bgmusic_id", referencedColumnName ="bgMusicId")
	@JsonIgnoreProperties("comedyVideoModelsList")
	private BackGroundMusicModel comedyBackGroundMusicModel;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="comedyDef_ID", referencedColumnName ="defMsusicId")
	@JsonIgnoreProperties("")
	private DefaultMusicModel comedyDefaultMusicModel;

	public ComedyVideoModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComedyVideoModel(int videoId, String videoName, String videoDescription, String videoUrl,
			ProfileModel cprofilemodel, LikesModel cvideolikeid, List<CommentsModel> cdcommentList,
			BackGroundMusicModel comedyBackGroundMusicModel, DefaultMusicModel comedyDefaultMusicModel) {
		super();
		this.videoId = videoId;
		this.videoName = videoName;
		VideoDescription = videoDescription;
		this.videoUrl = videoUrl;
		this.cprofilemodel = cprofilemodel;
		this.cvideolikeid = cvideolikeid;
		this.cdcommentList = cdcommentList;
		this.comedyBackGroundMusicModel = comedyBackGroundMusicModel;
		this.comedyDefaultMusicModel = comedyDefaultMusicModel;
	}

	@Override
	public String toString() {
		return "ComedyVideoModel [videoId=" + videoId + ", videoName=" + videoName + ", VideoDescription="
				+ VideoDescription + ", videoUrl=" + videoUrl + ", cprofilemodel=" + cprofilemodel + ", cvideolikeid="
				+ cvideolikeid + ", cdcommentList=" + cdcommentList + ", comedyBackGroundMusicModel="
				+ comedyBackGroundMusicModel + ", comedyDefaultMusicModel=" + comedyDefaultMusicModel + "]";
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

	public ProfileModel getCprofilemodel() {
		return cprofilemodel;
	}

	public void setCprofilemodel(ProfileModel cprofilemodel) {
		this.cprofilemodel = cprofilemodel;
	}

	public LikesModel getCvideolikeid() {
		return cvideolikeid;
	}

	public void setCvideolikeid(LikesModel cvideolikeid) {
		this.cvideolikeid = cvideolikeid;
	}

	public List<CommentsModel> getCdcommentList() {
		return cdcommentList;
	}

	public void setCdcommentList(List<CommentsModel> cdcommentList) {
		this.cdcommentList = cdcommentList;
	}

	public BackGroundMusicModel getComedyBackGroundMusicModel() {
		return comedyBackGroundMusicModel;
	}

	public void setComedyBackGroundMusicModel(BackGroundMusicModel comedyBackGroundMusicModel) {
		this.comedyBackGroundMusicModel = comedyBackGroundMusicModel;
	}

	public DefaultMusicModel getComedyDefaultMusicModel() {
		return comedyDefaultMusicModel;
	}

	public void setComedyDefaultMusicModel(DefaultMusicModel comedyDefaultMusicModel) {
		this.comedyDefaultMusicModel = comedyDefaultMusicModel;
	}

	
}