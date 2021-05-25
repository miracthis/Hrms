package com.hrms.hrms.api.controllers;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.business.abstracts.VerifyCodeService;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.entities.concretes.VerifyCode;

@RestController
@RequestMapping("/valid")
public class VerifyCodeController {

	VerifyCodeService verifyCodeService;
	

	public VerifyCodeController(VerifyCodeService verifyCodeService) {
		super();
		this.verifyCodeService = verifyCodeService;
	}


	@PutMapping("/{verifyCode}")
	public Result update(@PathVariable("verifyCode") String verifyCode,	@RequestBody VerifyCode verifyingCode) {
		verifyCodeService.verifyUser(verifyCode);
		return new SuccessResult("Başarılı Kayıt");
		
		
	}
	
	
}
