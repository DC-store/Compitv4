package com.CompitApplication.BgSoundService;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.CompitApplication.CompitApplication;
import com.CompitApplication.BgMusicModel.BgSongsModel;
import com.CompitApplication.Repository.BgSongsVideoRepository;
import com.CompitApplication.Service.AmazonBucketSavingService;

@Service
public class BgSongsService {
	
	public static Logger logger = Logger.getLogger(BgSongsService.class.getName());
	//TODO have to create service for all  the bg music 
	
	@Autowired
	private BgSongsVideoRepository bgSongRepository;
	
	@Autowired
	private AmazonBucketSavingService amazonService;
	
	
	
	
	public String SongsUpload(List<MultipartFile> fileList) {
		try {
		BgSongsModel bgSongsVideoModel= new BgSongsModel();
		logger.info("created the Bg Songs Model Object");
		for (MultipartFile multipartFile : fileList) {

			String songUrl= amazonService.uploadSong(multipartFile); 
			if(songUrl!=null) {
				logger.info("the background music is null so putting the song url to the repository and sending the song to amazon bucket");
				String songName =multipartFile.getOriginalFilename();
				bgSongsVideoModel.setBgSongUrl(songUrl);
				bgSongsVideoModel.setBgSongName(songName);
				// have to look about the images upload for a particular song
				
			}
			
			
		}
		logger.info("saving the url to the repository");
		 bgSongRepository.save(bgSongsVideoModel);
		logger.info("song has been saved to the repository");
		}
		catch (IllegalArgumentException e) {
			e.printStackTrace();
			logger.throwing("BgSongsService class", "doing the repository save method but failed ", e);
		}
		logger.info("the save operation is succesfull");
		return "uploaded successfully";
	}
	
}
