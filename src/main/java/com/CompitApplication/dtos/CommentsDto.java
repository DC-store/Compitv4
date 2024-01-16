package com.CompitApplication.dtos;

public class CommentsDto {
	
	private Long commentsId;

	private Long comedyVideoId;
	
	private Long musicVideoId;
	
	private Long creativeVideoId;
	
	private Long singingVideoId;
	
	private Long inspireVideoId;
	
	private Long danceVideoId;
	
	private Long reelsVideoId;
	
	private Long replyId;
	
	private String comments;

	public Long getCommentsId() {
		return commentsId;
	}

	public void setCommentsId(Long commentsId) {
		this.commentsId = commentsId;
	}

	public Long getComedyVideoId() {
		return comedyVideoId;
	}

	public void setComedyVideoId(Long comedyVideoId) {
		this.comedyVideoId = comedyVideoId;
	}

	public Long getMusicVideoId() {
		return musicVideoId;
	}

	public void setMusicVideoId(Long musicVideoId) {
		this.musicVideoId = musicVideoId;
	}

	public Long getCreativeVideoId() {
		return creativeVideoId;
	}

	public void setCreativeVideoId(Long i) {
		this.creativeVideoId = i;
	}

	public Long getSingingVideoId() {
		return singingVideoId;
	}

	public void setSingingVideoId(Long singingVideoId) {
		this.singingVideoId = singingVideoId;
	}

	public Long getInspireVideoId() {
		return inspireVideoId;
	}

	public void setInspireVideoId(Long inspireVideoId) {
		this.inspireVideoId = inspireVideoId;
	}

	public Long getDanceVideoId() {
		return danceVideoId;
	}

	public void setDanceVideoId(Long danceVideoId) {
		this.danceVideoId = danceVideoId;
	}

	public Long getReelsVideoId() {
		return reelsVideoId;
	}

	public void setReelsVideoId(Long reelsVideoId) {
		this.reelsVideoId = reelsVideoId;
	}

	public Long getReplyId() {
		return replyId;
	}

	public void setReplyId(Long replyId) {
		this.replyId = replyId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "CommentsDto [commentsId=" + commentsId + ", comedyVideoId=" + comedyVideoId + ", musicVideoId="
				+ musicVideoId + ", creativeVideoId=" + creativeVideoId + ", singingVideoId=" + singingVideoId
				+ ", inspireVideoId=" + inspireVideoId + ", danceVideoId=" + danceVideoId + ", reelsVideoId="
				+ reelsVideoId + ", replyId=" + replyId + ", comments=" + comments + "]";
	}

	public CommentsDto(Long commentsId, Long comedyVideoId, Long musicVideoId, Long creativeVideoId,
			Long singingVideoId, Long inspireVideoId, Long danceVideoId, Long reelsVideoId, Long replyId,
			String comments) {
		super();
		this.commentsId = commentsId;
		this.comedyVideoId = comedyVideoId;
		this.musicVideoId = musicVideoId;
		this.creativeVideoId = creativeVideoId;
		this.singingVideoId = singingVideoId;
		this.inspireVideoId = inspireVideoId;
		this.danceVideoId = danceVideoId;
		this.reelsVideoId = reelsVideoId;
		this.replyId = replyId;
		this.comments = comments;
	}

	public CommentsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
