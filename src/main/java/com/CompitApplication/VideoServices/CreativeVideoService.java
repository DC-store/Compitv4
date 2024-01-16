package com.CompitApplication.VideoServices;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.CompitApplication.Model.ComedyVideoModel;
import com.CompitApplication.Model.CreativeVideoModel;
import com.CompitApplication.Repository.ComedyVideoRepository;
import com.CompitApplication.Repository.CreativeVideoRepository;
import com.CompitApplication.Service.AmazonBucketSavingService;

@Transactional
@Service
public class CreativeVideoService {

	

	@Autowired
	private CreativeVideoRepository creativeVideoRepo;
	
	
	
	@Autowired
	private AmazonBucketSavingService service;
	
	
	
    public String uploadVideoFile( int id, MultipartFile file) {
        String VideoUrl= service.uploadCreativeVideoFile(id,file);
       
        System.out.println("==================== insde the comedy Video Service");
        //upload the video url to the database
       
     	return null;
     }
 	
	
	
	public List<CreativeVideoModel> fetchAll(){
	
		List<CreativeVideoModel> listcreative= creativeVideoRepo.findAll();
		System.out.println("====================inside the comedy Video service fetch all");
		
		Collections.shuffle(listcreative);
		
		return listcreative;
		
	}
	
		public List<Map<String, String>> fetchProfileVideo(int ProfileId){
			
			List<Map<String, String>> list = creativeVideoRepo.fetchVideoUrl(ProfileId);
			
			return list;
			
		}
		
		
		public List<Map<String, String>> fetchAllVideo(){
			
			List<Map<String, String>> list = creativeVideoRepo.fetchAllVideos();
			
			Collections.shuffle(list);
			
			return list;
			
		}
		
		//video Link delete
		
		public String delete(int VideoId) {
			
			
			creativeVideoRepo.deleteById(VideoId);
			
			return "deleted sucessfully";
			
		}
		
		
}
