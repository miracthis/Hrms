package com.hrms.hrms.business.required;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.adapters.MernisAdapter;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.CandidateDao;
import com.hrms.hrms.dataAccess.abstracts.UserDao;
import com.hrms.hrms.entities.concretes.Candidate;

@Service
public class CandidateFieldManager {
	
	
	@Autowired
	private CandidateDao candidatesDao;
	private UserDao userDao;
	
	public CandidateFieldManager(CandidateDao candidatesDao, UserDao userDao) {
		super();
		this.candidatesDao = candidatesDao;
		this.userDao = userDao;
	}

	

	public Result candidateControl(Candidate candidate) {
		
		MernisAdapter ms = new MernisAdapter();
		if (ms.TCKontrol(candidate)==false) {
			return new ErrorResult("Mernis Kimlik Doğrulaması Başarısız Oldu");
		}
		if (this.userDao.existsByMail(candidate.getMail())) {
			return new ErrorResult("Mail Adresi Daha Önce Kullanıldı");
		}
		if (candidatesDao.existsByNationalIdentity(candidate.getNationalIdentity())) {
			return new ErrorResult("TC Kimlik Numarası Daha Önce Kullanıldı");
		}		
		if (candidate.getPassword().equals(candidate.getPasswordRepeat()) == false) {
			return new ErrorResult("Şifreler Uyuşmuyor");
		}
		this.candidatesDao.save(candidate);
		return new SuccessResult("Kayıt Başarılı"); 
			
		
	}
}
