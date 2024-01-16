package com.CompitApplication.Config;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.CompitApplication.Security.CustomUserDetailService;
import com.CompitApplication.Security.JwtAuthenticationEntryPoint;
import com.CompitApplication.Security.JwtAuthenticationFilter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Autowired
	private JwtAuthenticationFilter jwtauthenticationFilter;
	
	/*
	 * @Autowired private AuthenticationProvider provider;
	 */
	public static Logger logger = Logger.getLogger(SecurityConfig.class.getName());


	@SuppressWarnings("deprecation")
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.csrf()
		.disable()
		.authorizeHttpRequests()
		.antMatchers("/api/v1/auth/**","/api/v1/auth/usernamePick/","/api/v1/otpGeneration/**").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.exceptionHandling()
		.authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		
		http.addFilterBefore(this.jwtauthenticationFilter,UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//System.out.println("====inside the configure Authentication manager====");
		logger.warning("===inside the configure Authentication manager=====");
		auth.userDetailsService(this.customUserDetailService)
		.passwordEncoder(passwordEncoder());
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		logger.info("conneted to the data base and the schema name is ::compitApplication");
		logger.warning("======inside the password encoder=========");
		logger.warning("jwt three level security is working fine and been deployed");
		//System.out.println("===inside the password encoder=====");
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		
		return  encoder;
	}
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {

		return super.authenticationManagerBean();
	}
		
	
 
		
	}
	

