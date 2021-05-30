package com.hrms.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.JobPostingService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.JobPostingDao;
import com.hrms.hrms.entities.concretes.JobPosting;
import com.hrms.hrms.entities.dtos.JobPostingDto;

@Service
public class JobPostingManager implements JobPostingService {

	
	private JobPostingDao jobPostingDao;
	private ModelMapper modelMapper;
	public JobPostingManager(JobPostingDao jobPostingDao, ModelMapper modelMapper) {
		super();
		this.jobPostingDao = jobPostingDao;
		this.modelMapper = modelMapper;
	}
	
	private List<JobPostingDto> dtoConverter(List<JobPosting> jobPosting){
		List<JobPostingDto> jPDto = new ArrayList <JobPostingDto>();
		jobPosting.forEach(x -> {
			JobPostingDto dto = this.modelMapper.map(x, JobPostingDto.class);
			dto.setEmployerCompanyName(x.getEmployer().getCompanyName());
			jPDto.add(dto);
		});
		
		return jPDto;
		
		
	}
	
	@Override
	public Result add(JobPosting jobPosting) {
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("İş İlanı Eklendi");
	}
	@Override
	public Result delete(JobPosting jobPosting) {
		this.jobPostingDao.delete(jobPosting);
		return new SuccessResult("Silme işlemi Tamamlandı");
	}
	@Override
	public DataResult<List<JobPostingDto>> findByIsActive() {
		return new SuccessDataResult<List<JobPostingDto>>
		(this.dtoConverter(this.jobPostingDao.findByIsActive(true)),"Data Listelendi");
	}
	@Override
	public DataResult<List<JobPostingDto>> findByIsActiveOrderByClosedDate() {
		return new SuccessDataResult<List<JobPostingDto>>
		(this.dtoConverter(this.jobPostingDao.findByIsActiveOrderByClosedDate(true)),"Data Listelendi");
	}
	@Override
	public DataResult<List<JobPostingDto>> findByIsActiveAndEmployer_CompanyName(String companyName) {
		return new SuccessDataResult<List<JobPostingDto>>
		(this.dtoConverter(this.jobPostingDao.findByIsActiveAndEmployer_CompanyName(true, companyName)),"Data Listelendi");
	}
	
	
	
}
