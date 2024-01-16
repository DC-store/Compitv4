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

import com.CompitApplication.BgMusicModel.BgDailogueModel;
import com.CompitApplication.BgMusicModel.DefaultMusicModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "Reels_Video_model_table")
public class ReelsVideoModel  implements Serializable {

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
	@JsonIgnoreProperties("reelsVideoList")
	private ProfileModel rprofilemodel;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "rvideoId")
	@JsonIgnoreProperties("rvideoId")
	private LikesModel rvideolikeid;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rvideomodel", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("rvideomodel")
	private List<CommentsModel> rcommentList = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Bgdailogue_id", referencedColumnName = "bgDailogueId")
	@JsonIgnoreProperties("bgdReelsVideoModel")
	private BgDailogueModel bgDailogueModel; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DefBgdailogue_id", referencedColumnName = "defMsusicId")
	@JsonIgnoreProperties("defReelsVideoList")
	private DefaultMusicModel reelsDefaultMusicModel;

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

	public ProfileModel getRprofilemodel() {
		return rprofilemodel;
	}

	public void setRprofilemodel(ProfileModel rprofilemodel) {
		this.rprofilemodel = rprofilemodel;
	}

	public LikesModel getRvideolikeid() {
		return rvideolikeid;
	}

	public void setRvideolikeid(LikesModel rvideolikeid) {
		this.rvideolikeid = rvideolikeid;
	}

	public List<CommentsModel> getRcommentList() {
		return rcommentList;
	}

	public void setRcommentList(List<CommentsModel> rcommentList) {
		this.rcommentList = rcommentList;
	}

	public BgDailogueModel getBgDailogueModel() {
		return bgDailogueModel;
	}

	public void setBgDailogueModel(BgDailogueModel bgDailogueModel) {
		this.bgDailogueModel = bgDailogueModel;
	}

	public DefaultMusicModel getReelsDefaultMusicModel() {
		return reelsDefaultMusicModel;
	}

	public void setReelsDefaultMusicModel(DefaultMusicModel reelsDefaultMusicModel) {
		this.reelsDefaultMusicModel = reelsDefaultMusicModel;
	}

	@Override
	public String toString() {
		return "ReelsVideoModel [videoId=" + videoId + ", videoName=" + videoName + ", VideoDescription="
				+ VideoDescription + ", videoUrl=" + videoUrl + ", rprofilemodel=" + rprofilemodel + ", rvideolikeid="
				+ rvideolikeid + ", rcommentList=" + rcommentList + ", bgDailogueModel=" + bgDailogueModel
				+ ", reelsDefaultMusicModel=" + reelsDefaultMusicModel + "]";
	}

	public ReelsVideoModel(int videoId, String videoName, String videoDescription, String videoUrl,
			ProfileModel rprofilemodel, LikesModel rvideolikeid, List<CommentsModel> rcommentList,
			BgDailogueModel bgDailogueModel, DefaultMusicModel reelsDefaultMusicModel) {
		super();
		this.videoId = videoId;
		this.videoName = videoName;
		VideoDescription = videoDescription;
		this.videoUrl = videoUrl;
		this.rprofilemodel = rprofilemodel;
		this.rvideolikeid = rvideolikeid;
		this.rcommentList = rcommentList;
		this.bgDailogueModel = bgDailogueModel;
		this.reelsDefaultMusicModel = reelsDefaultMusicModel;
	}

	public ReelsVideoModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
