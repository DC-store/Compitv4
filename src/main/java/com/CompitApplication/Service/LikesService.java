package com.CompitApplication.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.CompitApplication.Logger.LoggingUtils;
import com.CompitApplication.Model.LikesModel;
import com.CompitApplication.Model.ProfileModel;
import com.CompitApplication.Model.VideoModel;
import com.CompitApplication.Repository.LikesRepository;




@Transactional
@Service
public class LikesService {

	@Autowired
	private LikesRepository likesRepo;
	
	static LoggingUtils logger = new LoggingUtils(LikesService.class.getName());
	
	
	public String LikesSave(int VideoPostId, int UserId ) {
		
		Integer likeId= likesRepo.VerifyingLikes(VideoPostId, UserId);
		
		System.out.println("like id ===="+likeId);
		ProfileModel profile= new ProfileModel();
		profile.setProfileId(UserId);
		
		
		VideoModel video= new VideoModel();
		video.setVideoId(VideoPostId);
		
		if(likeId==null){
		LikesModel likeModel= new LikesModel();
		likeModel.setVideoPostId(VideoPostId);
		likeModel.setUserId(UserId);
		likeModel.setLprofileId(profile);
		likeModel.setLvideoId(video);
		
		likesRepo.save(likeModel);
		}
		else
		{
			// have to make unlike the like.... have to check 
			likesRepo.deleteById(likeId);
		}
		return null;
	}
	
	public void findingCount(int VideoPostId) {
		
		Integer count= likesRepo.countingLikes(VideoPostId);
		System.out.println(count);
		
	}
	
	public void deleteLikes(int id) {
		
		List<LikesModel> list= new ArrayList<>();
		list= likesRepo.deletingLikes(id);
		likesRepo.deleteAllInBatch(list);
		
		
	}
	
	
	
	
	
}
