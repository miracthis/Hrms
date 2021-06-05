package com.hrms.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.dtos.ResumeAddDto;
import com.hrms.hrms.entities.dtos.ResumeGetDto;

public interface ResumeService {

	Result add(ResumeAddDto resumeDto);
	
	DataResult<List<ResumeGetDto>> getAll();
	
	DataResult<List<ResumeGetDto>> findAllByCandidateId(int id);
	
	Result saveImage(MultipartFile file, int resumeId);
}
