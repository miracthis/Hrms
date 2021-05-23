package com.hrms.hrms.business.abstracts;
import java.util.List;

import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Candidates;

public interface CandidatesService {
	
	List<Candidates> getAll();
	
	Result add (Candidates candidate) ;
	
}
