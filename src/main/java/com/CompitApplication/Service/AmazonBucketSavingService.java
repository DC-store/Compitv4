package com.CompitApplication.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.CompitApplication.Logger.LoggingUtils;
import com.CompitApplication.Model.ProfileModel;
import com.CompitApplication.Model.VideoModel;
import com.CompitApplication.Repository.ProfileRepository;
import com.CompitApplication.Security.JwtTokenHelper;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AmazonBucketSavingService {
	
	static LoggingUtils logger = new LoggingUtils(AmazonBucketSavingService.class.getName());

	@Value("${application.bucket.name}")
	private String buckteName;
	
	private static final String videoBucketName="compitvideos";
	
	private static final String MusicBucketName="compitmusic";
	
	private static final String DefaultMusicBucketName="compitdefaultmusic";
	// have to make work on the Music Bucket 
	
	@Autowired
	private AmazonS3 s3Client;
	
	@Autowired
	private ProfileRepository profilerepo;
	
	
	@Autowired
	private ProfileRegService profilservice;
	

	
	//chekced its working
	public String uploadFile(int id,MultipartFile file) {
		File fileObj = convertMultiPartFileToFile(file);
		String key= System.currentTimeMillis()+"_"+file.getOriginalFilename();
		
		System.out.println(key);
		//https://compitprofiles.s3.amazonaws.com/1662718394072_sp2.png
		//https://s3.amazonaws.com/compitprofiles/1662720315585_sp2.png
		
		// sending url to profile registration table
		
		
		// have to save this file name in a data base becuase to delete or to update the photo we need to fetch
		//according to the file name and delete the the photo
		
		 s3Client.putObject(new PutObjectRequest(buckteName, key, fileObj));
		
	
		fileObj.delete();
		
		
		System.out.println("=====inside service of the aws profile image upload ===========");
		
		String url= "https://"+buckteName+".s3.amazonaws.com/"+key;
		System.out.println(url);
		profilservice.UploadPhotoUrl(id,url);
		return url;
	}
	
	//===========================================================================================
	//video upload 
	public VideoModel uploadVideoFile(long id,MultipartFile file) {
		File fileObj = convertMultiPartFileToFile(file);
		String key= System.currentTimeMillis()+"_"+file.getOriginalFilename();
		
		System.out.println(key);
		//https://compitprofiles.s3.amazonaws.com/1662718394072_sp2.png
		//https://s3.amazonaws.com/compitprofiles/1662720315585_sp2.png
		//String url= "https://"+buckteName+".s3.amazonaws.com/"+key;
		

		
		// have to save this file name in a data base becuase to delete or to update the photo we need to fetch
		//according to the file name and delete the the photo
		System.out.println("======inside the service of the dance video upload======");
		PutObjectResult result= s3Client.putObject(new PutObjectRequest(videoBucketName, key, fileObj));
		System.out.println(result);
		
	
		fileObj.delete();
		if(result!=null) {
		String url= "https://"+videoBucketName+".s3.amazonaws.com/"+key;
		System.out.println("uploading the dance video url ");
		VideoModel model =profilservice.findProfile(id,url);
		
		
		System.out.println(url);
	
		return  model;
		}
		else {

		return  null;
		}
	}
 
///upload the comedy video 
	public String uploadComedyVideoFile(int id,MultipartFile file) {
		File fileObj = convertMultiPartFileToFile(file);
		String key= System.currentTimeMillis()+"_"+file.getOriginalFilename();
		System.out.println("==inside the comedy Video amazon Service ");
		System.out.println(key);
		//https://compitprofiles.s3.amazonaws.com/1662718394072_sp2.png
		//https://s3.amazonaws.com/compitprofiles/1662720315585_sp2.png
		//String url= "https://"+buckteName+".s3.amazonaws.com/"+key;
		

		
		// have to save this file name in a data base becuase to delete or to update the photo we need to fetch
		//according to the file name and delete the the photo
		System.out.println("======inside the service of the comedy video upload======");
		PutObjectResult result= s3Client.putObject(new PutObjectRequest(videoBucketName, key, fileObj));
		System.out.println(result);
		
	
		fileObj.delete();
		if(result!=null) {
		String url= "https://"+videoBucketName+".s3.amazonaws.com/"+key;
		ProfileModel model =profilservice.findComedyProfile(id,url);
		System.out.println(model.getUsername());
		System.out.println(url);
	
		return  url;
		}
		else {

		return  "not uploaded";}
	}
	
	
	//================================================================================================
//uploadCreative Video url in creative Video Tables 	
	public String uploadCreativeVideoFile(int id,MultipartFile file) {
		File fileObj = convertMultiPartFileToFile(file);
		String key= System.currentTimeMillis()+"_"+file.getOriginalFilename();
		System.out.println("==inside the comedy Video amazon Service ");
		System.out.println(key);
		//https://compitprofiles.s3.amazonaws.com/1662718394072_sp2.png
		//https://s3.amazonaws.com/compitprofiles/1662720315585_sp2.png
		//String url= "https://"+buckteName+".s3.amazonaws.com/"+key;
		

		
		// have to save this file name in a data base becuase to delete or to update the photo we need to fetch
		//according to the file name and delete the the photo
		System.out.println("======inside the service of the Creative video upload======");
		PutObjectResult result= s3Client.putObject(new PutObjectRequest(videoBucketName, key, fileObj));
		System.out.println(result);
		
	
		fileObj.delete();
		if(result!=null) {
		String url= "https://"+videoBucketName+".s3.amazonaws.com/"+key;
		ProfileModel model =profilservice.findCreativeProfile(id,url);
		System.out.println(model.getUsername());
		System.out.println(url);
	
		return  url;
		}
		else {

		return  "not uploaded";}
	}
	
	
	//================================================================================================
	//
	public String uploadInspireVideoFile(int id,MultipartFile file) {
		File fileObj = convertMultiPartFileToFile(file);
		String key= System.currentTimeMillis()+"_"+file.getOriginalFilename();
		System.out.println("==inside the comedy Video amazon Service ");
		System.out.println(key);
		//https://compitprofiles.s3.amazonaws.com/1662718394072_sp2.png
		//https://s3.amazonaws.com/compitprofiles/1662720315585_sp2.png
		//String url= "https://"+buckteName+".s3.amazonaws.com/"+key;
		

		
		// have to save this file name in a data base becuase to delete or to update the photo we need to fetch
		//according to the file name and delete the the photo
		System.out.println("======inside the service of the inspire video aws upload======");
		PutObjectResult result= s3Client.putObject(new PutObjectRequest(videoBucketName, key, fileObj));
		System.out.println(result);
		
	
		fileObj.delete();
		if(result!=null) {
		String url= "https://"+videoBucketName+".s3.amazonaws.com/"+key;
		ProfileModel model =profilservice.findInspireProfile(id,url);
		System.out.println(model.getUsername());
		System.out.println(url);
	
		return  url;
		}
		else {

		return  "not uploaded";}
	}
//============================================================================	
	public String uploadReelsVideoFile(int id,MultipartFile file) {
		File fileObj = convertMultiPartFileToFile(file);
		String key= System.currentTimeMillis()+"_"+file.getOriginalFilename();
		System.out.println("==inside the comedy Video amazon Service ");
		System.out.println(key);
		//https://compitprofiles.s3.amazonaws.com/1662718394072_sp2.png
		//https://s3.amazonaws.com/compitprofiles/1662720315585_sp2.png
		//String url= "https://"+buckteName+".s3.amazonaws.com/"+key;
		

		
		// have to save this file name in a data base becuase to delete or to update the photo we need to fetch
		//according to the file name and delete the the photo
		System.out.println("======inside the service of the reels video aws upload======");
		PutObjectResult result= s3Client.putObject(new PutObjectRequest(videoBucketName, key, fileObj));
		System.out.println(result);
		
	
		fileObj.delete();
		if(result!=null) {
		String url= "https://"+videoBucketName+".s3.amazonaws.com/"+key;
		ProfileModel model =profilservice.findReelsProfile(id,url);
		System.out.println(model.getUsername());
		System.out.println(url);
	
		return  url;
		}
		else {

		return  "not uploaded";}
	}
	
	//================================================================================================
		//
		public String uploadMusicVideoFile(int id,MultipartFile file) {
			File fileObj = convertMultiPartFileToFile(file);
			String key= System.currentTimeMillis()+"_"+file.getOriginalFilename();
			System.out.println("==inside the comedy Video amazon Service ");
			System.out.println(key);
			//https://compitprofiles.s3.amazonaws.com/1662718394072_sp2.png
			//https://s3.amazonaws.com/compitprofiles/1662720315585_sp2.png
			//String url= "https://"+buckteName+".s3.amazonaws.com/"+key;
			

			
			// have to save this file name in a data base becuase to delete or to update the photo we need to fetch
			//according to the file name and delete the the photo
			System.out.println("======inside the service of the inspire video upload======");
			PutObjectResult result= s3Client.putObject(new PutObjectRequest(videoBucketName, key, fileObj));
			System.out.println(result);
			
		
			fileObj.delete();
			if(result!=null) {
			String url= "https://"+videoBucketName+".s3.amazonaws.com/"+key;
			ProfileModel model =profilservice.findMusicProfile(id,url);
			System.out.println(model.getUsername());
			System.out.println(url);
		
			return  url;
			}
			else {

			return  "not uploaded";}
		}
	//============================================================================	
		
		//
		public String uploadSingingVideoFile(int id,MultipartFile file) {
			File fileObj = convertMultiPartFileToFile(file);
			String key= System.currentTimeMillis()+"_"+file.getOriginalFilename();
			System.out.println("==inside the comedy Video amazon Service ");
			System.out.println(key);
			//https://compitprofiles.s3.amazonaws.com/1662718394072_sp2.png
			//https://s3.amazonaws.com/compitprofiles/1662720315585_sp2.png
			//String url= "https://"+buckteName+".s3.amazonaws.com/"+key;
			

			
			// have to save this file name in a data base becuase to delete or to update the photo we need to fetch
			//according to the file name and delete the the photo
			System.out.println("======inside the service of the Singing video aws upload======");
			PutObjectResult result= s3Client.putObject(new PutObjectRequest(videoBucketName, key, fileObj));
			System.out.println(result);
			
		
			fileObj.delete();
			if(result!=null) {
			String url= "https://"+videoBucketName+".s3.amazonaws.com/"+key;
			ProfileModel model =profilservice.findSingingProfile(id,url);
			System.out.println(model.getUsername());
			System.out.println(url);
		
			return  url;
			}
			else {

			return  "not uploaded";}
		}
	//============================================================================	
		public String uploadSong(MultipartFile file) {
			File fileObj = convertMultiPartFileToFile(file);
			String key= System.currentTimeMillis()+"_"+file.getOriginalFilename();
			
			System.out.println(key);
			//https://compitprofiles.s3.amazonaws.com/1662718394072_sp2.png
			//https://s3.amazonaws.com/compitprofiles/1662720315585_sp2.png
			//String url= "https://"+buckteName+".s3.amazonaws.com/"+key;
			

			
			// have to save this file name in a data base becuase to delete or to update the photo we need to fetch
			//according to the file name and delete the the photo
			System.out.println("======inside the service of the Song Upload ======");
			PutObjectResult result= s3Client.putObject(new PutObjectRequest(MusicBucketName, key, fileObj));
			System.out.println(result);
			
		
			fileObj.delete();
			if(result!=null) {
			String url= "https://"+MusicBucketName+".s3.amazonaws.com/"+key;
			
			
		
			return  url;
			}
			else {

			return  "not uploaded";}
		}
		
		// default Sound 
		public String uploadDefaultSound(MultipartFile file) {
			File fileObj = convertMultiPartFileToFile(file);
			String key= System.currentTimeMillis()+"_"+file.getOriginalFilename();
			
			System.out.println(key);
			//https://compitprofiles.s3.amazonaws.com/1662718394072_sp2.png
			//https://s3.amazonaws.com/compitprofiles/1662720315585_sp2.png
			//String url= "https://"+buckteName+".s3.amazonaws.com/"+key;
			

			
			// have to save this file name in a data base becuase to delete or to update the photo we need to fetch
			//according to the file name and delete the the photo
			System.out.println("======inside the service of the Song Upload ======");
			PutObjectResult result= s3Client.putObject(new PutObjectRequest(DefaultMusicBucketName, key, fileObj));
			System.out.println(result);
			
		
			fileObj.delete();
			if(result!=null) {
			String url= "https://"+DefaultMusicBucketName+".s3.amazonaws.com/"+key;
	
			return  url;
			}
			else {

			return  "Struck with uplaoding the music url";}
		}
		
	//delete the file 
	public String deleteFile(String filename) {
		s3Client.deleteObject(buckteName,filename);
		return "you deleted the file "+filename;
	}
	
	
	// if download you need to download the file 
	
	
	

	// this have to understand what is the meaning of converting the file to file
	private File convertMultiPartFileToFile(MultipartFile file) {
		File convertedFile = new File(file.getOriginalFilename());
		try (FileOutputStream fos= new FileOutputStream(convertedFile)){
			
			fos.write(file.getBytes());
			
		} catch (IOException e) {
				System.err.printf("Error converting multipart file to file",e);
		}
		return convertedFile;
	}
	
	
	// if download you need to download the file
	public byte[] downLoadFile(String filename) throws IOException{
		com.amazonaws.services.s3.model.S3Object sObject = s3Client.getObject(buckteName, filename);
		S3ObjectInputStream inputStream = sObject.getObjectContent();
		
		
	
			byte[] content = IOUtils.toByteArray(inputStream);
		
		
		return content;
	}
	
	
	
	
}
