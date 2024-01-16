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
import com.CompitApplication.Model.VideoModel;
import com.CompitApplication.Repository.ProfileRepository;
import com.CompitApplication.VideoServices.VideoService;

@RestController
@RequestMapping("/api/v1/DanceVideo")
public class VideoUrlController {
	
	
	static LoggingUtils logger = new LoggingUtils(VideoUrlController.class.getName());

	@Autowired
	private	VideoService videoServe;
	
	 @PostMapping("/uploadDancevideo/{Profileid}") 
	  public ResponseEntity<String> uploadVideo(@PathVariable("Profileid") long id,@RequestParam(value = "file") MultipartFile file) {
		 
		 	System.out.println("=============== inside the video Upload============");
	        return new ResponseEntity(videoServe.uploadVideoFile(id,file), HttpStatus.OK);
	    }
	 
	 @PostMapping("/uploadVideoDescription/{profileId}")
	 public String VideoPropUpdate(@PathVariable("profileId")  int profileId , VideoModel videoModel) {
		 
		 videoServe.UploadVideoProp(profileId, videoModel);
		 return null;
	 }
	 
	 
// getting video as per the profile id	 
	 @GetMapping("/fetch/{profileId}/DanceVideo")
	 public List<String> fetchVideo(@PathVariable("profileId") int profileId){
		 System.out.println("====fetching videos as per the profile ========= ");
		return  videoServe.fetchingVideos(profileId);
	 }
	 
	 @GetMapping("/fetchAllVideo")
	 public List<String> fetchAllVideos(){
		 System.out.println("===== inside all videos fetching =====");
		 List<String> VideoUrl= videoServe.fetchAllVideos();
		 return VideoUrl;
		 
	 }
	 
	 
	 @GetMapping("/fetchVideoModel")
	 public List<VideoModel> getAlldata(){
		 
		 
		 return videoServe.fetchFullVideoList();
	 }
	 
	 
	 @GetMapping("/VideoMap")
	 public List<Map<String, String>> getAllVideos(){
		 
		 
		 return videoServe.getingVideoJson();
	 }
	 
	 
	 @DeleteMapping("/delete/{videoid}/video")
	 public String deleteVideo(@PathVariable("videoid")   int videoid) {
		 
		 return videoServe.deleteVideoRepo(videoid);
	 }
	
	 
	 
}
