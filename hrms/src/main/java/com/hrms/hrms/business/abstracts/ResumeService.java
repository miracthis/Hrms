package com.hrms.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Resume;

public interface ResumeService {

	Result add(Resume resume);
	
	DataResult<List<Resume>> getAll();
	
	Result saveImage(MultipartFile file, int resumeId);
}
