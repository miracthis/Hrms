package com.hrms.hrms.business.concretes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrms.hrms.business.abstracts.CandidatesService;
import com.hrms.hrms.core.utilities.requireds.CandidateFieldsManager;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.dataAccess.abstracts.CandidatesDao;
import com.hrms.hrms.entities.concretes.Candidates;

@Service
public class CandidatesManager implements CandidatesService{

	private CandidatesDao candidatesDao;
	
		
	@Autowired
	public CandidatesManager(CandidatesDao candidatesDao) {
		super();
		this.candidatesDao = candidatesDao;
		
	}

	@Override
	public List<Candidates> getAll() {
		return this.candidatesDao.findAll();
	    
	}
	
	
	@Override
	public Result add(Candidates newCandidate) {
			CandidateFieldsManager candidateFieldsManager = new CandidateFieldsManager(this.candidatesDao);
			return candidateFieldsManager.CandidateControl(newCandidate);
	}

	
}
