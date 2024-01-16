package com.CompitApplication.VideoServices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.CompitApplication.Model.ComedyVideoModel;
import com.CompitApplication.Repository.ComedyVideoRepository;
import com.CompitApplication.Service.AmazonBucketSavingService;

@Transactional
@Service
public class ComedyVideoService {
	
	
	@Autowired
	private ComedyVideoRepository comedyVideoRepo;
	
	
	
	@Autowired
	private AmazonBucketSavingService service;
	
	
	
    public String uploadVideoFile( int id, MultipartFile file) {
        String VideoUrl= service.uploadComedyVideoFile(id,file);
       
        System.out.println("==================== insde the comedy Video Service");
        //upload the video url to the database
       
     	return null;
     }
 	
	
	
	public List<ComedyVideoModel> fetchAll(){
	
		List<ComedyVideoModel> listcomedy= comedyVideoRepo.findAll();
		System.out.println("====================inside the comedy Video service fetch all");
		
		Collections.shuffle(listcomedy);
		
		return listcomedy;
		
	}
	
		public List<Map<String, String>> fetchProfileVideo(int ProfileId){
			
			List<Map<String, String>> list = comedyVideoRepo.fetchVideoUrl(ProfileId);
			
			return list;
			
		}
		
		
		public List<Map<String, String>> fetchAllVideo(){
			
			List<Map<String, String>> list = comedyVideoRepo.fetchAllVideos();
			
			Collections.shuffle(list);
			
			return list;
			
		}
		
		//video Link 
		
		public String delete(int VideoId) {
			
			
			comedyVideoRepo.deleteById(VideoId);
			
			return "deleted sucessfully";
			
		}
		
		
		
		
	}

	
	


