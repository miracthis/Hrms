package com.hrms.hrms.core.utilities.helpers;

import java.util.List;

import com.hrms.hrms.dataAccess.abstracts.EducationDao;
import com.hrms.hrms.dataAccess.abstracts.JobExperienceDao;
import com.hrms.hrms.dataAccess.abstracts.LanguageDao;
import com.hrms.hrms.dataAccess.abstracts.TechnologyDao;
import com.hrms.hrms.entities.concretes.Education;
import com.hrms.hrms.entities.concretes.JobExperience;
import com.hrms.hrms.entities.concretes.Language;
import com.hrms.hrms.entities.concretes.Resume;
import com.hrms.hrms.entities.concretes.Technology;


public class ResumeHelper {
	
	private EducationDao educationDao; 
	private TechnologyDao technologyDao;
	private LanguageDao languageDao;
	public ResumeHelper(EducationDao educationDao, TechnologyDao technologyDao, LanguageDao languageDao,
			JobExperienceDao jobExperienceDao) {
		super();
		this.educationDao = educationDao;
		this.technologyDao = technologyDao;
		this.languageDao = languageDao;
		this.jobExperienceDao = jobExperienceDao;
	}

	private JobExperienceDao jobExperienceDao;

	
	public void setAllResumeId(List<Education> edu, List<Language> lang, List<Technology> tech, List<JobExperience> exp, Resume resume) {
		setResumeEId(edu,resume);
		setResumeLId(lang,resume);
		setResumeTId(tech,resume);
		setResumeJId(exp,resume);
	}


	private void setResumeEId(List<Education> mapResume, Resume resumee) {
		if (mapResume == null) {
			
		}else {
			for (Education data: mapResume) {
				data.setResume(resumee);
				this.educationDao.save(data);
				}
		}
		
		
	}
		
	private void setResumeLId(List<Language> mapResume, Resume resumee) {
if (mapResume == null) {
			
		}else {
		
		for (Language data: mapResume) {
				data.setResume(resumee);
				this.languageDao.save(data);
				}
		}}
			
	private void setResumeTId(List<Technology> mapResume, Resume resumee) {
if (mapResume == null) {
			
		}else {		
		
		for (Technology data: mapResume) {
					data.setResume(resumee);
					this.technologyDao.save(data);
					}}
			}
				
	private void setResumeJId(List<JobExperience> mapResume, Resume resumee) {
if (mapResume == null) {
			
		}else {			
		
		for (JobExperience data: mapResume) {
						data.setResume(resumee);
						this.jobExperienceDao.save(data);
						}}
	
	
}
	
}
