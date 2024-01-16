package com.CompitApplication.AppConst;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionIdGenerator {

	@Autowired
	private MobileNumberGetiing getiingMobNum;

	public String TransactionIdGeneration(int apiCode, String phnNUmber) {
		Long profileId = 0L;
	
		//have to check bit
		String mobNumForTransId = getiingMobNum.gettingMobileNumber(profileId);
		// TODO txn id generating for logs
		TranscationIdentifier identifier = new TranscationIdentifier();
		String txn = identifier.getAPITransactionId(apiCode, mobNumForTransId);

		return txn;

	}

	public String TransactionIdGenerationUsingProfileID(int apiCode, Long ProfileID) {
		String mobNumForTransId = getiingMobNum.gettingMobileNumber(ProfileID);
		TranscationIdentifier identifier = new TranscationIdentifier();
		String txn = identifier.getAPITransactionId(apiCode, mobNumForTransId);
		
		return txn;
	}

}
