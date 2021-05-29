package com.hrms.hrms.business.required;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.ConfirmEmployerService;
import com.hrms.hrms.business.abstracts.FieldService;
import com.hrms.hrms.business.abstracts.VerifyCodeService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.EmployerDao;
import com.hrms.hrms.dataAccess.abstracts.UserDao;
import com.hrms.hrms.entities.concretes.Employer;

@Service
public class EmployerFieldManager implements FieldService<Employer> {

	@Autowired
	private EmployerDao employerDao;
	private UserDao userDao;
	private VerifyCodeService verifyCodeService;
	private ConfirmEmployerService confirmEmployerService; 
	
	public EmployerFieldManager(EmployerDao employerDao, UserDao userDao, VerifyCodeService verifyCodeService, ConfirmEmployerService confirmEmployerService) {
		super();
		this.employerDao = employerDao;
		this.userDao = userDao;
		this.verifyCodeService = verifyCodeService;
		this.confirmEmployerService = confirmEmployerService;
	}
	
	
	@Override
	public Result verifyData(Employer employer) {
		String[] splitMail = employer.getMail().split("@");
		if (!splitMail[1].equals(employer.getWebAddress())) {
			return new ErrorResult("Yalnızca Şirket Web Sitenizin Uzantısına Sahip Bir Mail Adresiyle Kayıt Olabilirsiniz");
		}
		if (this.userDao.existsByMail(employer.getMail())) {
			return new ErrorResult("Mail Adresi Daha Önce Kullanıldı");
		}
		if (employer.getPassword().equals(employer.getPasswordRepeat()) == false) {
			return new ErrorResult("Şifreler Uyuşmuyor");
		}
		this.employerDao.save(employer);
		this.verifyCodeService.createVerifyCode(userDao.getOne(employer.getId()));
		this.confirmEmployerService.createConfirmEmployer(employer);
		this.verifyCodeService.sendMail(employer.getMail());
		return new SuccessResult("Kayıt Başarılı");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Listeleme Başarılı");
	}
	
	
	
}
