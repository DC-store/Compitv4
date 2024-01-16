package com.CompitApplication.dtos;

public class VideoDto {
	
	private long videoId;
	
	private String videoName;

	private String VideoDescription;

	private String videoUrl;
	
	private Long profileId;
	
	private String userName;
	

	public VideoDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VideoDto(long videoId, String videoName, String videoDescription, String videoUrl, Long profileId,
			String userName) {
		super();
		this.videoId = videoId;
		this.videoName = videoName;
		VideoDescription = videoDescription;
		this.videoUrl = videoUrl;
		this.profileId = profileId;
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "ComedyVideoDto [videoId=" + videoId + ", videoName=" + videoName + ", VideoDescription="
				+ VideoDescription + ", videoUrl=" + videoUrl + ", profileId=" + profileId + ", userName=" + userName
				+ "]";
	}

	public long getVideoId() {
		return videoId;
	}

	public void setVideoId(long videoId) {
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

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	

}
