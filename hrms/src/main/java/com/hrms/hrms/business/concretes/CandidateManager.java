package com.hrms.hrms.business.concretes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrms.hrms.business.abstracts.CandidateService;
import com.hrms.hrms.business.required.CandidateFieldManager;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.dataAccess.abstracts.CandidateDao;
import com.hrms.hrms.dataAccess.abstracts.UserDao;
import com.hrms.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidatesDao;
	private UserDao userDao;
	
		
	@Autowired
	public CandidateManager(CandidateDao candidatesDao, UserDao userDao) {
		super();
		this.candidatesDao = candidatesDao;
		this.userDao = userDao;
		
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidatesDao.findAll(),"Listeleme Başarılı");
	    
	}
	
	
	@Override
	public Result add(Candidate newCandidate) {
			CandidateFieldManager candidateFieldsManager = new CandidateFieldManager(this.candidatesDao,this.userDao);
			return candidateFieldsManager.candidateControl(newCandidate);
	}

	
}
