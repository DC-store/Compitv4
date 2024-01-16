package com.CompitApplication.Security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.CompitApplication.Logger.LoggingUtils;
import com.amazonaws.services.cognitoidp.model.ExpiredCodeException;
import com.amazonaws.services.ram.model.MalformedArnException;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	static LoggingUtils logger = new LoggingUtils(JwtAuthenticationFilter.class.getName());
	
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtTokenHelper jwtTokenHelper;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String requestToken = request.getHeader("Authorization");
		System.out.println("request Token ==========");
		System.out.println(requestToken);

		String username = null;

		String token = null;

		if (request != null && requestToken.startsWith("Bearer")) {

			token = requestToken.substring(7);
			try {
				System.out.println("tolen "+token);
				System.out.println("===asking for user name =====");
				
				//username = jwtUtil.getUsernameFromToken(jwtToken);
				username = this.jwtTokenHelper.getUsernameFromToken(token);
				
				System.out.println("user name printing in authfilter =======");
				System.out.println("============="+username+"=============");
				System.out.println("=====JwtAuthenticationFilter inside the bearer=====");
			} catch (IllegalArgumentException e) {
				System.out.println("unable to get jwt token");
			} catch (ExpiredJwtException e) {
				System.out.println("jwt token as expired ");
			} catch (MalformedJwtException e) {
				System.out.println("invalid jwt");
			}

		} else {

			System.out.println("jwt token does not begin with the bearer");
		}
		// once we get the token now validate
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			
			System.out.println("if userame not null ======");
			System.out.println(username);
			System.out.println();
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			
			if (this.jwtTokenHelper.validateToken(token, userDetails)) {
					System.out.println("========inside the username getting username "+userDetails.getUsername());
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());

				System.out.println("==========="+usernamePasswordAuthenticationToken+"=========================");
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

			} else {
				System.out.println("invalid Jwt Token ");
			}

		} else {
			System.out.println("=========authentication filter =======");
			System.out.println("username is null or context is not  null");
		}
		//check for validation 
		filterChain.doFilter(request, response);
	}

}
