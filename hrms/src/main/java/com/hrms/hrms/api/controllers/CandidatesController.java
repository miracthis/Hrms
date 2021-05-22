package com.hrms.hrms.api.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.business.abstracts.CandidatesService;

import com.hrms.hrms.entities.concretes.Candidates;


@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {

	
	private CandidatesService candidatesService;
	
	
	@Autowired
	public CandidatesController(CandidatesService candidatesService) {
		super();
		this.candidatesService = candidatesService;
		
	}
	
	@GetMapping("/getall")
	public List<Candidates> getAll(){
		return this.candidatesService.getAll();
	}
	
	@PostMapping("/add")
	public String newCandidate(@RequestBody Candidates newCandidate){
		
		if (candidatesService.newCandidate(newCandidate) == "Kayıt OK" ) {
			return "Mernis Doğrulaması Başarılı. Kayıt Database'e aktarıldı.";
		}else {
			return "Kayıt Başarısız. Mernis Doğrulaması Geçerli Değil";
		}
		
		
	}
	
}
