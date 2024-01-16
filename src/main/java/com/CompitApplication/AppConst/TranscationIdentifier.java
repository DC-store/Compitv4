package com.CompitApplication.AppConst;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;
@Service
public class TranscationIdentifier {

	 public static String getAPITransactionId(int rAPIName, String mobileNumber) {
		   
	  
	        DateTimeFormatter lDateTimeFormat = DateTimeFormatter.ofPattern("ddMMHHmmssSSS");
	         
	        LocalDateTime lCurrentTime = LocalDateTime.now();
	        String lTimeStamp = (lDateTimeFormat.format(lCurrentTime));

	        String lMsisdn = mobileNumber;

	        if(mobileNumber=="" || mobileNumber == null || mobileNumber.length() < 4) {
	            lMsisdn = "0000000000";
	        }
	        StringBuilder build= new StringBuilder();
	        
	      //read configuration APP_NODE_ID from pcrf.env file
	        build.append(rAPIName);
	        build.append(lMsisdn.substring(4));
	        build.append(lTimeStamp);

	        String Result= build.toString();

	        System.out.println(Result);

	        return Result;
	    }
}
