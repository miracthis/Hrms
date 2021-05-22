package com.hrms.hrms.business.abstracts;

import java.util.List;



import com.hrms.hrms.entities.concretes.JobPositions;



public interface JobPositionsService {

	List<JobPositions> getAll();
	
	
	 JobPositions newJobPositions(JobPositions newJobPositions);
	 
	 JobPositions getOne(int id);
	 
	 JobPositions updateJobPositions(JobPositions updateJobPositions);
	 
	 String deleteJobPositions(int id);
	 
	 
	 
	 
	
	 
}
