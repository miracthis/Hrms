package com.hrms.hrms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

import com.hrms.hrms.core.utilities.cloudinary.CloudinaryManager;
import com.hrms.hrms.core.utilities.cloudinary.CloudinaryService;

@Configuration
public class CloudinaryConfig {
	@Value("${cld.access-key}")	
	String apiKey;
	
	@Value("${cld.secret-key}")
	String apiSecretKey;
	
	
	
	 	@Bean
	    public Cloudinary cloudinaryUser(){
	        return new Cloudinary(ObjectUtils.asMap(
	                "cloud_name", "miracthis",
	                "api_key", apiKey,
	                "api_secret", apiSecretKey));
	    }

	    @Bean
	    public CloudinaryService cloudinaryService(){
	        return new CloudinaryManager(cloudinaryUser());
	    }

}
