package com.CompitApplication.BgMusicModel;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.CompitApplication.Model.ReelsVideoModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="bg_dailogue_model")
public class BgDailogueModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bgDailogueId;
	
	private String dailogueUrl;
	
	private String dailogueName;
	
	
	@OneToMany(mappedBy = "bgDailogueModel")
	@JsonIgnoreProperties("bgDailogueModel")
	@Fetch(value = FetchMode.SUBSELECT)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<ReelsVideoModel> bgdReelsVideoModel;


	public long getBgDailogueId() {
		return bgDailogueId;
	}


	public void setBgDailogueId(long bgDailogueId) {
		this.bgDailogueId = bgDailogueId;
	}


	public String getDailogueUrl() {
		return dailogueUrl;
	}


	public void setDailogueUrl(String dailogueUrl) {
		this.dailogueUrl = dailogueUrl;
	}


	public String getDailogueName() {
		return dailogueName;
	}


	public void setDailogueName(String dailogueName) {
		this.dailogueName = dailogueName;
	}


	public List<ReelsVideoModel> getBgdReelsVideoModel() {
		return bgdReelsVideoModel;
	}


	public void setBgdReelsVideoModel(List<ReelsVideoModel> bgdReelsVideoModel) {
		this.bgdReelsVideoModel = bgdReelsVideoModel;
	}


	@Override
	public String toString() {
		return "BgDailogueModel [bgDailogueId=" + bgDailogueId + ", dailogueUrl=" + dailogueUrl + ", dailogueName="
				+ dailogueName + ", bgdReelsVideoModel=" + bgdReelsVideoModel + "]";
	}


	public BgDailogueModel(long bgDailogueId, String dailogueUrl, String dailogueName,
			List<ReelsVideoModel> bgdReelsVideoModel) {
		super();
		this.bgDailogueId = bgDailogueId;
		this.dailogueUrl = dailogueUrl;
		this.dailogueName = dailogueName;
		this.bgdReelsVideoModel = bgdReelsVideoModel;
	}


	public BgDailogueModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	
	
	

}
