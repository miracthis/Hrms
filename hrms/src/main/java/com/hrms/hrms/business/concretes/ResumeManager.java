package com.hrms.hrms.business.concretes;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.hrms.business.abstracts.ResumeService;
import com.hrms.hrms.core.utilities.cloudinary.CloudinaryService;
import com.hrms.hrms.core.utilities.dtoConverter.DtoConverterService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;

import com.hrms.hrms.dataAccess.abstracts.ResumeDao;
import com.hrms.hrms.entities.concretes.Resume;
import com.hrms.hrms.entities.dtos.ResumeDto;

@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;
	private CloudinaryService cloudinaryService;
	private DtoConverterService dtoConverterService;
	 
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao, CloudinaryService cloudinaryService, DtoConverterService dtoConverterService) {
		super();
		this.resumeDao = resumeDao;
		this.cloudinaryService = cloudinaryService;
		this.dtoConverterService = dtoConverterService;
				
	}


	@Override
	public Result add(ResumeDto resumeDto) {
//		if (resume.getLanguages() != null) {
//			resume.getLanguages().forEach(lang -> lang.setResume(resume));
//		}
//		if (resume.getEducation() != null) {
//			resume.getEducation().forEach(lang -> lang.setResume(resume));
//		}
//		if (resume.getTechnologies() != null) {
//			resume.getTechnologies().forEach(lang -> lang.setResume(resume));
//		}
//		if (resume.getJobExperiences() != null) {
//			resume.getJobExperiences().forEach(lang -> lang.setResume(resume));
//		}
				
		resumeDao.save((Resume) dtoConverterService.dtoClassConverter(resumeDto, Resume.class));
		return new SuccessResult("Kayıt Başarılı");
		
	}


	@Override
	public DataResult<List<ResumeDto>> getAll() {
		return new SuccessDataResult<List<ResumeDto>>
		(dtoConverterService.dtoConverter
				(resumeDao.findAll(), ResumeDto.class)
				,"Data Listelendi");
		
	}

	@Override
	public Result saveImage(MultipartFile file, int resumeId) {
		
		
		@SuppressWarnings("unchecked")
		Map<String, String> uploader = (Map<String, String>) 
				cloudinaryService.save(file).getData(); 
		String imageUrl= uploader.get("url");
		Resume Cv = resumeDao.getOne(resumeId);
		Cv.setPhoto(imageUrl);
		resumeDao.save(Cv);
		return new SuccessResult("Kayıt Başarılı");
		
	}
	
	
}
