package com.hrms.hrms.core.utilities.requireds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.adapters.MernisAdapter;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.CandidatesDao;
import com.hrms.hrms.entities.concretes.Candidates;

@Service
public class CandidateFieldsManager {
	
	
	@Autowired
	private CandidatesDao candidatesDao;
	
	public CandidateFieldsManager(CandidatesDao candidatesDao) {
		super();
		this.candidatesDao = candidatesDao;
	}


	public Result CandidateControl(Candidates candidate) {
		
		if (candidate.getBirth_year().isBlank()) {
			return new ErrorResult("Doğum Tarihi Boş Geçilemez");
		}
		if (candidate.getName().isBlank()) {
			return new ErrorResult("İsim Alanı Boş Geçilemez");
		}
		if (candidate.getMail().isBlank()) {
			return new ErrorResult("Mail Alanı Boş Geçilemez");
		}
		if (candidate.getNationalIdentity().isBlank()) {
			return new ErrorResult("TC Kimlik Numarası Alanı Boş Geçilemez");
		}
		if (candidate.getSurname().isBlank()) {
			return new ErrorResult("Soyisim Alanı Boş Geçilemez");
		}
		if (candidate.getPassword().isBlank()) {
			return new ErrorResult("Şifre Alanı Boş Geçilemez");
		}
		MernisAdapter ms = new MernisAdapter();
		if (ms.TCKontrol(candidate)==false) {
			return new ErrorResult("Mernis Kimlik Doğrulaması Başarısız Oldu");
		}
		if (candidatesDao.existsByMail(candidate.getMail())) {
			return new ErrorResult("Mail Adresi Daha Önce Kullanıldı");
		}
		if (candidatesDao.existsByNationalIdentity(candidate.getNationalIdentity())) {
			return new ErrorResult("TC Kimlik Numarası Daha Önce Kullanıldı");
		}
		
		this.candidatesDao.save(candidate);
		return new SuccessResult("Kayıt Başarılı"); 
			
		
	}
}
