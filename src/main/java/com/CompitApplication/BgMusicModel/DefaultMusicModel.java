package com.CompitApplication.BgMusicModel;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.CompitApplication.Model.ComedyVideoModel;
import com.CompitApplication.Model.CreativeVideoModel;
import com.CompitApplication.Model.InspireVideoModel;
import com.CompitApplication.Model.MusicVideoModel;
import com.CompitApplication.Model.ReelsVideoModel;
import com.CompitApplication.Model.SingingVideoModel;
import com.CompitApplication.Model.VideoModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="default_music_model")
public class DefaultMusicModel {

	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long defMsusicId;
	
	
	private String defMusicName;
	
	private String defMusicUrl;
	
	private String defImgurl;
	
	@OneToMany(mappedBy = "defaultMusicModel")
	@JsonIgnoreProperties("defaultMusicModel")
	@Fetch(value = FetchMode.SUBSELECT)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<InspireVideoModel> defInspireVideoList;

	@OneToMany(mappedBy = "musicDefaultMusicModel")
	@JsonIgnoreProperties("musicDefaultMusicModel")
	@Fetch(value = FetchMode.SUBSELECT)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<MusicVideoModel> defMusicVideoList;
	
	
	
	@OneToMany(mappedBy = "reelsDefaultMusicModel")
	@JsonIgnoreProperties("reelsDefaultMusicModel")
	@Fetch(value = FetchMode.SUBSELECT)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<ReelsVideoModel> defReelsVideoList;


	@OneToMany(mappedBy = "karokeDefaultMusicModel")
	@JsonIgnoreProperties("karokeDefaultMusicModel")
	@Fetch(value = FetchMode.SUBSELECT)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<SingingVideoModel> defSingingVideoList;

	@OneToMany(mappedBy = "creativeDefaultMusicModel")
	@JsonIgnoreProperties("creativeDefaultMusicModel")
	@Fetch(value = FetchMode.SUBSELECT)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<CreativeVideoModel> creativeVideoModelsList;

	@OneToMany(mappedBy = "comedyDefaultMusicModel")
	@JsonIgnoreProperties("comedyDefaultMusicModel")
	@Fetch(value = FetchMode.SUBSELECT)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<ComedyVideoModel> comedyVideoModelsList;

	
	@OneToMany(mappedBy = "danceVideoDefaultMusicModel")
	@JsonIgnoreProperties("danceVideoDefaultMusicModel")
	@Fetch(value = FetchMode.SUBSELECT)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<VideoModel> danceVideoModelsList;


	public DefaultMusicModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DefaultMusicModel(long defMsusicId, String defMusicName, String defMusicUrl, String defImgurl,
			List<InspireVideoModel> defInspireVideoList, List<MusicVideoModel> defMusicVideoList,
			List<ReelsVideoModel> defReelsVideoList, List<SingingVideoModel> defSingingVideoList,
			List<CreativeVideoModel> creativeVideoModelsList, List<ComedyVideoModel> comedyVideoModelsList,
			List<VideoModel> danceVideoModelsList) {
		super();
		this.defMsusicId = defMsusicId;
		this.defMusicName = defMusicName;
		this.defMusicUrl = defMusicUrl;
		this.defImgurl = defImgurl;
		this.defInspireVideoList = defInspireVideoList;
		this.defMusicVideoList = defMusicVideoList;
		this.defReelsVideoList = defReelsVideoList;
		this.defSingingVideoList = defSingingVideoList;
		this.creativeVideoModelsList = creativeVideoModelsList;
		this.comedyVideoModelsList = comedyVideoModelsList;
		this.danceVideoModelsList = danceVideoModelsList;
	}


	@Override
	public String toString() {
		return "DefaultMusicModel [defMsusicId=" + defMsusicId + ", defMusicName=" + defMusicName + ", defMusicUrl="
				+ defMusicUrl + ", defImgurl=" + defImgurl + ", defInspireVideoList=" + defInspireVideoList
				+ ", defMusicVideoList=" + defMusicVideoList + ", defReelsVideoList=" + defReelsVideoList
				+ ", defSingingVideoList=" + defSingingVideoList + ", creativeVideoModelsList="
				+ creativeVideoModelsList + ", comedyVideoModelsList=" + comedyVideoModelsList
				+ ", danceVideoModelsList=" + danceVideoModelsList + "]";
	}


	public long getDefMsusicId() {
		return defMsusicId;
	}


	public void setDefMsusicId(long defMsusicId) {
		this.defMsusicId = defMsusicId;
	}


	public String getDefMusicName() {
		return defMusicName;
	}


	public void setDefMusicName(String defMusicName) {
		this.defMusicName = defMusicName;
	}


	public String getDefMusicUrl() {
		return defMusicUrl;
	}


	public void setDefMusicUrl(String defMusicUrl) {
		this.defMusicUrl = defMusicUrl;
	}


	public String getDefImgurl() {
		return defImgurl;
	}


	public void setDefImgurl(String defImgurl) {
		this.defImgurl = defImgurl;
	}


	public List<InspireVideoModel> getDefInspireVideoList() {
		return defInspireVideoList;
	}


	public void setDefInspireVideoList(List<InspireVideoModel> defInspireVideoList) {
		this.defInspireVideoList = defInspireVideoList;
	}


	public List<MusicVideoModel> getDefMusicVideoList() {
		return defMusicVideoList;
	}


	public void setDefMusicVideoList(List<MusicVideoModel> defMusicVideoList) {
		this.defMusicVideoList = defMusicVideoList;
	}


	public List<ReelsVideoModel> getDefReelsVideoList() {
		return defReelsVideoList;
	}


	public void setDefReelsVideoList(List<ReelsVideoModel> defReelsVideoList) {
		this.defReelsVideoList = defReelsVideoList;
	}


	public List<SingingVideoModel> getDefSingingVideoList() {
		return defSingingVideoList;
	}


	public void setDefSingingVideoList(List<SingingVideoModel> defSingingVideoList) {
		this.defSingingVideoList = defSingingVideoList;
	}


	public List<CreativeVideoModel> getCreativeVideoModelsList() {
		return creativeVideoModelsList;
	}


	public void setCreativeVideoModelsList(List<CreativeVideoModel> creativeVideoModelsList) {
		this.creativeVideoModelsList = creativeVideoModelsList;
	}


	public List<ComedyVideoModel> getComedyVideoModelsList() {
		return comedyVideoModelsList;
	}


	public void setComedyVideoModelsList(List<ComedyVideoModel> comedyVideoModelsList) {
		this.comedyVideoModelsList = comedyVideoModelsList;
	}


	public List<VideoModel> getDanceVideoModelsList() {
		return danceVideoModelsList;
	}


	public void setDanceVideoModelsList(List<VideoModel> danceVideoModelsList) {
		this.danceVideoModelsList = danceVideoModelsList;
	}

	
}
