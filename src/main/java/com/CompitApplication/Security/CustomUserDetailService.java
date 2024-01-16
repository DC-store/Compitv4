package com.CompitApplication.Security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.CompitApplication.Exception.ResourceNotFoundException;
import com.CompitApplication.Logger.LoggingUtils;
import com.CompitApplication.Model.ProfileModel;
import com.CompitApplication.Repository.ProfileRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private ProfileRepository profileRepo;
	
	
	 PasswordEncoder encoder = new BCryptPasswordEncoder();;
	 
	 static LoggingUtils logger = new LoggingUtils(CustomUserDetailService.class.getName());

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("username ="+username);
		System.out.println("====inside the User details methode in Custimer Details Service class====");
		ProfileModel profile= null;
		try {
		 profile=    this.profileRepo.findByUsernames(username).orElseThrow(()-> new ResourceNotFoundException("User ", " email : " + username, 0) );
		}
		catch (InternalAuthenticationServiceException exception){
			logger.fatal("User repeated more than once  registered more than once");
		}
		
		
	//boolean b=	encoder.matches("xyz","$2a$10$su7X4kYrpj5wMFHzzHEAh.EruS3HFfzks8hJVyqo73NzhabER6hjy");
	System.out.println("password checking");
	//System.out.println(b);
		return profile;
	}

}
