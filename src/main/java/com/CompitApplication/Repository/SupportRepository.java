package com.CompitApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CompitApplication.Model.SupportModel;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface SupportRepository extends JpaRepository<SupportModel, Integer> {

	@Query(value = "SELECT supportid FROM support_model where support_getting_id_profile_id = :targetProfileId and supporting_id_profile_id= :userProfileId  ;", nativeQuery = true)
	public Integer VerifyingSupport(@Param("userProfileId") long userProfileId,@Param("targetProfileId") long targetProfileId);

	@Modifying
	@Query(value = "DELETE FROM support_model WHERE supportid = :supportId   ;  ", nativeQuery = true)
	public boolean DeletingSupport(@Param("supportId") int supportId);

//	@Query(value="SELECT supportid from support_model where supporting_id_profile_id=:supporting_id_profile_id  " , nativeQuery = true)
//	public Integer VerifyId(@Param("supporting_id_profile_id") int  supporting_id_profile_id);

//	@Query(value = "SELECT likes_id FROM likes_model where user_id=:userId and video_post_id= :videoPostId ; ", nativeQuery = true)
//	public Integer VerifyingLikes( @Param("videoPostId")  int videoPostId,@Param("userId") int userId); 

}
