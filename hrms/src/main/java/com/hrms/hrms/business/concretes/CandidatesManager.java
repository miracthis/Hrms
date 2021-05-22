package com.hrms.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.adapters.MernisAdapter;
import com.hrms.hrms.business.abstracts.CandidatesService;
import com.hrms.hrms.dataAccess.abstracts.CandidatesDao;
import com.hrms.hrms.entities.concretes.Candidates;

@Service
public class CandidatesManager implements CandidatesService{

	private CandidatesDao candidatesDao;
	MernisAdapter ms = new MernisAdapter();
		
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
	public String newCandidate(Candidates newCandidate) {
					if (ms.TCKontrol(newCandidate)) {
						this.candidatesDao.save(newCandidate);
						 return "Kayıt OK";
						
					}else {
						return "Başarısız";
					}
			
		
			 
	}







}
