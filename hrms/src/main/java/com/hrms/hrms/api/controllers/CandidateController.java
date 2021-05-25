package com.hrms.hrms.api.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hrms.hrms.business.abstracts.CandidateService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

	
	private CandidateService candidatesService;
	
	
	@Autowired
	public CandidateController(CandidateService candidatesService) {
		super();
		this.candidatesService = candidatesService;
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll(){
		return this.candidatesService.getAll();
	}
	
	@PostMapping("/add")
	public Result newCandidate(@Valid @RequestBody Candidate newCandidate){
		return candidatesService.add(newCandidate);
	}
	
		
}
