package com.hrms.hrms.business.abstracts;

import java.util.List;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.dtos.JobExperienceDto;


public interface JobExperienceService {

	Result add(JobExperienceDto jobExpeerienceDto);
	DataResult<List<JobExperienceDto>> getAll();
	DataResult<List<JobExperienceDto>> findAllByResumeIdOrderByEndedDateDesc(int id);
	
}
