package com.hrms.hrms.business.concretes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hrms.hrms.business.abstracts.ResumeService;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;

import com.hrms.hrms.dataAccess.abstracts.ResumeDao;

import com.hrms.hrms.entities.concretes.Resume;

@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;
	 
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao) {
		super();
		this.resumeDao = resumeDao;
				
	}


	@Override
	public Result add(Resume resume) {
		resumeDao.save(resume);
		return new SuccessResult("Kayıt Başarılı");
		/*Resume resea = resumeDao.save(resume);
		ResumeHelper helper = new ResumeHelper();
		helper.setAllResumeId
		(resea.getEducation(), resea.getLanguages(), 
		resea.getTechnologies(), resea.getJobExperiences(), resea);
		return new SuccessResult("Kayıt Başarılı");*/
	}


	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<List<Resume>>(resumeDao.findAll(),"Data Listelendi");
	}

	
}
