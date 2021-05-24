package com.hrms.hrms.business.required;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.JobPositionDao;
import com.hrms.hrms.entities.concretes.JobPosition;

@Service
public class JobTitleFieldManager{
	
	@Autowired
	private JobPositionDao jobPositionsDao;
	
	public JobTitleFieldManager(JobPositionDao jobPositionsDao) {
		super();
		this.jobPositionsDao = jobPositionsDao;
	}

	public Result jobPositionControl(JobPosition jobPosition) {
		if (jobPositionsDao.existsByPosition(jobPosition.getPosition())) {
			return new ErrorResult("Bu Pozisyon Daha Önce Kaydedildi");
		}
		
			this.jobPositionsDao.save(jobPosition);
			return new SuccessResult("Kayıt Eklendi");	
		
	}


}
