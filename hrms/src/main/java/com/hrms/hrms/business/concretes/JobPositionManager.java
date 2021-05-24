package com.hrms.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrms.hrms.business.abstracts.JobPositionService;
import com.hrms.hrms.business.required.JobTitleFieldManager;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.dataAccess.abstracts.JobPositionDao;
import com.hrms.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionsDao;
	
		
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionsDao) {
		super();
		this.jobPositionsDao = jobPositionsDao;
	}
	

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionsDao.findAll(),"Data Listelendi");
	}


	@Override
	public Result add(JobPosition newJobPositions) {
		JobTitleFieldManager requiredFieldsManager = new JobTitleFieldManager(this.jobPositionsDao);
		return requiredFieldsManager.jobPositionControl(newJobPositions);
		}

}
