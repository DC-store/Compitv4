package com.CompitApplication.Service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;




import org.springframework.web.bind.annotation.RequestBody;

import com.CompitApplication.Logger.LoggingUtils;
import com.CompitApplication.Model.SmsEntity;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;




@Transactional
@Service
public class SmsService {
	
	static LoggingUtils logger = new LoggingUtils(SmsService.class.getName());
	//this have to be given in a file 
	public static final String ACCOUNT_SID ="AC71eb56179cd30bea0f7cff1dd26f64f2";
    public static final String AUTH_TOKEN = "788c322bc574deb9883538e340424f98";
    public static final String FROM_NUMBER="+12029681276";
	
    
    //1 202 968 1276
    
	public Integer send( SmsEntity sms,String txn) {
		 Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		 Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	        int min=100000;
			
	        logger.info("txndId: "+txn +" func send() req: "+sms.getPhnnumber());
			int max=999999;
			
			int number = (int) ((Math.random()*(max-min +1)+min)+min);
			logger.info("txndId: "+txn +" func send() otp : "+number);
			String msg="your OTP number is: "+number+" welcome to Dig Dream Application, real world  Platform providing Application";
			
			logger.info("txnId "+txn +"msg to be sent "+msg);
			System.out.println(msg);   
			System.out.println(FROM_NUMBER);
			logger.info("txnId "+txn+"From number "+FROM_NUMBER );
			Message message = Message.creator(
	                new com.twilio.type.PhoneNumber(sms.getPhnnumber()),
	                new com.twilio.type.PhoneNumber("+12029681276"),
	                msg)
	            .create();

			logger.info("txnID: "+txn+" message generated err code +"+message.getErrorMessage());
	if(message.getErrorMessage()==null) {
		return number;
	}
	    
	else {
		logger.error("txnId: "+txn+" error in sending otp");
		return null;
	}
		
		
		
		
		
		
		
	}

	
}