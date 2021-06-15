package com.hrms.hrms.api.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.business.abstracts.ConfirmEmployerService;
import com.hrms.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/validEmployer")
public class ConfirmEmployerController {

	private ConfirmEmployerService confirmEmployerService;

	public ConfirmEmployerController(ConfirmEmployerService confirmEmployerService) {
		super();
		this.confirmEmployerService = confirmEmployerService;
	}
	
	
	@PutMapping("/{companyName}")
	public Result update(@PathVariable("companyName") String companyName) {
		
		return confirmEmployerService.confirmUser(companyName);
	}
	

}
