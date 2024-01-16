package com.CompitApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CompitApplication.Model.LikesModel;

@Repository
public interface LikesRepository extends JpaRepository<LikesModel, Integer> {

	@Query(value = "SELECT count(*) FROM likes_model  where  video_post_id= :videoPostId ", nativeQuery = true)
	public int countingLikes(@Param("videoPostId") int videoPostId);

	@Query(value = "SELECT likes_id FROM likes_model where user_id=:userId and video_post_id= :videoPostId ; ", nativeQuery = true)
	public Integer VerifyingLikes(@Param("videoPostId") int videoPostId, @Param("userId") int userId);

	@Query(value = "SELECT * FROM likes_model where video_post_id= :videoPostId; ", nativeQuery = true)
	public List<LikesModel> deletingLikes(@Param("videoPostId") int videoPostId);

}