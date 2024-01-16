package com.CompitApplication.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CompitApplication.Model.CommentsModel;



@Repository
public interface CommentsRepository extends JpaRepository<CommentsModel, Integer>{

	
	@Query(value = "SELECT * FROM try.comments_model where video_id= :videoId ;", nativeQuery = true )
	public List<CommentsModel> fetchVideoComment(@Param("videoId") int videoId);  
	
	//have to find the total number of count of comments
}
