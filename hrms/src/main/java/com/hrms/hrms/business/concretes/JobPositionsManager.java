package com.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.JobPositionsService;
import com.hrms.hrms.core.JobPositionNotFoundException;
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
	public List<JobPositions> getAll() {
		return this.jobPositionsDao.findAll();
	}


	@Override
	public JobPositions newJobPositions(JobPositions newJobPositions) {
		return jobPositionsDao.save(newJobPositions);
	}


	@Override
	public JobPositions getOne(int id) {
		return jobPositionsDao.findById(id)
				 .orElseThrow(() -> new JobPositionNotFoundException(id));
			      
	}


	@Override
	public JobPositions updateJobPositions(JobPositions updateJobPositions) {
		return jobPositionsDao.findById(updateJobPositions.getId())
				.map(jobs -> {jobs.setPosition(updateJobPositions.getPosition());
				return jobPositionsDao.save(jobs);
		      }).orElseGet(() -> {updateJobPositions.setId(updateJobPositions.getId());
		      return jobPositionsDao.save(updateJobPositions);
		      });
	}


	@Override
	public String deleteJobPositions(int id) {
		jobPositionsDao.deleteById(id);
		return "ID = " + id + "olan kayıt silindi";
	}

}
