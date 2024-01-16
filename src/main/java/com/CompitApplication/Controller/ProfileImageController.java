package com.CompitApplication.Controller;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.CompitApplication.Logger.LoggingUtils;
import com.CompitApplication.Service.AmazonBucketSavingService;
import com.CompitApplication.Service.ProfileRegService;



//putting image opject to aws sever using root api key and password....
// have to change to IAM user to after launch of the application....(important)
@RestController
@Controller
@RequestMapping("/api/v1/profileImage")
public class ProfileImageController {
	
	
	static LoggingUtils logger = new LoggingUtils(ProfileImageController.class.getName());

	@Autowired
	private AmazonBucketSavingService service;
	
	@Autowired
	private ProfileRegService profileRegService;
	
	@PostMapping("/SaveProfileImage/{profileId}")
    public ResponseEntity<String> uploadImageFile(@PathVariable int profileId,@RequestParam(value = "file") MultipartFile file) {
        System.out.println("=======inside profile image upload=======");
		
		return new ResponseEntity<>(service.uploadFile(profileId,file), HttpStatus.OK);
    }
	
	@PutMapping("/UpdateProfileImage/{profileId}")
    public ResponseEntity<String> updateImageFile(@PathVariable int profileId,@RequestParam(value = "file") MultipartFile file) {
        System.out.println("=======inside profile image upload=======");
		
		return new ResponseEntity<>(service.uploadFile(profileId,file), HttpStatus.OK);
    }
	
	@DeleteMapping("/deleteProfileImage/{profileId}")
	public ResponseEntity<String> deleteImage(@PathVariable int profileId){
		System.out.println("=======delete the profile image");
		
		return new ResponseEntity<String>(profileRegService.deleteProfileImage(profileId), HttpStatus.GONE);
	}
	
	
	
	

	 @GetMapping("/download/{fileName}")
	    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) throws IOException {
	        byte[] data = service.downLoadFile(fileName);
	        ByteArrayResource resource = new ByteArrayResource(data);
	        return ResponseEntity
	                .ok()
	                .contentLength(data.length)
	                .header("Content-type", "application/octet-stream")
	                .header("Content-disposition", "attachment; filename=\"" + fileName + "\"")
	                .body(resource);
	    }
	 // this is for testing not a original api 
	 @PostMapping("/uploadvideo/{id}") 
	  public ResponseEntity<String> uploadVideo(@PathVariable int id,@RequestParam(value = "file") MultipartFile file) {
	        return new ResponseEntity<>(service.uploadFile(id,file), HttpStatus.OK);
	    }
	 
	 // this is to delete the file inside the amazon web service
	 @DeleteMapping("/delete/{fileName}")
	    public ResponseEntity<String> deleteFile(@PathVariable String fileName) {
	        return new ResponseEntity<>(service.deleteFile(fileName), HttpStatus.OK);
	    }
		
}
