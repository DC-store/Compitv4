package com.CompitApplication.BgMusicModel;

import java.util.List;

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

import com.CompitApplication.Model.SingingVideoModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "karoke_model_table")
public class KarokeModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long karokeID;
	
	private String karokeName;
	
	
	private String karokeUrl;
	
	
	private String karokeImage;
	
	
	@OneToMany(mappedBy = "singkarokeModel")
	@JsonIgnoreProperties("singkarokeModel")
	@Fetch(value = FetchMode.SUBSELECT)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<SingingVideoModel> singingVideoList;


	public KarokeModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public KarokeModel(long karokeID, String karokeName, String karokeUrl, String karokeImage,
			List<SingingVideoModel> singingVideoList) {
		super();
		this.karokeID = karokeID;
		this.karokeName = karokeName;
		this.karokeUrl = karokeUrl;
		this.karokeImage = karokeImage;
		this.singingVideoList = singingVideoList;
	}


	@Override
	public String toString() {
		return "KarokeModel [karokeID=" + karokeID + ", karokeName=" + karokeName + ", karokeUrl=" + karokeUrl
				+ ", karokeImage=" + karokeImage + ", singingVideoList=" + singingVideoList + "]";
	}


	public long getKarokeID() {
		return karokeID;
	}


	public void setKarokeID(long karokeID) {
		this.karokeID = karokeID;
	}


	public String getKarokeName() {
		return karokeName;
	}


	public void setKarokeName(String karokeName) {
		this.karokeName = karokeName;
	}


	public String getKarokeUrl() {
		return karokeUrl;
	}


	public void setKarokeUrl(String karokeUrl) {
		this.karokeUrl = karokeUrl;
	}


	public String getKarokeImage() {
		return karokeImage;
	}


	public void setKarokeImage(String karokeImage) {
		this.karokeImage = karokeImage;
	}


	public List<SingingVideoModel> getSingingVideoList() {
		return singingVideoList;
	}


	public void setSingingVideoList(List<SingingVideoModel> singingVideoList) {
		this.singingVideoList = singingVideoList;
	}
	
	


	
	
}
