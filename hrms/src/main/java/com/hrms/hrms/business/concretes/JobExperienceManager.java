package com.hrms.hrms.business.concretes;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.JobExperienceService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.JobExperienceDao;
import com.hrms.hrms.entities.concretes.JobExperience;


@Service
public class JobExperienceManager implements JobExperienceService {

	private JobExperienceDao jobExperienceDao;

	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}
	
	
	@Override
	public Result add(JobExperience jobExperience) {
		jobExperienceDao.save(jobExperience);
		return new SuccessResult("Başarıyla Eklendi");
	}

	@Override
	public DataResult<List<JobExperience>> getAll() {
		return new SuccessDataResult<List<JobExperience>>(jobExperienceDao.findAll(), "Başarıyla Listelendi");
	}

	
	
}
