package com.CompitApplication.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.CompitApplication.Component.JwtAuthRequest;
import com.CompitApplication.Exception.ParameterException;
import com.CompitApplication.Gen.ValidationOfParameter;
import com.CompitApplication.Logger.LoggingUtils;
import com.CompitApplication.Response.ApiResponse;
import com.CompitApplication.Response.JwtAuthResponse;
import com.CompitApplication.Security.JwtTokenHelper;
import com.CompitApplication.Service.ProfileRegService;
import com.CompitApplication.dtos.ProfileDto;

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {

	static LoggingUtils logger = new LoggingUtils(AuthController.class.getName());

	@Autowired
	private JwtTokenHelper jwtTokenHelper;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private ProfileRegService profileRegService;

	@PostMapping("/apicheck")
	@ResponseBody
	public String method() {

		return "api working";
	}

	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@Valid @RequestBody JwtAuthRequest request) throws Exception {
		System.out.println("authentication");
		System.out.println("redirecting heeree.....");
		System.out.println("request username form the JWT auth request " + request.getUsernames());
		this.authenticate(request.getUsernames(), request.getPassword());
		// have to make it right

		UserDetails userDetail = this.userDetailsService.loadUserByUsername(request.getUsernames());
		System.out.println("user details service " + userDetail.getUsername());
		String token = this.jwtTokenHelper.generateToken(userDetail);

		JwtAuthResponse response = new JwtAuthResponse();
		response.setToken(token);
//		String tokens = response.getToken();
//		String finToken= token.substring(7);
//		
//		
//		String username = this.jwtTokenHelper.getUsernameFromToken(finToken);
//		System.out.println("username from token ===="+username );

		return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);
	}

	private void authenticate(String usernames, String password) throws Exception {
		System.out.println("in authenticate method =" + usernames);
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				usernames, password);
		try {
			this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		} catch (BadCredentialsException e) {
			System.err.println("this is the exception inside the auth controller ");
			System.err.println("invalid details");
			throw new Exception("invalid username or password");
		}
	}

	// Perfect
	@PostMapping("/register")
	public ResponseEntity<ApiResponse> registerUser(@Valid @RequestBody ProfileDto profileModel)
			throws ParameterException {
		ApiResponse apiResponse = new ApiResponse();
		System.out.println("=========TBR profile========================");

		ValidationOfParameter validate = new ValidationOfParameter();
		Integer phnNumberValidationSts = validate.phnNumnberValidation(profileModel.getPhnNumber());

		Integer mailIdValidation = validate.mailIdValidation(profileModel.getGmail());

		if (phnNumberValidationSts == 0) {
			apiResponse.setMessage("Please Check the phonnumber");
			apiResponse.setSuccess(false);
			apiResponse.setOutput("PROFILE NOT CREATED");
			logger.fatal("phonNumber Validation falied");
			return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
		}
		if (mailIdValidation == 0) {
			apiResponse.setMessage("Please Check the Mail Id");
			apiResponse.setSuccess(false);
			apiResponse.setOutput("PROFILE NOT CREATED");
			logger.fatal("mail id validation falied");
			return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
		}
		String message = validate.passwordValidation(profileModel.getPassword());
		if (!message.equals("Valid")) {
			apiResponse.setMessage(message);
			apiResponse.setSuccess(false);
			apiResponse.setOutput("PLEASE GIVE A VLIAD PASSWORD");
			logger.fatal("password validaion falid");
			return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
		}
		// have to check the dob from front end

		if (phnNumberValidationSts == 1 && mailIdValidation == 1 && message.equals("Valid")) {
			ProfileDto registeredUser = this.profileRegService.savingProfile(profileModel);

			if (registeredUser != null) {
				apiResponse.setMessage("created Succesfully");
				apiResponse.setSuccess(true);
				apiResponse.setOutput(registeredUser);
				return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.CREATED);
			}

			else {
				apiResponse.setMessage("Something Went Wrong");
				apiResponse.setSuccess(false);
				return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_GATEWAY);
			}
		}
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_GATEWAY);

	}

	@GetMapping("/usernamePick/")
	public ResponseEntity<ApiResponse> PickUserName(@Param("username") String username) {
		System.out.println(username);
		ApiResponse apiResponse = new ApiResponse();
		String status = this.profileRegService.usernamePick(username);
		try {
			if (status.equals("True")) {
				apiResponse.setMessage("query feteched properly");
				apiResponse.setSuccess(true);
				apiResponse.setOutput("username existance status  :" + status);
				return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.ACCEPTED);
			} else {
				apiResponse.setMessage("query fetched properly");
				apiResponse.setSuccess(true);
				apiResponse.setOutput("username existance status :" + false);
				return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.ACCEPTED);
			}
		} catch (Exception exception) {
			apiResponse.setMessage("Something went wrong check the procedure");
			apiResponse.setSuccess(false);
			apiResponse.setOutput("Output went under Exception " + null);
			return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.EXPECTATION_FAILED);
		}

	}

	// get loggedin user data
//	@Autowired
//	private UserRepo userRepo;
//	@Autowired
//	private ModelMapper mapper;
//
//	@GetMapping("/current-user/")
//	public ResponseEntity<UserDto> getUser(Principal principal) {
//		User user = this.userRepo.findByEmail(principal.getName()).get();
//		return new ResponseEntity<UserDto>(this.mapper.map(user, UserDto.class), HttpStatus.OK);
//	}

	@GetMapping("/logout")
	public ResponseEntity<ApiResponse> logOUtFunctionality() {

		return null;
	}

}
