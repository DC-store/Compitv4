package com.CompitApplication;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.CompitApplication.Logger.LoggingUtils;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Logger;

import javax.annotation.PreDestroy;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
@EnableScheduling
@SpringBootApplication
public class CompitApplication  implements CommandLineRunner {
	@Autowired
	private PasswordEncoder encoder;
	
	 public static final String TIME_SERVER = "time-a.nist.gov";
	 
	 static LoggingUtils logger = new LoggingUtils(CompitApplication.class.getName());
	 
	public static void main(String[] args) {
		
		SpringApplication.run(CompitApplication.class, args);
		System.out.println("Compit Application");
		logger.info("compit application has started....");
	}

	@Override
	public void run(String... args) throws Exception {
			System.out.println("wonder full application ");
			
			NTPUDPClient timeClient = new NTPUDPClient();
	        InetAddress inetAddress = InetAddress.getByName(TIME_SERVER);
	        TimeInfo timeInfo = timeClient.getTime(inetAddress);
	        long returnTime = timeInfo.getReturnTime();
	        Date time = new Date(returnTime);
	        long systemtime = System.currentTimeMillis();
	        timeInfo.computeDetails();
	        Date realdate = new Date(systemtime + timeInfo.getOffset());
	        System.out.println("Time from " + TIME_SERVER + ": " + time);
	        System.out.println("Time from " + TIME_SERVER + ": " + realdate);
	        System.out.println(""+time.getTime());
	        Date date = new Date();  
	        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");  
	        String strDate= formatter.format(date);  
	        System.out.println(strDate);  
	        System.out.println(time.getDate());
	        String dates = LocalDate.now().plusDays(2).format(DateTimeFormatter.ofPattern("dd-MMM-YYYY"));
	        System.out.println(dates);
	        
	        LocalDate dat = LocalDate.now();
	        System.out.println(dat);
	       
	}


	@PreDestroy
	 public void doRun() {
		 System.out.println("waw the application is closing its reference right now ");
		 System.out.println("ending the statement of the execution before eniding the application");
     	
     }
	

	

	

}
