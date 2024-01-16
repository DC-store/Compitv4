package com.CompitApplication.VideoServices;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.CompitApplication.Model.InspireVideoModel;
import com.CompitApplication.Repository.InspireVideoRepository;
import com.CompitApplication.Service.AmazonBucketSavingService;

@Transactional
@Service
public class InspireVideoService {

	@Autowired
	private InspireVideoRepository inspireVideoRepo;
	
	
	
	@Autowired
	private AmazonBucketSavingService service;
	
	
	
    public String uploadVideoFile( int id, MultipartFile file) {
        String VideoUrl= service.uploadInspireVideoFile(id,file);
       
        System.out.println("==================== insde the comedy Video Service");
        //upload the video url to the database
       
     	return VideoUrl;
     }
 	
	
	//this is required to get all the detials including 
	public List<InspireVideoModel> fetchAll(){
	
		List<InspireVideoModel> listcreative= inspireVideoRepo.findAll();
		System.out.println("====================inside the comedy Video service fetch all");
		
		Collections.shuffle(listcreative);
		
		return listcreative;
		
	}
	// this is to get all inspire Video 
		public List<Map<String, String>> fetchProfileVideo(int ProfileId){
			
			List<Map<String, String>> list = inspireVideoRepo.fetchVideoUrl(ProfileId);
			
			return list;
			
		}
		
		
		public List<Map<String, String>> fetchAllVideo(){
			
			List<Map<String, String>> list = inspireVideoRepo.fetchAllVideos();
			
			Collections.shuffle(list);
			
			return list;
			
		}
		
		//video Link delete
		
		public String delete(int VideoId) {
			
			
			inspireVideoRepo.deleteById(VideoId);
			
			return "deleted sucessfully";
			
		}
		
}
