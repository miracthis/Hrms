package com.hrms.hrms.business.required;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.EmployerDao;
import com.hrms.hrms.dataAccess.abstracts.UserDao;
import com.hrms.hrms.entities.concretes.Employer;

@Service
public class EmployerFieldManager {

	@Autowired
	private EmployerDao employerDao;
	private UserDao userDao;
	
	public EmployerFieldManager(EmployerDao employerDao, UserDao userDao) {
		super();
		this.employerDao = employerDao;
		this.userDao = userDao;
	}
	
	public Result employerControl(Employer employer) {
		String[] splitMail = employer.getMail().split("@");
		if (splitMail[1].equals(employer.getWebAddress()) == false) {
			return new ErrorResult("Yalnızca Şirket Web Sitenizin Uzantısına Sahip Bir Mail Adresiyle Kayıt Olabilirsiniz");
		}
		if (this.userDao.existsByMail(employer.getMail())) {
			return new ErrorResult("Mail Adresi Daha Önce Kullanıldı");
		}
		if (employer.getPassword().equals(employer.getPasswordRepeat()) == false) {
			return new ErrorResult("Şifreler Uyuşmuyor");
		}
		this.employerDao.save(employer);
		return new SuccessResult("Kayıt Başarılı");
		
		
		
	}
	
	
	
}
