package com.CompitApplication.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CompitApplication.Logger.LoggingUtils;
import com.CompitApplication.Service.SupportService;



@RestController
@RequestMapping("/api/v1/Support")
public class SupportController {

	@Autowired
	private SupportService supportserve;
	
	
	 
	static LoggingUtils logger = new LoggingUtils(SupportController.class.getName());	
	
	@PostMapping("/{userProfileId}/{targetProfileId}/saveSupport")
	public void createSupportin(@PathVariable("userProfileId")  int userProfileId, @PathVariable("targetProfileId") int targetProfileId) {
		
		supportserve.supporting(userProfileId, targetProfileId);
		System.out.println("inside the supporting creation method");
	}
	
	
}
