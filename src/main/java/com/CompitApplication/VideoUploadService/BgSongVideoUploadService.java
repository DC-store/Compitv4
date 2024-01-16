package com.CompitApplication.VideoUploadService;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.CompitApplication.BgMusicModel.BgSongsModel;
import com.CompitApplication.BgMusicModel.DefaultMusicModel;
import com.CompitApplication.Model.VideoModel;
import com.CompitApplication.Repository.BgSongsVideoRepository;
import com.CompitApplication.Repository.DefaultMusicRepository;
import com.CompitApplication.Repository.VideoRepository;
import com.CompitApplication.Service.AmazonBucketSavingService;
import com.CompitApplication.VideoServices.VideoService;

@Transactional
@Service
public class BgSongVideoUploadService {

	@Autowired
	private BgSongsVideoRepository bgSongsVideoRepository;
	
	@Autowired
	private VideoService videoService;
	
	@Autowired
	private VideoRepository videoRepository;
	
	@Autowired
	private AmazonBucketSavingService bucketService;
	
	@Autowired
	private DefaultMusicRepository defMusicRepository;
	
	
	// videoFile is compulsory, //muiscId is nullable, //musicFile is nullable
	public VideoModel uploadVideo(long musicId, MultipartFile videoFile,int profileId,MultipartFile musicFile) {
		VideoModel model= null;
		
		if(musicId!=0) {
			//==============================================================//
			//if it is getting the music.
	
			/*List<VideoModel> list = new ArrayList<>();
			VideoModel model = videoService.uploadVideoFile(profileId, videoFile);
			list.add(model);
			bgSongsVideoModel.setDanceVideoList(list);
			// will it work or not i dont know*/
			//=======================================================//
			
			BgSongsModel bgSongsVideoModel= bgSongsVideoRepository.findByBgSongId(musicId);
			bgSongsVideoModel.getBgSongUrl();
			model= videoService.uploadVideoFile(profileId, videoFile);
			model.setBgSongsVideoModel(bgSongsVideoModel);
			model = videoRepository.save(model);
			
		}
		if(musicId==0) {
			DefaultMusicModel musicModel= new  DefaultMusicModel();
			String url =bucketService.uploadDefaultSound(musicFile);
			
			musicModel.setDefMusicUrl(url);
			musicModel.setDefMusicName(musicFile.getOriginalFilename());
			// have to set default image url
			musicModel=  defMusicRepository.save(musicModel);
		    model= videoService.uploadVideoFile(profileId, videoFile);
			model.setDanceVideoDefaultMusicModel(musicModel);;
			model = videoRepository.save(model);
		
		}
		
		return model;
	}
}
