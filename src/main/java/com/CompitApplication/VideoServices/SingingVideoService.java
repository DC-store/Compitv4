package com.CompitApplication.VideoServices;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.CompitApplication.Model.InspireVideoModel;
import com.CompitApplication.Model.SingingVideoModel;
import com.CompitApplication.Repository.InspireVideoRepository;
import com.CompitApplication.Repository.SingingVideoRepository;
import com.CompitApplication.Service.AmazonBucketSavingService;

@Transactional
@Service
public class SingingVideoService {

	@Autowired
	private SingingVideoRepository singVideoRepo;
	
	
	
	@Autowired
	private AmazonBucketSavingService service;
	
	public String uploadVideoFile( int id, MultipartFile file) {
        String VideoUrl= service.uploadSingingVideoFile(id,file);
       
        System.out.println("==================== insde the comedy Video Service");
        //upload the video url to the database
       
     	return VideoUrl;
     }
 	
	
	//this is required to get all the detials including 
	public List<SingingVideoModel> fetchAll(){
	
		List<SingingVideoModel> listcreative= singVideoRepo.findAll();
		System.out.println("====================inside the Singing Video service fetch all");
		
		Collections.shuffle(listcreative);
		
		return listcreative;
		
	}
	// this is to get all inspire Video 
		public List<Map<String, String>> fetchProfileVideo(int ProfileId){
			
			List<Map<String, String>> list = singVideoRepo.fetchVideoUrl(ProfileId);
			
			return list;
			
		}
		
		
		public List<Map<String, String>> fetchAllVideo(){
			
			List<Map<String, String>> list = singVideoRepo.fetchAllVideos();
			
			Collections.shuffle(list);
			
			return list;
			
		}
		
		//video Link delete
		
		public String delete(int VideoId) {
			
			
			singVideoRepo.deleteById(VideoId);
			
			return "deleted sucessfully";
			
		}
	
	
	
}
