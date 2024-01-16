package com.CompitApplication.Service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.CompitApplication.AppConst.ApiCode;
import com.CompitApplication.AppConst.AppConstants;
import com.CompitApplication.AppConst.MobileNumberGetiing;
import com.CompitApplication.AppConst.TranscationIdentifier;
import com.CompitApplication.Logger.LoggingUtils;
import com.CompitApplication.Model.ComedyVideoModel;
import com.CompitApplication.Model.CreativeVideoModel;
import com.CompitApplication.Model.InspireVideoModel;
import com.CompitApplication.Model.MusicVideoModel;
import com.CompitApplication.Model.ProfileModel;
import com.CompitApplication.Model.ReelsVideoModel;
import com.CompitApplication.Model.Roles;
import com.CompitApplication.Model.SingingVideoModel;
import com.CompitApplication.Model.VideoModel;
import com.CompitApplication.Repository.ComedyVideoRepository;
import com.CompitApplication.Repository.CreativeVideoRepository;
import com.CompitApplication.Repository.InspireVideoRepository;
import com.CompitApplication.Repository.MusicVideoRepository;
import com.CompitApplication.Repository.ProfileRepository;
import com.CompitApplication.Repository.ReelsVideoRepository;
import com.CompitApplication.Repository.RoleRepo;
import com.CompitApplication.Repository.SingingVideoRepository;
import com.CompitApplication.Repository.VideoRepository;
import com.CompitApplication.dtos.ProfileDto;


@Transactional
@Service
@Validated
public class ProfileRegService {

	static LoggingUtils logger = new LoggingUtils(ProfileRegService.class.getName());

	@Autowired
	private ProfileRepository profilerepo;

	@Autowired
	private VideoRepository videoRepo;

	@Autowired
	private ComedyVideoRepository comedyVideoRepo;

	@Autowired
	public CreativeVideoRepository creativeVideoRepo;

	@Autowired
	public InspireVideoRepository inspireVideoRepo;

	@Autowired
	public MusicVideoRepository musicVideoRepo;

	@Autowired
	public ReelsVideoRepository reelsVideoRepo;

	@Autowired
	private SingingVideoRepository singingVideoRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepo roleRepo;

	@Autowired
	private MobileNumberGetiing getiingMobNum;

	public ProfileDto savingProfile(@Valid ProfileDto profile) {
		Long profileId = 0L;
		String mobNumForTransId = getiingMobNum.gettingMobileNumber(profileId);
	
		
		// TODO txn id generating for logs
		TranscationIdentifier identifier = new TranscationIdentifier();
		String txn = identifier.getAPITransactionId(ApiCode.CREATE_PROFILE, mobNumForTransId);
		logger.info("txn: " + txn + " func: savingProfile() Req: username :" + profile.getUsernames() + " dob: "
				+ profile.getDob() + " phnNumber:  " + profile.getPhnNumber() + " gmail: " + profile.getGmail());
		
		// have to check the email id for checking the existing user
		
		
	
		ProfileModel profiling = new ProfileModel();

		profiling.setUsernames(profile.getUsernames());
		logger.trace("txn: " + txn + "func: username has been set :" + profiling.getUsernames());
		profiling.setGmail(profile.getGmail());
		logger.trace("txn: " + txn + " setGmail : gmail has been set :" + profiling.getGmail());
		profiling.setDob(profile.getDob());
		logger.trace("txn: " + txn + " setDob : dob has been set :" + profiling.getDob());
		profiling.setPhnnumber(new Long(profile.getPhnNumber()));
		logger.trace("txn: " + txn + " setPhnnumber : phonumber  has been set :" + profiling.getPhnnumber());
		// TODO have to set the default image if image is not there
		profiling.setImageurl(null);
		logger.trace("txn: " + txn + " set image : ");

		logger.trace("txn: " + txn + " password has been set ");

		Roles role = this.roleRepo.findById(AppConstants.NORMAL_USER).get();
		logger.trace("txn " + txn + " role selecting :" + role.getName());

		profiling.getRoles().add(role);

		// ProfileModel newUser = this.userRepo.save(user);

		String encodedPass = passwordEncoder.encode(profile.getPassword());

		profiling.setPassword(encodedPass);
		ProfileModel profil = profilerepo.save(profiling);
		
		ProfileDto dto= new ProfileDto();
		dto.setProfileId(profil.getProfileId());
		dto.setDob(profile.getDob());
		dto.setGmail(profil.getGmail());
		dto.setPassword(profil.getPassword());
		
		dto.setUsernames(profil.getUsernames());
		dto.setPhnNumber(profil.getPhnnumber().toString());
//		return this.modelMapper.map(newUser, UserDto.class);
		logger.info("txn " + txn + " profile has been saved: " + profil.toString());

		if (profil != null || profil.toString() != null || !profil.toString().equals("")) {
			logger.info("txn :" + txn + " Successfully saved Profile");
			return dto;
		} else {
			return null;
		}

	}

//get all profile 
	public List<ProfileModel> getProfile() {

		return profilerepo.findAll();
	}

	//update is in mistake have to upadate properly
//	public ProfileModel updateProfile(ProfileDto profreg) {
//
//		if (profreg.getPhnNumber() != "" && ((profreg.getPhnNumber().length()==12) &&!(profreg.getPhnNumber().length()==0))) {
//			profreg.setPhnnumber(new Long(profreg.getPhnNumber()));
//		}
//		if (profreg.getGmail() != null) {
//			profreg.setGmail(profreg.getGmail());
//		}
//		if (profreg.getUsername() != null) {
//			profreg.setUsernames(profreg.getUsername());
//		}
//		if (profreg.getImageurl() != null) {
//			profreg.setImageurl(profreg.getImageurl());
//		}
//		if (profreg.getPassword() != null) {
//			profreg.setPassword(profreg.getPassword());
//		}
//		ProfileModel prof = profilerepo.save(profreg);
//
//		return prof;
//	}

	// delete image
	public String deleteProfileImage(int profileId) {
		ProfileModel profile = profilerepo.findByProfileId(profileId);
		profile.setImageurl(null);
		profilerepo.save(profile);
		return "deleted sucessfully";
	}

	public void UploadPhotoUrl(long id, String url) {

		System.out.println("inside the photo url upload");
		ProfileModel profile = profilerepo.getById(id);
		if (!url.equals(null)) {
			profile.setImageurl(url);
			profilerepo.save(profile);
		} else {
			System.out.println("no url add the default url");
		}

	}

	public VideoModel findProfile(long profileid, String VideoUrl) {

		System.out.println("inside the profile finding to do upload of the dance video for the particular profile");
		// its not working properly
		ProfileModel model = profilerepo.getById(profileid);
		System.out.println(model.getProfileId());
		System.out.println(model.getUsername());
		System.out.println(
				"=======================profile getting to set the video url  based on the  specific profile =====");
		// String upload= videoService.UploadVideoUrl(model, VideoUrl);
		System.out.println();
		System.out.println("profile found and has been set....");
		;
		VideoModel video = new VideoModel();

		video.setVideoUrl(VideoUrl);
		System.out.println("setting the video url");
		video.setProfilemodel(model);
		System.out.println("setting the profile id inside the video url");
		VideoModel videoModel = videoRepo.save(video);
		System.out.println("the video model has been saved sucesfully ");
		return videoModel;
	}

//=============================================================================

	public ProfileModel findComedyProfile(long profileid, String VideoUrl) {

		System.out.println("inside the profile finding to do uploadation");
		// its not working properly
		ProfileModel model = profilerepo.getById(profileid);
		System.out.println(model.getProfileId());
		System.out.println(model.getUsername());
		System.out.println("=======================comedy video url upload");
		// String upload= videoService.UploadVideoUrl(model, VideoUrl);
		ComedyVideoModel video = new ComedyVideoModel();

		video.setVideoUrl(VideoUrl);
		video.setCprofilemodel(model);
		comedyVideoRepo.save(video);
		return model;
	}

//creative Video model in the section 
	public ProfileModel findCreativeProfile(long profileid, String VideoUrl) {

		System.out.println("inside the profile finding to do uploadation");
		// its not working properly
		ProfileModel model = profilerepo.getById(profileid);
		System.out.println(model.getProfileId());
		System.out.println(model.getUsername());
		System.out.println("=======================Creative video url upload");
		// String upload= videoService.UploadVideoUrl(model, VideoUrl);
		CreativeVideoModel video = new CreativeVideoModel();

		video.setVideoUrl(VideoUrl);
		video.setCrprofilemodel(model);
		creativeVideoRepo.save(video);
		return model;
	}

//
//creative Video model in the section 
	public ProfileModel findInspireProfile(long profileid, String VideoUrl) {

		System.out.println("inside the profile finding to do uploadation");
		// its not working properly
		ProfileModel model = profilerepo.getById(profileid);
		System.out.println(model.getProfileId());
		System.out.println(model.getUsername());
		System.out.println("=======================Inspire  video url upload");
		// String upload= videoService.UploadVideoUrl(model, VideoUrl);
		InspireVideoModel video = new InspireVideoModel();

		video.setVideoUrl(VideoUrl);
		video.setInsprofilemodel(model);
		inspireVideoRepo.save(video);
		return model;
	}

	public ProfileModel findSingingProfile(long profileid, String VideoUrl) {

		System.out.println("inside the profile finding to do uploadation");
		// its not working properly
		ProfileModel model = profilerepo.getById(profileid);
		System.out.println(model.getProfileId());
		System.out.println(model.getUsername());
		System.out.println("=======================Inspire  video url upload");
		// String upload= videoService.UploadVideoUrl(model, VideoUrl);
		SingingVideoModel video = new SingingVideoModel();

		video.setVideoUrl(VideoUrl);
		video.setSingprofilemodel(model);
		singingVideoRepo.save(video);
		return model;
	}

//creative Video model in the section 
	public ProfileModel findReelsProfile(long profileid, String VideoUrl) {

		System.out.println("inside the profile finding to do uploadation");
		// its not working properly
		ProfileModel model = profilerepo.getById(profileid);
		System.out.println(model.getProfileId());
		System.out.println(model.getUsername());
		System.out.println("=======================Creative Reels video url upload");
		// String upload= videoService.UploadVideoUrl(model, VideoUrl);
		ReelsVideoModel video = new ReelsVideoModel();

		video.setVideoUrl(VideoUrl);
		video.setRprofilemodel(model);
		reelsVideoRepo.save(video);
		return model;
	}

//creative Video model in the section 
	public ProfileModel findMusicProfile(long profileid, String VideoUrl) {

		System.out.println("inside the profile finding to do uploadation");
		// its not working properly
		ProfileModel model = profilerepo.getById(profileid);
		System.out.println(model.getProfileId());
		System.out.println(model.getUsername());
		System.out.println("=======================Music video url upload");
		// String upload= videoService.UploadVideoUrl(model, VideoUrl);
		MusicVideoModel video = new MusicVideoModel();

		video.setVideoUrl(VideoUrl);
		video.setMuprofilemodel(model);
		musicVideoRepo.save(video);
		return model;
	}

	public String profileDeletion(long id) {

		profilerepo.deleteById(id);

		return "sucessfully deleted";
	}

	public String usernamePick(String username) {
		Long profileId = 0L;
		String mobNumForTransId = getiingMobNum.gettingMobileNumber(profileId);

		
		TranscationIdentifier identifier = new TranscationIdentifier();
		String txn = identifier.getAPITransactionId(ApiCode.PROFILE_NAME_SELECTION, mobNumForTransId);
		logger.info("txn id:"+txn+" func: usernamePick()  req::"+username);
		logger.info("txn id:"+txn+" func: usernamePick()  calling:VerifyUserNamePresence()  req::"+username);
		String presence = profilerepo.VerifyUserNamePresence(username);
		logger.info("txn id:"+txn+"func: usernamePick() called gettALLUsername proc: output:"+presence);
		return presence;
	}

}
