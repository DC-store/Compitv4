package com.CompitApplication.Repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CompitApplication.Model.VideoModel;

@Repository
public interface VideoRepository extends JpaRepository<VideoModel, Integer> {

	public VideoModel findByVideoId(int videoId);
	
	@Query(value = "SELECT video_url FROM video_model_table WHERE profile_id = :profileId  ;  ", nativeQuery = true)
	public List<String> fetchVideoUrl(@Param("profileId") int profileId);

	@Query(value = "SELECT video_url,video_description FROM video_model_table  ; ", nativeQuery = true)
	public List<String> fetchAllVideos();
	
	
	@Query(value = "SELECT video_url FROM video_model_table  ; ", nativeQuery = true)
	public List<Map<String, String>> fetchAllVideosJson();
	

}
