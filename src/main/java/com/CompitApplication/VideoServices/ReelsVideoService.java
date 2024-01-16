package com.CompitApplication.VideoServices;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.CompitApplication.Model.InspireVideoModel;
import com.CompitApplication.Model.ReelsVideoModel;
import com.CompitApplication.Repository.InspireVideoRepository;
import com.CompitApplication.Repository.ReelsVideoRepository;
import com.CompitApplication.Service.AmazonBucketSavingService;

@Transactional
@Service
public class ReelsVideoService {

	
	@Autowired
	private ReelsVideoRepository reelsVideoRepo;
	
	
	
	@Autowired
	private AmazonBucketSavingService service;
	
	
    public String uploadVideoFile( int id, MultipartFile file) {
        String VideoUrl= service.uploadReelsVideoFile(id,file);
       
        System.out.println("==================== inside  the Reels Video Service");
        //upload the video url to the database
       
     	return VideoUrl;
     }
 	
	
	//this is required to get all the detials including 
	public List<ReelsVideoModel> fetchAll(){
	
		List<ReelsVideoModel> listcreative= reelsVideoRepo.findAll();
		System.out.println("====================inside the comedy Video service fetch all");
		
		Collections.shuffle(listcreative);
		
		return listcreative;
		
	}
	// this is to get all inspire Video 
		public List<Map<String, String>> fetchProfileVideo(int ProfileId){
			
			List<Map<String, String>> list = reelsVideoRepo.fetchVideoUrl(ProfileId);
			
			return list;
			
		}
		
		
		public List<Map<String, String>> fetchAllVideo(){
			
			List<Map<String, String>> list = reelsVideoRepo.fetchAllVideos();
			
			Collections.shuffle(list);
			
			return list;
			
		}
		
		//video Link delete
		
		public String delete(int VideoId) {
			
			
			reelsVideoRepo.deleteById(VideoId);
			
			return "deleted sucessfully";
			
		}
	
	
}
