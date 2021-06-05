package com.hrms.hrms.business.abstracts;

import java.util.List;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.dtos.TechnologyDto;

public interface TechnologyService {

	Result add(TechnologyDto technologyDto);
	
	DataResult<List<TechnologyDto>> getAll();
	
}
