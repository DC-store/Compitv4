package com.CompitApplication.Config;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.CompitApplication.AppConst.AppConstants;
import com.CompitApplication.Logger.LoggingUtils;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AwsConfiguration {

	@Value("${cloud.aws.credentials.access-key}")
	private String accesskey;
	
	@Value("${cloud.aws.credentials.secret-key}")
	private String secretKey;
	
	static LoggingUtils logger = new LoggingUtils(AwsConfiguration.class.getName());
	
	@Value("${cloud.aws.region.static}")
    private String region;
	
	@Bean
	public AmazonS3 s3client() {
		AWSCredentials credentias= new BasicAWSCredentials(accesskey, secretKey);
		// i dint understand this
		System.out.println("connecting...... to aws");
		return AmazonS3ClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentias))
				.withRegion(region).build();
	}
}