package com.CompitApplication.Controller;


import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

import javax.annotation.PreDestroy;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CompitApplication.Model.ChallengeModel;
import com.CompitApplication.Repository.ChallengeRepository;

@RestController
@RequestMapping("/api/v1/ChallengeController")
public class ChallengeController {
	//working on the challenege repo .........
	@Autowired
	private ChallengeRepository challengeRepo;
	

	
}
