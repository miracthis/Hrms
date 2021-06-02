package com.hrms.hrms.business.concretes;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.hrms.business.abstracts.ResumeService;
import com.hrms.hrms.core.utilities.cloudinary.CloudinaryService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;

import com.hrms.hrms.dataAccess.abstracts.ResumeDao;

import com.hrms.hrms.entities.concretes.Resume;

@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;
	private CloudinaryService cloudinaryService;
	 
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao, CloudinaryService cloudinaryService) {
		super();
		this.resumeDao = resumeDao;
		this.cloudinaryService = cloudinaryService;
				
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

	@Override
	public Result saveImage(MultipartFile file, int resumeId) {
		Map<String, String> uploader = (Map<String, String>) cloudinaryService.save(file).getData(); 
		String imageUrl= uploader.get("url");
		Resume Cv = resumeDao.getOne(resumeId);
		Cv.setPhoto(imageUrl);
		resumeDao.save(Cv);
		return new SuccessResult("Kayıt Başarılı");
		
	}
	
	
}
