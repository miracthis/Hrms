package com.hrms.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrms.hrms.business.abstracts.JobPositionsService;
import com.hrms.hrms.core.utilities.requireds.JobTitleFieldManager;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.dataAccess.abstracts.JobPositionsDao;
import com.hrms.hrms.entities.concretes.JobPositions;

@Service
public class JobPositionsManager implements JobPositionsService{

	private JobPositionsDao jobPositionsDao;
	
		
	@Autowired
	public JobPositionsManager(JobPositionsDao jobPositionsDao) {
		super();
		this.jobPositionsDao = jobPositionsDao;
	}
	

	@Override
	public DataResult<List<JobPositions>> getAll() {
		return new SuccessDataResult<List<JobPositions>>(this.jobPositionsDao.findAll(),"Data Listelendi");
	}


	@Override
	public Result add(JobPositions newJobPositions) {
		JobTitleFieldManager requiredFieldsManager = new JobTitleFieldManager(this.jobPositionsDao);
		return requiredFieldsManager.JobPositionControl(newJobPositions);
		}

}
