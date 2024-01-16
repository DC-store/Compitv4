package com.CompitApplication.Component;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class VideoRequest {
	
	private String description;
	
	private List<String> videourl;

	private String username;

	public VideoRequest(String description, List<String> videourl, String username) {
		super();
		this.description = description;
		this.videourl = videourl;
		this.username = username;
	}

	public VideoRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "VideoRequest [description=" + description + ", videourl=" + videourl + ", username=" + username + "]";
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getVideourl() {
		return videourl;
	}

	public void setVideourl(List<String> videourl) {
		this.videourl = videourl;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
