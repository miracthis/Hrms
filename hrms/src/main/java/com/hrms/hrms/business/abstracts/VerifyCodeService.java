package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.User;


public interface VerifyCodeService {

	String createVerifyCode(User user);
	void sendMail(String mail);
	Result verifyUser(String code); 
		
}
