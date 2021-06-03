package com.hrms.hrms.business.abstracts;

import java.util.List;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.dtos.EducationDto;


public interface EducationService {

	Result add(EducationDto educationDto);
	
	DataResult<List<EducationDto>> getAll();
	
}
