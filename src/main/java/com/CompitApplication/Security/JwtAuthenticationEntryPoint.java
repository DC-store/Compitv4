package com.CompitApplication.Security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.CompitApplication.Logger.LoggingUtils;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	static LoggingUtils logger = new LoggingUtils(JwtAuthenticationEntryPoint.class.getName());
	//it works when authorized user try to access api ..... ......
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"you are not authorized to do this work");
		
	}

}
