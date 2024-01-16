package com.CompitApplication.Repository;

import java.util.Optional;

import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CompitApplication.Model.ProfileModel;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileModel, Long> {

//	 public ProfileModel saveBook(ProfileModel profileModel);
	// public ProfileModel findByProfileId(int profileid);

	public ProfileModel findByProfileId(int id);
	
	public ProfileModel findByProfileId(Long id);
	
	public  Optional<ProfileModel> findByGmail(String gmail);
	
	
	public Optional<ProfileModel> findByUsernames(String username);

	@Procedure("getAllUserName")
	String VerifyUserNamePresence(@Param("i_rquestUserName") String username);
	
	@Query(value="SELECT phone_number FROM profile_model_tabel where profile_id= :profileId  ;",nativeQuery=true)
	public Long getMObileNumber(@Param("profileId") Long profileId);
}
