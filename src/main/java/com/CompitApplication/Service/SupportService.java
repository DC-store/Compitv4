package com.CompitApplication.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CompitApplication.Logger.LoggingUtils;
import com.CompitApplication.Model.ProfileModel;
import com.CompitApplication.Model.SupportModel;
import com.CompitApplication.Repository.ProfileRepository;
import com.CompitApplication.Repository.SupportRepository;

@Transactional
@Service
public class SupportService {
	
	static LoggingUtils logger = new LoggingUtils(SupportService.class.getName());

	@Autowired
	private SupportRepository supportRepo;

	@Autowired
	private ProfileRepository profilerepo;

	public void supporting(long userProfileId, long targetProfileId) {
		Integer supportId = supportRepo.VerifyingSupport(userProfileId, targetProfileId);

		System.out.println("supporting_id_profile_id====" + userProfileId);
		System.out.println("support_getting_id_profile_id====" + targetProfileId);
		System.out.println("support id====>" + supportId);
		if (supportId == null) {
			SupportModel model = new SupportModel();
			ProfileModel profile = profilerepo.getById(userProfileId);

			model.setSupportingId(profile);
			profile = profilerepo.getById(targetProfileId);
			model.setSupportGettingId(profile);
			supportRepo.save(model);

			System.out.println("saved the supporting suceefully");
		} else {
			System.out.println("the support id is found so not supporting");
			supportRepo.deleteById(supportId);

		}
	}

}