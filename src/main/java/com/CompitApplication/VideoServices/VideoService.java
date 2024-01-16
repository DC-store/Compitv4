package com.CompitApplication.VideoServices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.CompitApplication.Model.ProfileModel;
import com.CompitApplication.Model.VideoModel;
import com.CompitApplication.Repository.ProfileRepository;
import com.CompitApplication.Repository.VideoRepository;
import com.CompitApplication.Service.AmazonBucketSavingService;
import com.CompitApplication.Service.LikesService;

@Transactional
@Service
public class VideoService {
	
	@Autowired
	private VideoRepository videoRepo;
	
	@Autowired
	private LikesService likeServe;
	
	@Autowired
	private ProfileRepository profileRepo;
	
	/*@Autowired
	private ProfileRegService profileService;*/
	
	
	@Autowired
	private AmazonBucketSavingService service;
	
	//VIDEO UPLOAD TO THE CLOUD
    public VideoModel uploadVideoFile( long id, MultipartFile file) {
        
      
       System.out.println("====================");
       //upload the video url to the database
      System.out.println("extracted taking video from the mashed up video ");
    	return service.uploadVideoFile(id,file);
    }
	
///dont know
	public String UploadVideoProp(long ProfileId,VideoModel videoModel) {
		ProfileModel model = profileRepo.getById(ProfileId);
		VideoModel vmodel= new VideoModel();
		vmodel.setProfilemodel(model);
		vmodel.setVideoDescription(videoModel.getVideoDescription());
		vmodel.setVideoName(videoModel.getVideoName());
		
		videoRepo.save(vmodel);
		
		
		return "success";
	}
	
	//find videos for particular id .......... in profile Model
	public List<String> fetchingVideos(int profileId){
		
		return videoRepo.fetchVideoUrl(profileId);
	}
	
	//find the videos for home page .......
	public List<String> fetchAllVideos(){
		
		return videoRepo.fetchAllVideos();
	}
	
	
	public List<VideoModel> fetchFullVideoList(){
	
		List<VideoModel> list = videoRepo.findAll();
		
		 Collections.shuffle(list);
		
		return list;
	}
	
	
	// delete the video based on the video id
	public String deleteVideoRepo(int VideoId) {
		
		videoRepo.deleteById(VideoId);
		
		return "sucessfully deleted";
	}

	public List<Map<String, String>> getingVideoJson() {
		
		return videoRepo.fetchAllVideosJson();
	}
}
