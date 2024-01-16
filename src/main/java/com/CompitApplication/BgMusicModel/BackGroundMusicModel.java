package com.CompitApplication.BgMusicModel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.CompitApplication.Model.ComedyVideoModel;
import com.CompitApplication.Model.CreativeVideoModel;
import com.CompitApplication.Model.InspireVideoModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "background_music_model_table")
public class BackGroundMusicModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bgMusicId;

	private String bgMusicName;

	private String bgMusicUrl;

	private String bgimgUrl;

	@OneToMany(mappedBy = "backGroundMusicModel")
	@JsonIgnoreProperties("backGroundMusicModel")
	@Fetch(value = FetchMode.SUBSELECT)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<InspireVideoModel> inspireVideoList = new ArrayList<>();

	@OneToMany(mappedBy = "backGroundMusicModel")
	@JsonIgnoreProperties("backGroundMusicModel")
	@Fetch(value = FetchMode.SUBSELECT)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<CreativeVideoModel> creativeVideoList;

	@OneToMany(mappedBy = "comedyBackGroundMusicModel")
	@JsonIgnoreProperties("comedyBackGroundMusicModel")
	@Fetch(value = FetchMode.SUBSELECT)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<ComedyVideoModel> comedyVideoModelsList;

	public BackGroundMusicModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BackGroundMusicModel(long bgMusicId, String bgMusicName, String bgMusicUrl, String bgimgUrl,
			List<InspireVideoModel> inspireVideoList, List<CreativeVideoModel> creativeVideoList,
			List<ComedyVideoModel> comedyVideoModelsList) {
		super();
		this.bgMusicId = bgMusicId;
		this.bgMusicName = bgMusicName;
		this.bgMusicUrl = bgMusicUrl;
		this.bgimgUrl = bgimgUrl;
		this.inspireVideoList = inspireVideoList;
		this.creativeVideoList = creativeVideoList;
		this.comedyVideoModelsList = comedyVideoModelsList;
	}

	@Override
	public String toString() {
		return "BackGroundMusicModel [bgMusicId=" + bgMusicId + ", bgMusicName=" + bgMusicName + ", bgMusicUrl="
				+ bgMusicUrl + ", bgimgUrl=" + bgimgUrl + ", inspireVideoList=" + inspireVideoList
				+ ", creativeVideoList=" + creativeVideoList + ", comedyVideoModelsList=" + comedyVideoModelsList + "]";
	}

	public long getBgMusicId() {
		return bgMusicId;
	}

	public void setBgMusicId(long bgMusicId) {
		this.bgMusicId = bgMusicId;
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

	public List<InspireVideoModel> getInspireVideoList() {
		return inspireVideoList;
	}

	public void setInspireVideoList(List<InspireVideoModel> inspireVideoList) {
		this.inspireVideoList = inspireVideoList;
	}

	public List<CreativeVideoModel> getCreativeVideoList() {
		return creativeVideoList;
	}

	public void setCreativeVideoList(List<CreativeVideoModel> creativeVideoList) {
		this.creativeVideoList = creativeVideoList;
	}

	public List<ComedyVideoModel> getComedyVideoModelsList() {
		return comedyVideoModelsList;
	}

	public void setComedyVideoModelsList(List<ComedyVideoModel> comedyVideoModelsList) {
		this.comedyVideoModelsList = comedyVideoModelsList;
	}

}
