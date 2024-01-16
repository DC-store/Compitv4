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
import com.CompitApplication.BgMusicModel.KarokeModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Entity
@Table(name = "singing_Video_model_table")
public class SingingVideoModel implements Serializable {

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
	@JsonIgnoreProperties("singVideoList")
	private ProfileModel singprofilemodel;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "singvideoId")
	@JsonIgnoreProperties("singvideoId")
	private LikesModel singvideolikeid;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "singvideomodel", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("singvideomodel")
	private List<CommentsModel> singcommentList = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="Singkaroke_ID", referencedColumnName ="karokeID")
	@JsonIgnoreProperties("singingVideoList")
	private KarokeModel singkarokeModel;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="SingDef_ID", referencedColumnName ="defMsusicId")
	@JsonIgnoreProperties("defSingingVideoList")
	private DefaultMusicModel karokeDefaultMusicModel;

	public SingingVideoModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SingingVideoModel(int videoId, String videoName, String videoDescription, String videoUrl,
			ProfileModel singprofilemodel, LikesModel singvideolikeid, List<CommentsModel> singcommentList,
			KarokeModel singkarokeModel, DefaultMusicModel karokeDefaultMusicModel) {
		super();
		this.videoId = videoId;
		this.videoName = videoName;
		VideoDescription = videoDescription;
		this.videoUrl = videoUrl;
		this.singprofilemodel = singprofilemodel;
		this.singvideolikeid = singvideolikeid;
		this.singcommentList = singcommentList;
		this.singkarokeModel = singkarokeModel;
		this.karokeDefaultMusicModel = karokeDefaultMusicModel;
	}

	@Override
	public String toString() {
		return "SingingVideoModel [videoId=" + videoId + ", videoName=" + videoName + ", VideoDescription="
				+ VideoDescription + ", videoUrl=" + videoUrl + ", singprofilemodel=" + singprofilemodel
				+ ", singvideolikeid=" + singvideolikeid + ", singcommentList=" + singcommentList + ", singkarokeModel="
				+ singkarokeModel + ", karokeDefaultMusicModel=" + karokeDefaultMusicModel + "]";
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

	public ProfileModel getSingprofilemodel() {
		return singprofilemodel;
	}

	public void setSingprofilemodel(ProfileModel singprofilemodel) {
		this.singprofilemodel = singprofilemodel;
	}

	public LikesModel getSingvideolikeid() {
		return singvideolikeid;
	}

	public void setSingvideolikeid(LikesModel singvideolikeid) {
		this.singvideolikeid = singvideolikeid;
	}

	public List<CommentsModel> getSingcommentList() {
		return singcommentList;
	}

	public void setSingcommentList(List<CommentsModel> singcommentList) {
		this.singcommentList = singcommentList;
	}

	public KarokeModel getSingkarokeModel() {
		return singkarokeModel;
	}

	public void setSingkarokeModel(KarokeModel singkarokeModel) {
		this.singkarokeModel = singkarokeModel;
	}

	public DefaultMusicModel getKarokeDefaultMusicModel() {
		return karokeDefaultMusicModel;
	}

	public void setKarokeDefaultMusicModel(DefaultMusicModel karokeDefaultMusicModel) {
		this.karokeDefaultMusicModel = karokeDefaultMusicModel;
	}
	
}