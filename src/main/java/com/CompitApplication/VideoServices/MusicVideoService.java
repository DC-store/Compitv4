package com.CompitApplication.VideoServices;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.CompitApplication.Model.InspireVideoModel;
import com.CompitApplication.Model.MusicVideoModel;
import com.CompitApplication.Repository.InspireVideoRepository;
import com.CompitApplication.Repository.MusicVideoRepository;
import com.CompitApplication.Service.AmazonBucketSavingService;

@Transactional
@Service
public class MusicVideoService {

	
	@Autowired
	private MusicVideoRepository MusicVideoRepo;
	
	
	
	@Autowired
	private AmazonBucketSavingService service;
	
	public String uploadVideoFile( int id, MultipartFile file) {
        String VideoUrl= service.uploadMusicVideoFile(id,file);
       
        System.out.println("==================== insde the comedy Video Service");
        //upload the video url to the database
       
     	return null;
     }
 	
	
	//this is required to get all the detials including 
	public List<MusicVideoModel> fetchAll(){
	
		List<MusicVideoModel> listcreative= MusicVideoRepo.findAll();
		System.out.println("====================inside the comedy Video service fetch all");
		
		Collections.shuffle(listcreative);
		
		return listcreative;
		
	}
	// this is to get all inspire Video 
		public List<Map<String, String>> fetchProfileVideo(int ProfileId){
			
			List<Map<String, String>> list = MusicVideoRepo.fetchVideoUrl(ProfileId);
			
			return list;
			
		}
		
		
		public List<Map<String, String>> fetchAllVideo(){
			
			List<Map<String, String>> list = MusicVideoRepo.fetchAllVideos();
			
			Collections.shuffle(list);
			
			return list;
			
		}
		
		//video Link delete
		
		public String delete(int VideoId) {
			
			
			MusicVideoRepo.deleteById(VideoId);
			
			return "deleted sucessfully";
			
		}
	
	
}
