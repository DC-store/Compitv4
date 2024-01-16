package com.CompitApplication.dtos;

public class BackGroundMusicDto {

	private Long bgid;

	private String bgMusicName;

	private String bgMusicUrl;

	private String bgimgUrl;

	public BackGroundMusicDto(Long bgid, String bgMusicName, String bgMusicUrl, String bgimgUrl) {
		super();
		this.bgid = bgid;
		this.bgMusicName = bgMusicName;
		this.bgMusicUrl = bgMusicUrl;
		this.bgimgUrl = bgimgUrl;
	}

	public BackGroundMusicDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BackGroundMusicDto [bgid=" + bgid + ", bgMusicName=" + bgMusicName + ", bgMusicUrl=" + bgMusicUrl
				+ ", bgimgUrl=" + bgimgUrl + "]";
	}

	public Long getBgid() {
		return bgid;
	}

	public void setBgid(Long bgid) {
		this.bgid = bgid;
	}

	public String getBgMusicName() {
		return bgMusicName;
	}

	public void setBgMusicName(String bgMusicName) {
		this.bgMusicName = bgMusicName;
	}

	public String getBgMusicUrl() {
		return bgMusicUrl;
	}

	public void setBgMusicUrl(String bgMusicUrl) {
		this.bgMusicUrl = bgMusicUrl;
	}

	public String getBgimgUrl() {
		return bgimgUrl;
	}

	public void setBgimgUrl(String bgimgUrl) {
		this.bgimgUrl = bgimgUrl;
	}

}
