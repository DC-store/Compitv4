package com.CompitApplication.Controller;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CompitApplication.AppConst.ApiCode;
import com.CompitApplication.AppConst.MobileNumberGetiing;
import com.CompitApplication.AppConst.TransactionIdGenerator;
import com.CompitApplication.AppConst.TranscationIdentifier;
import com.CompitApplication.Component.SmsOtp;
import com.CompitApplication.Logger.LoggingUtils;
import com.CompitApplication.Model.SmsEntity;
import com.CompitApplication.Service.SmsService;
import com.twilio.http.Response;

@RestController
@RequestMapping("/api/v1/otpGeneration")
public class SmsController {

	public String phnnumber;
	Integer otp;
	String Otp;

	private static LoggingUtils logger = new LoggingUtils(SmsController.class.getName());

	ConcurrentLinkedQueue<String> otpQueue = new ConcurrentLinkedQueue<>();

	@Autowired
	private SmsService smsService;

	@Autowired
	private TransactionIdGenerator IdGenerator;

	private ScheduledFuture<?> scheduledTask;

	@PostMapping("/getOtp")
	public ResponseEntity<String> getOtp(@RequestBody SmsEntity sms) {

		String txn = IdGenerator.TransactionIdGeneration(ApiCode.OTP_SEND,sms.getPhnnumber() );
		try {

			logger.info("txnId :" + txn + " getOtp()  request: phnnumber " + sms.getPhnnumber());
			phnnumber = sms.getPhnnumber();
			logger.info("txnId :" + txn + " getOtp()  calling sendSMS request: sms " + sms);
			otp = smsService.send(sms, txn);
			logger.info("txnId :" + txn + " send() meth response: opt " + otp);
			if (otp != null) {
				Otp = otp.toString();
				otpQueue.offer(Otp);

				if (scheduledTask == null || scheduledTask.isCancelled()) {
					logger.info("txnId :" + txn + " getOtp()  sheduler to clean otp que ");
					scheduledTask = new ScheduledThreadPoolExecutor(1).scheduleAtFixedRate(this::clearOtpQueue, 30, 30,
							TimeUnit.SECONDS);
					logger.warn("txnId :" + txn + " getOtp()  OTP  SENT result Sts:  SUCCESSFUL");
					return new ResponseEntity<String>("otp sent", HttpStatus.OK);

				}

			} else {
				logger.info("txnId :" + txn + " getOtp() OTP  SENT result Sts  : FAILURE" );
				return new ResponseEntity<String>("otp not sent  sent", HttpStatus.INTERNAL_SERVER_ERROR);
			}

		} catch (Exception e) {
			logger.warn("txnId :" + txn + " getOtp()  OTP NOT SENT result Sts: NOT SUCCESSFUL");
			return new ResponseEntity<String>("otp not sent", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.warn("txnId :" + txn + " getOtp()  OTP NOT SENT result Sts: NOT SUCCESSFUL");
		return new ResponseEntity<String>("otp not sent", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	// need to make the opt to recieve without time exceed
	@PostMapping("/verify")
	public ResponseEntity<String> verification(@RequestBody SmsOtp otp) {
		
		String txn= IdGenerator.TransactionIdGeneration(ApiCode.OTP_VERIFICATION_API, null);
		logger.info("txn id: "+txn+" verification()  otpQueue: "+otpQueue);
		if (otpQueue.contains(otp.getOtp())) {
			logger.info("txn id: "+txn+" verification()  req: "+otp.getOtp());
			logger.info("txn Id:"+txn+" sending Response :OTP VERFICATION SUCCESSFUL ");
			return new ResponseEntity<String>("otp verified", HttpStatus.OK);
		} else {
			logger.fatal("txn id: "+txn+" verification()  rsponse : OTP EXPIRED OR WRONG ");
			return new ResponseEntity<String>("Wrong otp or Otp has been expired ", HttpStatus.BAD_REQUEST);
		}
	}

	private void clearOtpQueue() {
		otpQueue.poll();
		System.out.println("OTP queue cleared.");
		System.out.println("otp " + otpQueue);
		// Stop the scheduled task if the queue is empty
		if (otpQueue.isEmpty() && scheduledTask != null) {

			scheduledTask.cancel(false);
		}
	}

	
}
