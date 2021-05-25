package com.hrms.hrms.business.concretes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrms.hrms.business.abstracts.FieldService;
import com.hrms.hrms.business.abstracts.EmployerService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private FieldService<Employer> controllerService;
	
	@Autowired
	public EmployerManager(FieldService<Employer> controllerService) {
		super();
		this.controllerService = controllerService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return controllerService.getAll();
	}

	@Override
	public Result add(Employer employer) {
		return this.controllerService.verifyData(employer);
	}
	
	

}
