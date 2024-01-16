package com.CompitApplication.Controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.CompitApplication.Component.VideoRequest;
import com.CompitApplication.Exception.ParameterException;
import com.CompitApplication.Logger.LoggingUtils;
import com.CompitApplication.Model.ProfileModel;
import com.CompitApplication.Model.VideoModel;
import com.CompitApplication.Repository.ProfileRepository;
import com.CompitApplication.Repository.VideoRepository;
import com.CompitApplication.Response.ApiResponse;
import com.CompitApplication.Service.ProfileModelDataService;
import com.CompitApplication.Service.ProfileRegService;
import com.CompitApplication.Service.ProfileServices;
import com.CompitApplication.dtos.ProfileDto;

// profile update has to be made and the profile registration has to be made 

@RestController
@RequestMapping("/api/v1/profileControler")
public class ProfileController {
// if video get deleted find a video id create a query to delete all row of that like id	
	@Autowired
	private VideoRepository videoRepo;
	
	@Autowired
	private ProfileRepository profileRepo;
	
	@Autowired
	private ProfileModelDataService service;
	
	@Autowired
	private ProfileServices profileServe;
	
	@Autowired
	private ProfileRegService profileRegService;
	

	
	
	ApiResponse response = new ApiResponse();
	
	
	static LoggingUtils logger = new LoggingUtils(ProfileController.class.getName());
	
	//this has been added by the auth Controller
//	@PostMapping("/save/profile")
//	public ResponseEntity<ProfileModel> ProfileSave(@RequestBody  ProfileModel profilemodel) {
//		
//		System.out.println("======saving the profile controller ======");
//		
//		ProfileModel profile = profileServe.savingProfile(profilemodel);
//		
//		return new ResponseEntity<ProfileModel>(profile , HttpStatus.ACCEPTED);
//	}
	
	@PutMapping("/update/{profileId}/Profile")
	public ResponseEntity<ApiResponse> updateProfile(@Valid @RequestBody ProfileDto profileDto,@PathVariable("profileId")Long profileId)
			throws ParameterException {
		
			System.out.println(profileDto.getPhnNumber());
			
			try {
				Long phnNumber = new Long(profileDto.getPhnNumber());
				boolean status = profileServe.updateExistingProfile(profileDto,profileId);
				if (status == true) {
					response.setMessage("the data has been created ");
					response.setSuccess(true);
					return new ResponseEntity<ApiResponse>(response, HttpStatus.ACCEPTED);
				} else {
					response.setMessage("the data has not been created ");
					response.setSuccess(false);
					return new ResponseEntity<ApiResponse>(response, HttpStatus.BAD_REQUEST);
				}

			} catch (Exception e) {
				response.setMessage("the phon Number is not correct");
				response.setSuccess(false);
				return new ResponseEntity<ApiResponse>(response, HttpStatus.BAD_REQUEST);
			}

			
}
	
	
	
	
	
	
	
//this is need to check 
	@PostMapping("/VideoReuqest")
	public ProfileModel updatingProfileLink(@RequestBody VideoRequest videoRequest) {
		
		System.out.println(videoRequest.getUsername());
		System.out.println(videoRequest.getDescription());
		
		ProfileModel model = new ProfileModel();
		model.setUsernames(videoRequest.getUsername());
		
		System.out.println(model.getUsername());
		
		model=profileRepo.save(model);
		
		System.out.println(model.getProfileId());
		
		List<String> list= videoRequest.getVideourl();
		
		if (list != null) {

			for (String string : list) {
				VideoModel video = new VideoModel();

				video.setVideoUrl(string);
				video.setVideoDescription(videoRequest.getDescription());

				video.setProfilemodel(model);

				video = videoRepo.save(video);
				System.out.println(video.getVideoId());

			}
		
		
		}
		return model;
	}
	
	@GetMapping("/GetAll")
	public List<ProfileModel> gettingall() {
		
		
		return profileRepo.findAll();
		
	}
	
	//this is waste 
	@GetMapping("/Video/profile")
	public List<VideoModel> getAllVideo(){
		
		return videoRepo.findAll();
	}
	
	
	@GetMapping("/VideoForOneProfile")
	@ResponseBody
	public ProfileModel findOne(int profileId) {
		ProfileModel model=	service.profileData(profileId);
		return model;
	
	}
	
	//this is wrong 
	@GetMapping("/profileForOneVideo")
	@ResponseBody
	public VideoModel findOneVideos(int videoId) {
		VideoModel model=	service.videoModelgetting(videoId);
		return model;
	
	}
	
	@DeleteMapping("/{profileId}/delete")
	public String delete(@PathVariable("profileId") int profileId) {
		
		System.out.println("inside the delete");
		return profileRegService.profileDeletion(profileId);
	}
	
	
	
	
//no need as it is in the jwt controler
//	@PostMapping("/saving/Profile")
//	public ResponseEntity<ApiResponse> savingProfile(@Valid @RequestBody ProfileDto profileDto)
//			throws ParameterException {
//		try {
//			Long phnNumber = new Long(profileDto.getPhnNumber());
//			boolean status = profileService.createdNewProfile(profileDto);
//			if (status == true) {
//				response.setMessage("the data has been created ");
//				response.setSuccess(true);
//				return new ResponseEntity<ApiResponse>(response, HttpStatus.CREATED);
//			} else {
//				response.setMessage("the data has not been created ");
//				response.setSuccess(false);
//				return new ResponseEntity<ApiResponse>(response, HttpStatus.BAD_REQUEST);
//			}
//
//		} catch (Exception e) {
//			response.setMessage("the phon Number is not correct");
//			response.setSuccess(false);
//			return new ResponseEntity<ApiResponse>(response, HttpStatus.BAD_REQUEST);
//		}

	


}