package com.hrms.hrms.business.abstracts;

import java.util.List;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobPosting;
import com.hrms.hrms.entities.dtos.JobPostingAddDto;
import com.hrms.hrms.entities.dtos.JobPostingDto;

public interface JobPostingService {
	
	Result add(JobPostingAddDto jobPostingAddDto);
	Result delete(JobPosting jobPosting);
	DataResult<List<JobPostingDto>> findByIsActive();
	DataResult<List<JobPostingDto>> findByIsActiveOrderByClosedDate();
	DataResult<List<JobPostingDto>> findByIsActiveAndEmployer_CompanyName(String companyName);

}
