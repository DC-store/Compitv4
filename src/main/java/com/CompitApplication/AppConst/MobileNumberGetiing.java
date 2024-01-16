package com.CompitApplication.AppConst;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.CompitApplication.Repository.ProfileRepository;


@Service
public class MobileNumberGetiing {
	
	@Autowired
	private ProfileRepository profileRepository;
	
	public String gettingMobileNumber(long profileId) {
		
		Long mobileNumber= profileRepository.getMObileNumber(profileId);
		
		if(mobileNumber==null) {
			
			return null;
		}
		else {
			return mobileNumber.toString();
		}
	}
	

}
