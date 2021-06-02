package com.hrms.hrms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

import com.hrms.hrms.core.utilities.cloudinary.CloudinaryManager;
import com.hrms.hrms.core.utilities.cloudinary.CloudinaryService;

@Configuration
public class CloudinaryConfig {
		
	 	@Bean
	    public Cloudinary cloudinaryUser(){
	        return new Cloudinary(ObjectUtils.asMap(
	                "cloud_name", "miracthis",
	                "api_key", "157351826875438",
	                "api_secret", "s9hmpR0cFD4k_MMMoS0OLj0F1XU"));
	    }

	    @Bean
	    public CloudinaryService cloudinaryService(){
	        return new CloudinaryManager(cloudinaryUser());
	    }

}
