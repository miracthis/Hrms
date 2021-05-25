package com.hrms.hrms.business.concretes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrms.hrms.business.abstracts.FieldService;
import com.hrms.hrms.business.abstracts.JobPositionService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private FieldService<JobPosition> controllerService;
	
		
	@Autowired
	public JobPositionManager(FieldService<JobPosition> controllerService) {
		super();
		this.controllerService = controllerService;
	}
	

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return controllerService.getAll();
	}


	@Override
	public Result add(JobPosition newJobPositions) {
		return controllerService.verifyData(newJobPositions);
		}

}
