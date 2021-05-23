package com.hrms.hrms.core.utilities.requireds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.JobPositionsDao;
import com.hrms.hrms.entities.concretes.JobPositions;

@Service
public class JobTitleFieldManager{
	
	@Autowired
	private JobPositionsDao jobPositionsDao;
	
	public JobTitleFieldManager(JobPositionsDao jobPositionsDao) {
		super();
		this.jobPositionsDao = jobPositionsDao;
	}

	public Result JobPositionControl(JobPositions jobPosition) {
		if (jobPositionsDao.existsByPosition(jobPosition.getPosition())) {
			return new ErrorResult("Bu Pozisyon Daha Önce Kaydedildi");
		}
		
		if (jobPosition.getPosition() == null || jobPosition.getPosition()=="") {
			return new ErrorResult("Pozisyon Adı Boş Geçilemez");
		}
			this.jobPositionsDao.save(jobPosition);
			return new SuccessResult("Kayıt Eklendi");	
		
	}


}
