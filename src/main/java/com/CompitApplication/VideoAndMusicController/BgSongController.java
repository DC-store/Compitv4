package com.CompitApplication.VideoAndMusicController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.CompitApplication.Model.VideoModel;
import com.CompitApplication.VideoUploadService.BgSongVideoUploadService;

@RestController
@RequestMapping("/api/v1/BgSongController")
public class BgSongController {

	@Autowired
	private BgSongVideoUploadService bgSongUploadService;
	
	//
	
	
	@PostMapping("/videoUpload/{profileId}/saveVideo")
	public ResponseEntity<VideoModel> uploadMashedVideo(@Nullable @RequestParam("musicId") long musicId,
			@RequestParam("videoFile") MultipartFile videoFile,
			@PathVariable("profileId")  int profileId,
			@Nullable @RequestParam("musicFile")  MultipartFile musicFile){
		
		VideoModel model= bgSongUploadService.uploadVideo(musicId, videoFile, profileId, musicFile);
		
		return new ResponseEntity<VideoModel>(model,HttpStatus.CREATED); 
		
	}
}
