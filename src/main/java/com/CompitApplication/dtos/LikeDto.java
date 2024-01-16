package com.CompitApplication.dtos;

public class LikeDto {

	private Long likeId;

	private Long fromProfileId;

	private Long toProfileId;

	private Long danceVideoId;

	private Long singingVideoId;

	private Long musicVideoId;

	private Long creativeVideoId;

	private Long reelsVideoId;

	private Long inspireVideoId;
	
	private Long comedyVideoId;

	public Long getLikeId() {
		return likeId;
	}

	public void setLikeId(Long likeId) {
		this.likeId = likeId;
	}

	public Long getFromProfileId() {
		return fromProfileId;
	}

	public void setFromProfileId(Long fromProfileId) {
		this.fromProfileId = fromProfileId;
	}

	public Long getToProfileId() {
		return toProfileId;
	}

	public void setToProfileId(Long toProfileId) {
		this.toProfileId = toProfileId;
	}

	public Long getDanceVideoId() {
		return danceVideoId;
	}

	public void setDanceVideoId(Long danceVideoId) {
		this.danceVideoId = danceVideoId;
	}

	public Long getSingingVideoId() {
		return singingVideoId;
	}

	public void setSingingVideoId(Long singingVideoId) {
		this.singingVideoId = singingVideoId;
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

	public void setCreativeVideoId(Long creativeVideoId) {
		this.creativeVideoId = creativeVideoId;
	}

	public Long getReelsVideoId() {
		return reelsVideoId;
	}

	public void setReelsVideoId(Long reelsVideoId) {
		this.reelsVideoId = reelsVideoId;
	}

	public Long getInspireVideoId() {
		return inspireVideoId;
	}

	public void setInspireVideoId(Long inspireVideoId) {
		this.inspireVideoId = inspireVideoId;
	}

	public Long getComedyVideoId() {
		return comedyVideoId;
	}

	public void setComedyVideoId(Long comedyVideoId) {
		this.comedyVideoId = comedyVideoId;
	}

	@Override
	public String toString() {
		return "LikeDto [likeId=" + likeId + ", fromProfileId=" + fromProfileId + ", toProfileId=" + toProfileId
				+ ", danceVideoId=" + danceVideoId + ", singingVideoId=" + singingVideoId + ", musicVideoId="
				+ musicVideoId + ", creativeVideoId=" + creativeVideoId + ", reelsVideoId=" + reelsVideoId
				+ ", inspireVideoId=" + inspireVideoId + ", comedyVideoId=" + comedyVideoId + "]";
	}

	public LikeDto(Long likeId, Long fromProfileId, Long toProfileId, Long danceVideoId, Long singingVideoId,
			Long musicVideoId, Long creativeVideoId, Long reelsVideoId, Long inspireVideoId, Long comedyVideoId) {
		super();
		this.likeId = likeId;
		this.fromProfileId = fromProfileId;
		this.toProfileId = toProfileId;
		this.danceVideoId = danceVideoId;
		this.singingVideoId = singingVideoId;
		this.musicVideoId = musicVideoId;
		this.creativeVideoId = creativeVideoId;
		this.reelsVideoId = reelsVideoId;
		this.inspireVideoId = inspireVideoId;
		this.comedyVideoId = comedyVideoId;
	}

	public LikeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	


}
