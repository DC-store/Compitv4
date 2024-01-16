package com.CompitApplication.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.CompitApplication.Logger.LoggingUtils;
import com.CompitApplication.Model.ChallengeModel;
import com.CompitApplication.Model.ProfileModel;
import com.CompitApplication.Repository.ChallengeRepository;
import com.CompitApplication.Repository.ProfileRepository;
import com.amazonaws.Response;
@Transactional
@Service
public class ChallengeService {

	static LoggingUtils logger = new LoggingUtils(ChallengeService.class.getName());
	
	@Autowired
	private ChallengeRepository challengeRepo;
	
	@Autowired
	private ProfileRepository profileRepo;

	private ProfileModel profilemodel;
	
	
	
	public ResponseEntity<ChallengeModel> sendChallenge(int fromId, int toId) {
		
		if(fromId!=0 && toId!=0) {
			
			ChallengeModel model = new ChallengeModel();
			profilemodel =  profileRepo.findByProfileId(fromId);
			model.setChallengeFromId(profilemodel);
			profilemodel = profileRepo.findByProfileId(toId);
			model.setChallengeToID(profilemodel);
			model.setChallengeAcceptanceflag(0);
			ChallengeModel challengemodel= challengeRepo.save(model);
			return new ResponseEntity<ChallengeModel>(challengemodel,HttpStatus.CREATED );
		}
		
		else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		}
	
	
	//maximum days is 7
	public String acceptChallenge(long challengeId , int days) {
		if(challengeId!= 0) {
		ChallengeModel model = challengeRepo.findByChallengeId(challengeId);
		model.setChallengeAcceptanceflag(1);
		
			LocalDate date = LocalDate.now();
			LocalTime time = LocalTime.now();
		model.setChallengeAcceptedDate(date);
		model.setChallengeAcceptedtime(time);
		
		model.setChallengeEndDate(LocalDate.now().plusDays(days));
		model.setChallengeEndTime(LocalTime.now());
		challengeRepo.save(model);
		}
		
		
		return "Challenge has been accepted timer started";
	}
	
	public String challengeDeclined(long challengeId) {
		ChallengeModel challengeModel = challengeRepo.findByChallengeId(challengeId);
		challengeRepo.delete(challengeModel);
		
		return "challenge has been declined by your compitetor";
	}
	
	public String winningDeclaration() {
		
		
	return "winner";	
	}
	
}
