package com.CompitApplication.Gen;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationOfParameter {

	public Integer phnNumnberValidation(String PhnNumber) {
		String regex = "^\\d{10}$";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(PhnNumber);

		boolean status = matcher.matches();

		if (status) {
			return 1;
		} else {

			return 0;
		}
	}

	public Integer mailIdValidation(String mailId) {
		String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(mailId);

		boolean status = matcher.matches();
		if (status) {
			return 1;
		} else {

			return 0;
		}

	}
	
	public String passwordValidation(String password) {
		
		  String regex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(password);

	        if (!matcher.matches()) {
	            StringBuilder sb = new StringBuilder("Password must contain:");
	            if (!password.matches(".*[0-9].*")) {
	                sb.append(" at least one digit");
	            }
	            if (!password.matches(".*[A-Z].*")) {
	                sb.append(" at least one uppercase letter");
	            }
	            if (!password.matches(".*[@#$%^&+=].*")) {
	                sb.append(" at least one special character");
	            }
	            Matcher whitespaceMatcher = Pattern.compile("\\s+").matcher(password);
	            if (whitespaceMatcher.find()) {
	                sb.append(" no whitespace");
	            }
	            if (password.length() < 8) {
	                sb.append(" at least 8 characters");
	            }
	            return sb.toString();
	        }
			return "Valid";
		
	}
	
	public  String validateDateOfBirth(String dob) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate date = LocalDate.parse(dob, formatter);
            LocalDate today = LocalDate.now();
            if (date.isAfter(today)) {
                return "Date of birth cannot be in the future";
            }
            return "Valid";
        } catch (DateTimeParseException e) {
            return "Date of birth must be in the format dd/MM/yyyy";
        }
    }
}
