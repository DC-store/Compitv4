package com.CompitApplication.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.CompitApplication.Logger.LoggingUtils;
import com.CompitApplication.Service.AmazonBucketSavingService;
import com.CompitApplication.VideoServices.CreativeVideoService;

@RestController
@RequestMapping("/api/v1/CreativeVideo")
public class CreativeVideoUrlController {

	
	@Autowired 
	private CreativeVideoService creativeVideoSevre;
	
	
	
	static LoggingUtils logger = new LoggingUtils(CreativeVideoUrlController.class.getName());
	
	 @PostMapping("/uploadvideo/{Profileid}") 
	  public ResponseEntity<String> uploadVideo(@PathVariable("Profileid") int id,@RequestParam(value = "file") MultipartFile file) {
		 
		 	System.out.println("=============== inside the video Upload============");
	        return new ResponseEntity<>(creativeVideoSevre.uploadVideoFile(id,file), HttpStatus.OK);
	    }
	 
	 @GetMapping("/getAllVideo")
		public List<Map<String, String>> fetchAll(){
			
			
			 System.out.println("===== inside all Creative videos  fetching =====");
			 List<Map<String, String>> VideoUrl= creativeVideoSevre.fetchAllVideo();
			 
			 
			return  VideoUrl;
		
		}
	 
	 @GetMapping("/fetch/{profileId}/Video")
	 public List<Map<String, String>> fetchVideo(@PathVariable("profileId") int profileId){
		 System.out.println("====fetching videos as per the profile ========= ");
		return  creativeVideoSevre.fetchProfileVideo(profileId);
	 }
	 
	 
		@DeleteMapping("/{VideoId}/delete")
		public String deletevideo(@PathVariable("VideoId") int VideoId) {

			return creativeVideoSevre.delete(VideoId);
		}
	
}
