package com.hrms.hrms.business.required;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.FieldService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.JobPositionDao;
import com.hrms.hrms.entities.concretes.JobPosition;

@Service
public class JobTitleFieldManager implements FieldService<JobPosition>{
	
	@Autowired
	private JobPositionDao jobPositionDao;
	
	public JobTitleFieldManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	
	@Override
	public Result verifyData(JobPosition jobPosition) {
		if (jobPositionDao.existsByPosition(jobPosition.getPosition())) {
			return new ErrorResult("Bu Pozisyon Daha Önce Kaydedildi");
		}
		
			this.jobPositionDao.save(jobPosition);
			return new SuccessResult("Kayıt Eklendi");
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"Listeleme Başarılı");
	}


}
