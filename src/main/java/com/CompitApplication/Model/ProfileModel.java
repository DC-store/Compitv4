package com.CompitApplication.Model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name="profile_model_tabel")
public class ProfileModel implements Serializable, UserDetails{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 384696286825198771L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    @Column(name = "user_name")
    private String usernames;
    
	
	@Column(name="phone_number")
	private Long phnnumber;
	
	@Column(name="gmail")
	private String gmail;
	
	@Column(name="password")
	private String password;
	
	@Column(name="date_of_birth")
	private String dob;
	
	@Column(name="profile_image_url")
	private String imageurl;

	
	
	 @OneToOne(cascade = CascadeType.ALL,mappedBy = "challengeFromId")
	    @JsonIgnoreProperties("challengeFromId")
	    private ChallengeModel fromchallengeModel;
	    
	    @OneToOne(cascade = CascadeType.ALL,mappedBy = "challengeToID")
	    @JsonIgnoreProperties("challengeToID")
	    private ChallengeModel tochallengeModel;
	
	@OneToOne(cascade = CascadeType.ALL ,mappedBy = "supportingId")
    @JsonIgnoreProperties("supportingId")
    private SupportModel fromsuppId;
    
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "supportGettingId")
    @JsonIgnoreProperties("supportGettingId")
    private SupportModel toSupportId;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "lprofileId")
    @JsonIgnoreProperties("lprofileId")
    private LikesModel likeid;
	
    
   
    
    @OneToMany( mappedBy = "profilemodel", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("profilemodel")
    @Fetch(value = FetchMode.SUBSELECT)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<VideoModel> videoList = new ArrayList<>();
    
    
    @OneToMany( mappedBy = "cprofilemodel", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("cprofilemodel")
    @Fetch(value = FetchMode.SUBSELECT)
    @LazyCollection(LazyCollectionOption.FALSE)
	private List<ComedyVideoModel> comedyVideoList = new ArrayList<>();
    
    
    @OneToMany( mappedBy = "rprofilemodel", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("rprofilemodel")
    @Fetch(value = FetchMode.SUBSELECT)
    @LazyCollection(LazyCollectionOption.FALSE)
	private List<ReelsVideoModel> reelsVideoList = new ArrayList<>();
    
    
    @OneToMany(mappedBy = "crprofilemodel", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("crprofilemodel")
    @Fetch(value = FetchMode.SUBSELECT)
    @LazyCollection(LazyCollectionOption.FALSE)
	private List<CreativeVideoModel> creativeVideoList = new ArrayList<>();
    
    
    @OneToMany( mappedBy = "insprofilemodel", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("insprofilemodel")
    @Fetch(value = FetchMode.SUBSELECT)
    @LazyCollection(LazyCollectionOption.FALSE)
	private List<InspireVideoModel> inspireVideoList = new ArrayList<>();
    
    
    @OneToMany( mappedBy = "muprofilemodel", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("muprofilemodel")
    @Fetch(value = FetchMode.SUBSELECT)
    @LazyCollection(LazyCollectionOption.FALSE)
	private List<MusicVideoModel> musicVideoList = new ArrayList<>();

    @OneToMany( mappedBy = "singprofilemodel", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("singprofilemodel")
    @Fetch(value = FetchMode.SUBSELECT)
    @LazyCollection(LazyCollectionOption.FALSE)
	private List<SingingVideoModel> singVideoList = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name="user_role",
    joinColumns =@JoinColumn(name="user", referencedColumnName = "profileId"),
    inverseJoinColumns = @JoinColumn(name="role", referencedColumnName = "roleId"))
	private Set<Roles> roles= new HashSet<>();
    
    
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "trophyProfileId")
    @JsonIgnoreProperties("trophyProfileId")
    private TrophyModel profileTrophyModel;
    
    
public ProfileModel() {
		super();
		// TODO Auto-generated constructor stub
	}

public ProfileModel(long profileId, String usernames, Long phnnumber, String gmail, String password, String dob,
			String imageurl, ChallengeModel fromchallengeModel, ChallengeModel tochallengeModel,
			SupportModel fromsuppId, SupportModel toSupportId, LikesModel likeid, List<VideoModel> videoList,
			List<ComedyVideoModel> comedyVideoList, List<ReelsVideoModel> reelsVideoList,
			List<CreativeVideoModel> creativeVideoList, List<InspireVideoModel> inspireVideoList,
			List<MusicVideoModel> musicVideoList, List<SingingVideoModel> singVideoList, Set<Roles> roles,
			TrophyModel profileTrophyModel) {
		super();
		this.profileId = profileId;
		this.usernames = usernames;
		this.phnnumber = phnnumber;
		this.gmail = gmail;
		this.password = password;
		this.dob = dob;
		this.imageurl = imageurl;
		this.fromchallengeModel = fromchallengeModel;
		this.tochallengeModel = tochallengeModel;
		this.fromsuppId = fromsuppId;
		this.toSupportId = toSupportId;
		this.likeid = likeid;
		this.videoList = videoList;
		this.comedyVideoList = comedyVideoList;
		this.reelsVideoList = reelsVideoList;
		this.creativeVideoList = creativeVideoList;
		this.inspireVideoList = inspireVideoList;
		this.musicVideoList = musicVideoList;
		this.singVideoList = singVideoList;
		this.roles = roles;
		this.profileTrophyModel = profileTrophyModel;
	}

@Override
	public String toString() {
		return "ProfileModel [profileId=" + profileId + ", usernames=" + usernames + ", phnnumber=" + phnnumber
				+ ", gmail=" + gmail + ", password=" + password + ", dob=" + dob + ", imageurl=" + imageurl
				+ ", fromchallengeModel=" + fromchallengeModel + ", tochallengeModel=" + tochallengeModel
				+ ", fromsuppId=" + fromsuppId + ", toSupportId=" + toSupportId + ", likeid=" + likeid + ", videoList="
				+ videoList + ", comedyVideoList=" + comedyVideoList + ", reelsVideoList=" + reelsVideoList
				+ ", creativeVideoList=" + creativeVideoList + ", inspireVideoList=" + inspireVideoList
				+ ", musicVideoList=" + musicVideoList + ", singVideoList=" + singVideoList + ", roles=" + roles
				+ ", profileTrophyModel=" + profileTrophyModel + "]";
	}

public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(long userId) {
		this.profileId = userId;
	}

	public String getUsernames() {
		return usernames;
	}

	public void setUsernames(String usernames) {
		this.usernames = usernames;
	}

	public Long getPhnnumber() {
		return phnnumber;
	}

	public void setPhnnumber(Long phnnumber) {
		this.phnnumber = phnnumber;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public ChallengeModel getFromchallengeModel() {
		return fromchallengeModel;
	}

	public void setFromchallengeModel(ChallengeModel fromchallengeModel) {
		this.fromchallengeModel = fromchallengeModel;
	}

	public ChallengeModel getTochallengeModel() {
		return tochallengeModel;
	}

	public void setTochallengeModel(ChallengeModel tochallengeModel) {
		this.tochallengeModel = tochallengeModel;
	}

	public SupportModel getFromsuppId() {
		return fromsuppId;
	}

	public void setFromsuppId(SupportModel fromsuppId) {
		this.fromsuppId = fromsuppId;
	}

	public SupportModel getToSupportId() {
		return toSupportId;
	}

	public void setToSupportId(SupportModel toSupportId) {
		this.toSupportId = toSupportId;
	}

	public LikesModel getLikeid() {
		return likeid;
	}

	public void setLikeid(LikesModel likeid) {
		this.likeid = likeid;
	}

	public List<VideoModel> getVideoList() {
		return videoList;
	}

	public void setVideoList(List<VideoModel> videoList) {
		this.videoList = videoList;
	}

	public List<ComedyVideoModel> getComedyVideoList() {
		return comedyVideoList;
	}

	public void setComedyVideoList(List<ComedyVideoModel> comedyVideoList) {
		this.comedyVideoList = comedyVideoList;
	}

	public List<ReelsVideoModel> getReelsVideoList() {
		return reelsVideoList;
	}

	public void setReelsVideoList(List<ReelsVideoModel> reelsVideoList) {
		this.reelsVideoList = reelsVideoList;
	}

	public List<CreativeVideoModel> getCreativeVideoList() {
		return creativeVideoList;
	}

	public void setCreativeVideoList(List<CreativeVideoModel> creativeVideoList) {
		this.creativeVideoList = creativeVideoList;
	}

	public List<InspireVideoModel> getInspireVideoList() {
		return inspireVideoList;
	}

	public void setInspireVideoList(List<InspireVideoModel> inspireVideoList) {
		this.inspireVideoList = inspireVideoList;
	}

	public List<MusicVideoModel> getMusicVideoList() {
		return musicVideoList;
	}

	public void setMusicVideoList(List<MusicVideoModel> musicVideoList) {
		this.musicVideoList = musicVideoList;
	}

	public List<SingingVideoModel> getSingVideoList() {
		return singVideoList;
	}

	public void setSingVideoList(List<SingingVideoModel> singVideoList) {
		this.singVideoList = singVideoList;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	public TrophyModel getProfileTrophyModel() {
		return profileTrophyModel;
	}

	public void setProfileTrophyModel(TrophyModel profileTrophyModel) {
		this.profileTrophyModel = profileTrophyModel;
	}

	// this is from the jwt authentication please dont change it darshan
	
	//this is for security
	@Override
	public String getUsername() {
		System.out.println("====inside the getUsername =====");
		return this.usernames;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities=  this.roles.stream().map((role)-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		System.out.println("===inside the collection get authorities====");
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

    
    
    
	
}
