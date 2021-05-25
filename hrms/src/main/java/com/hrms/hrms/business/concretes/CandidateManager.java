package com.hrms.hrms.business.concretes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrms.hrms.business.abstracts.CandidateService;
import com.hrms.hrms.business.abstracts.FieldService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{

	private FieldService<Candidate> controllerService;
		
		
	@Autowired
	public CandidateManager(FieldService<Candidate> controllerService) {
		super();
		this.controllerService = controllerService;
		
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return this.controllerService.getAll();
	}
		
	@Override
	public Result add(Candidate newCandidate) {
		return this.controllerService.verifyData(newCandidate);	
	}

	
}
