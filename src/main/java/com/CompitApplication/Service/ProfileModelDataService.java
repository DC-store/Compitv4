package com.CompitApplication.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CompitApplication.Logger.LoggingUtils;
import com.CompitApplication.Model.ProfileModel;
import com.CompitApplication.Model.VideoModel;
import com.CompitApplication.Repository.ProfileRepository;
import com.CompitApplication.Repository.VideoRepository;



@Transactional
@Service
public class ProfileModelDataService {

	static LoggingUtils logger = new LoggingUtils(ProfileModelDataService.class.getName());
	
	@Autowired
	private ProfileRepository profileRepo;
	
	
	@Autowired
	private VideoRepository videoRepo;
	
	public ProfileModel profileData(int profileId) {
		ProfileModel model = profileRepo.findByProfileId(profileId);
	
		return model;
		
	}
	
	public VideoModel videoModelgetting(int VideoId) {
		
		VideoModel model = videoRepo.findByVideoId(VideoId);
		
		return model;
				
				
	}
	
	
}