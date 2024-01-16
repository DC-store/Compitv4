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
import com.CompitApplication.BgMusicModel.BgSongsModel;
import com.CompitApplication.BgMusicModel.DefaultMusicModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Entity
@Table(name = "Video_model_table")
public class VideoModel implements Serializable {

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
	@JsonIgnoreProperties("videoList")
	private ProfileModel profilemodel;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "lvideoId")
	@JsonIgnoreProperties("lvideoId")
	private LikesModel videolikeid;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "rVideoId")
	@JsonIgnoreProperties("rVideoId")
	private ReportModel videoReportid;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "videomodel", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("videomodel")
	private List<CommentsModel> commentList = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bgmusic_id", referencedColumnName = "bgSongId")
	@JsonIgnoreProperties("danceVideoList")
	private BgSongsModel bgSongsVideoModel;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dfmusic_id", referencedColumnName = "defMsusicId")
	@JsonIgnoreProperties("danceVideoModelsList")
	private DefaultMusicModel danceVideoDefaultMusicModel;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "trophyVideoId")
	@JsonIgnoreProperties("trophyVideoId")
	private TrophyModel videoTrophyModel;

	public VideoModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VideoModel(int videoId, String videoName, String videoDescription, String videoUrl,
			ProfileModel profilemodel, LikesModel videolikeid, ReportModel videoReportid,
			List<CommentsModel> commentList, BgSongsModel bgSongsVideoModel,
			DefaultMusicModel danceVideoDefaultMusicModel, TrophyModel videoTrophyModel) {
		super();
		this.videoId = videoId;
		this.videoName = videoName;
		VideoDescription = videoDescription;
		this.videoUrl = videoUrl;
		this.profilemodel = profilemodel;
		this.videolikeid = videolikeid;
		this.videoReportid = videoReportid;
		this.commentList = commentList;
		this.bgSongsVideoModel = bgSongsVideoModel;
		this.danceVideoDefaultMusicModel = danceVideoDefaultMusicModel;
		this.videoTrophyModel = videoTrophyModel;
	}

	@Override
	public String toString() {
		return "VideoModel [videoId=" + videoId + ", videoName=" + videoName + ", VideoDescription=" + VideoDescription
				+ ", videoUrl=" + videoUrl + ", profilemodel=" + profilemodel + ", videolikeid=" + videolikeid
				+ ", videoReportid=" + videoReportid + ", commentList=" + commentList + ", bgSongsVideoModel="
				+ bgSongsVideoModel + ", danceVideoDefaultMusicModel=" + danceVideoDefaultMusicModel
				+ ", videoTrophyModel=" + videoTrophyModel + "]";
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

	public ProfileModel getProfilemodel() {
		return profilemodel;
	}

	public void setProfilemodel(ProfileModel profilemodel) {
		this.profilemodel = profilemodel;
	}

	public LikesModel getVideolikeid() {
		return videolikeid;
	}

	public void setVideolikeid(LikesModel videolikeid) {
		this.videolikeid = videolikeid;
	}

	public ReportModel getVideoReportid() {
		return videoReportid;
	}

	public void setVideoReportid(ReportModel videoReportid) {
		this.videoReportid = videoReportid;
	}

	public List<CommentsModel> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<CommentsModel> commentList) {
		this.commentList = commentList;
	}

	public BgSongsModel getBgSongsVideoModel() {
		return bgSongsVideoModel;
	}

	public void setBgSongsVideoModel(BgSongsModel bgSongsVideoModel) {
		this.bgSongsVideoModel = bgSongsVideoModel;
	}

	public DefaultMusicModel getDanceVideoDefaultMusicModel() {
		return danceVideoDefaultMusicModel;
	}

	public void setDanceVideoDefaultMusicModel(DefaultMusicModel danceVideoDefaultMusicModel) {
		this.danceVideoDefaultMusicModel = danceVideoDefaultMusicModel;
	}

	public TrophyModel getVideoTrophyModel() {
		return videoTrophyModel;
	}

	public void setVideoTrophyModel(TrophyModel videoTrophyModel) {
		this.videoTrophyModel = videoTrophyModel;
	}

}