package com.CompitApplication.BgMusicModel;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.CompitApplication.Model.VideoModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="bgSomgsVideoModel")
public class BgSongsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bgSongId;
	
	
	private String bgSongUrl;
	
	
	private String bgSongName;
	
	
	private String bgSongImage;
	
	@OneToMany(mappedBy = "bgSongsVideoModel")
	@JsonIgnoreProperties("bgSongsVideoModel")
	@Fetch(value = FetchMode.SUBSELECT)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<VideoModel> danceVideoList;

	public long getBgSongId() {
		return bgSongId;
	}

	public void setBgSongId(long bgSongId) {
		this.bgSongId = bgSongId;
	}

	public String getBgSongUrl() {
		return bgSongUrl;
	}

	public void setBgSongUrl(String bgSongUrl) {
		this.bgSongUrl = bgSongUrl;
	}

	public String getBgSongName() {
		return bgSongName;
	}

	public void setBgSongName(String bgSongName) {
		this.bgSongName = bgSongName;
	}

	public String getBgSongImage() {
		return bgSongImage;
	}

	public void setBgSongImage(String bgSongImage) {
		this.bgSongImage = bgSongImage;
	}

	public List<VideoModel> getDanceVideoList() {
		return danceVideoList;
	}

	public void setDanceVideoList(List<VideoModel> danceVideoList) {
		this.danceVideoList = danceVideoList;
	}

	@Override
	public String toString() {
		return "BgSongsVideoModel [bgSongId=" + bgSongId + ", bgSongUrl=" + bgSongUrl + ", bgSongName=" + bgSongName
				+ ", bgSongImage=" + bgSongImage + ", danceVideoList=" + danceVideoList + "]";
	}

	public BgSongsModel(long bgSongId, String bgSongUrl, String bgSongName, String bgSongImage,
			List<VideoModel> danceVideoList) {
		super();
		this.bgSongId = bgSongId;
		this.bgSongUrl = bgSongUrl;
		this.bgSongName = bgSongName;
		this.bgSongImage = bgSongImage;
		this.danceVideoList = danceVideoList;
	}

	public BgSongsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
