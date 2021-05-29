package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Employer;


public interface ConfirmEmployerService {

	void createConfirmEmployer(Employer employer);
	Result confirmUser(String companyName);
	
	
}
