package com.CompitApplication.Model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name =" comments_model")
public class CommentsModel implements Serializable  {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentid;
	
	private String comment;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "commentmodel", fetch = FetchType.LAZY)
	@JsonIgnoreProperties("commentmodel")
	private List<ReplyModel> replies = new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "video_id", referencedColumnName = "videoId")
    @JsonIgnoreProperties("commentList")
    private VideoModel videomodel;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cvideo_id", referencedColumnName = "videoId")
    @JsonIgnoreProperties("cdcommentList")
    private ComedyVideoModel cvideomodel;
	
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "rvideo_id", referencedColumnName = "videoId")
    @JsonIgnoreProperties("rcommentList")
    private ReelsVideoModel rvideomodel;
	

	
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "crvideo_id", referencedColumnName = "videoId")
    @JsonIgnoreProperties("crcommentList")
    private CreativeVideoModel crvideomodel;


	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "insvideo_id", referencedColumnName = "videoId")
    @JsonIgnoreProperties("inscommentList")
    private InspireVideoModel insvideomodel;


	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "muvideo_id", referencedColumnName = "videoId")
    @JsonIgnoreProperties("mucommentList")
    private MusicVideoModel muvideomodel;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "singvideo_id", referencedColumnName = "videoId")
    @JsonIgnoreProperties("singcommentList")
    private SingingVideoModel singvideomodel;

	public CommentsModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentsModel(int commentid, String comment, List<ReplyModel> replies, VideoModel videomodel,
			ComedyVideoModel cvideomodel, ReelsVideoModel rvideomodel, CreativeVideoModel crvideomodel,
			InspireVideoModel insvideomodel, MusicVideoModel muvideomodel, SingingVideoModel singvideomodel) {
		super();
		this.commentid = commentid;
		this.comment = comment;
		this.replies = replies;
		this.videomodel = videomodel;
		this.cvideomodel = cvideomodel;
		this.rvideomodel = rvideomodel;
		this.crvideomodel = crvideomodel;
		this.insvideomodel = insvideomodel;
		this.muvideomodel = muvideomodel;
		this.singvideomodel = singvideomodel;
	}

	@Override
	public String toString() {
		return "CommentsModel [commentid=" + commentid + ", comment=" + comment + ", replies=" + replies
				+ ", videomodel=" + videomodel + ", cvideomodel=" + cvideomodel + ", rvideomodel=" + rvideomodel
				+ ", crvideomodel=" + crvideomodel + ", insvideomodel=" + insvideomodel + ", muvideomodel="
				+ muvideomodel + ", singvideomodel=" + singvideomodel + "]";
	}

	public int getCommentid() {
		return commentid;
	}

	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<ReplyModel> getReplies() {
		return replies;
	}

	public void setReplies(List<ReplyModel> replies) {
		this.replies = replies;
	}

	public VideoModel getVideomodel() {
		return videomodel;
	}

	public void setVideomodel(VideoModel videomodel) {
		this.videomodel = videomodel;
	}

	public ComedyVideoModel getCvideomodel() {
		return cvideomodel;
	}

	public void setCvideomodel(ComedyVideoModel cvideomodel) {
		this.cvideomodel = cvideomodel;
	}

	public ReelsVideoModel getRvideomodel() {
		return rvideomodel;
	}

	public void setRvideomodel(ReelsVideoModel rvideomodel) {
		this.rvideomodel = rvideomodel;
	}

	public CreativeVideoModel getCrvideomodel() {
		return crvideomodel;
	}

	public void setCrvideomodel(CreativeVideoModel crvideomodel) {
		this.crvideomodel = crvideomodel;
	}

	public InspireVideoModel getInsvideomodel() {
		return insvideomodel;
	}

	public void setInsvideomodel(InspireVideoModel insvideomodel) {
		this.insvideomodel = insvideomodel;
	}

	public MusicVideoModel getMuvideomodel() {
		return muvideomodel;
	}

	public void setMuvideomodel(MusicVideoModel muvideomodel) {
		this.muvideomodel = muvideomodel;
	}

	public SingingVideoModel getSingvideomodel() {
		return singvideomodel;
	}

	public void setSingvideomodel(SingingVideoModel singvideomodel) {
		this.singvideomodel = singvideomodel;
	}
	
	
	
}