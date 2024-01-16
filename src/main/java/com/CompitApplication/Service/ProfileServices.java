package com.CompitApplication.Service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.CompitApplication.AppConst.ApiCode;
import com.CompitApplication.AppConst.MobileNumberGetiing;
import com.CompitApplication.AppConst.TranscationIdentifier;
import com.CompitApplication.Exception.ParameterException;
import com.CompitApplication.Logger.LoggingUtils;
import com.CompitApplication.Model.ProfileModel;
import com.CompitApplication.Repository.ProfileRepository;
import com.CompitApplication.dtos.ProfileDto;

@Service
@Validated
public class ProfileServices {
	
	@Autowired
	private ProfileRepository profileRepo;
	
	@Autowired
	private MobileNumberGetiing getiingMobNum;
	
	
	
	
static 	LoggingUtils logger =new LoggingUtils(ProfileServices.class.getName());
	
	@Autowired
	@PersistenceContext
	private EntityManager em;

	public boolean createdNewProfile(@Valid ProfileDto profileDto)  {
		Long profileId=0L;
		String mobNumForTransId =getiingMobNum.gettingMobileNumber(profileId);
		
		//TODO txn id generating for logs 
		TranscationIdentifier identifier= new TranscationIdentifier();
		String txn=identifier.getAPITransactionId(ApiCode.CREATE_PROFILE, mobNumForTransId);
		logger.info("txn: "+txn+" func: createdNewProfile() Req: username :"+profileDto.getUsernames()+" dob: "+profileDto.getDob()+" phnNumber:  "+profileDto.getPhnNumber()+" gmail: "+profileDto.getGmail());
		boolean status= false;
		ProfileModel model = new ProfileModel();
		model.setUsernames(profileDto.getUsernames());
		model.setPassword(profileDto.getPassword());
		model.setGmail(profileDto.getGmail());
		model.setDob(profileDto.getDob());
		Long phoneNumber= new Long(profileDto.getPhnNumber());
		model.setPhnnumber(phoneNumber);
			
		System.out.println(model.toString());
		model = profileRepo.save(model);
		if(model!=null && !model.toString().equals("")) {
			status= true;
			return status;
		}
		else {
			status= false;
			return status;
		}
		
	}

	public boolean updateExistingProfile(@Valid ProfileDto profileDto, Long profileId) {
		boolean profileUpdateStatus= false;
		String phnNumber=null;
		   String mobNumForTransId =getiingMobNum.gettingMobileNumber(profileId);
		//TODO txn id generating for logs 
		TranscationIdentifier identifier= new TranscationIdentifier();
		String txn=identifier.getAPITransactionId(ApiCode.UPDATE_PROFILE, mobNumForTransId);
		
		
		
		ProfileModel model= profileRepo.findByProfileId(profileId);
		
		if(!profileDto.getUsernames().equals(model.getUsernames())) {
			System.out.println("model before set "+model.getUsernames());
			model.setUsernames(profileDto.getUsernames());
			System.out.println("model after set "+model.getUsernames());
			
		}
		if(!profileDto.getDob().equals(model.getDob())) {
			model.setDob(profileDto.getDob());
			System.out.println("modified dob number ="+model.getDob());
			
		}
		if(!profileDto.getPhnNumber().equals( phnNumber= String.valueOf(model.getPhnnumber()))) {
			model.setPhnnumber(new Long(profileDto.getPhnNumber()));
			System.out.println("modified phone number== "+model.getPhnnumber());
		}
		//password resest is a big story
		if(!profileDto.getGmail().equals(model.getGmail())) {
			model.setGmail(profileDto.getGmail());
			System.out.println("profile gmail id after the modification ");
		}
			model = profileRepo.save(model);
			if(!model.equals(null)) {
				
				profileUpdateStatus= true;
			}
			else {
				profileUpdateStatus= false ;
			}
		return profileUpdateStatus;
	}

	public boolean UsernamePresenceCheck(String username)  throws ParameterException{
		Object obj=null;
		boolean statusCheck= false;
		String output= null;
		if(!username.equals("")) {
		
		StoredProcedureQuery query = em.createStoredProcedureQuery("getAllUserName");
		System.out.println(query);
		query.registerStoredProcedureParameter(0, String.class, ParameterMode.IN);

		query.registerStoredProcedureParameter(1, String.class, ParameterMode.OUT);
		query.setParameter(0, "darshan");
		
	

		obj = query.getOutputParameterValue(1);
		 output= (String)(obj) ;
		
		}
		else {
			Error er= new Error("please enter the username");
			throw new ParameterException("username cannot be null", er);
		}
		if(output.toLowerCase().equals("true")) {
			statusCheck=true;
		}
		else {
			statusCheck=false;
		}
		
		System.out.println("output of the sp is " + obj);
		return statusCheck;
	}

	public List<ProfileDto> getAllProfiles() {
		List<ProfileDto> profileDtoList= new ArrayList<>();
		List<ProfileModel> profileModeList= profileRepo.findAll();
		for (ProfileModel profileModel : profileModeList) {
			ProfileDto profileDto = new ProfileDto();
			profileDto.setUsernames(profileModel.getUsernames());
			profileDto.setGmail(profileModel.getGmail());
			profileDto.setPhnNumber(String.valueOf(profileModel.getPhnnumber()));
			profileDto.setProfileId(profileModel.getProfileId());
			profileDto.setDob(profileModel.getDob());
			profileDto.setPassword(null);
			profileDtoList.add(profileDto);
			
			
		}
		

		return profileDtoList;
	}

	public ProfileDto getSingleProfile(Long profileId) {
		System.out.println("entering to the service of  the profile model");
		ProfileDto profileDto = new ProfileDto();
		ProfileModel model = profileRepo.findByProfileId(profileId);
		
		profileDto.setDob(model.getDob());
		profileDto.setGmail(model.getGmail());
		profileDto.setPassword(null);
		profileDto.setPhnNumber(String.valueOf(model.getPhnnumber()));
		profileDto.setProfileId(model.getProfileId());
		profileDto.setUsernames(model.getUsernames());
		
		return profileDto;
	}

}
