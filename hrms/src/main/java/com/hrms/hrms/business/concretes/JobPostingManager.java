package com.hrms.hrms.business.concretes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrms.hrms.business.abstracts.JobPostingService;
import com.hrms.hrms.core.utilities.dtoConverter.DtoConverterService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.JobPostingDao;
import com.hrms.hrms.entities.concretes.JobPosting;
import com.hrms.hrms.entities.dtos.JobPostingAddDto;
import com.hrms.hrms.entities.dtos.JobPostingDto;

@Service
public class JobPostingManager implements JobPostingService {

	
	private JobPostingDao jobPostingDao;
	private DtoConverterService dtoConverterService;
		
	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao, DtoConverterService dtoConverterService) {
		super();
		this.jobPostingDao = jobPostingDao;
		this.dtoConverterService=dtoConverterService;
	}
	
	@Override
	public Result add(JobPostingAddDto jobPostingAddDto) {
		this.jobPostingDao.save((JobPosting) dtoConverterService.dtoClassConverter(jobPostingAddDto, JobPosting.class));
		return new SuccessResult("İş İlanı Eklendi");
	}
	@Override
	public Result delete(JobPosting jobPosting) {
		this.jobPostingDao.delete(jobPosting);
		return new SuccessResult("Silme işlemi Tamamlandı");
	}
	@Override
	public DataResult<List<JobPostingDto>> findByIsActive() {
		return new SuccessDataResult<List<JobPostingDto>>(dtoConverterService.dtoConverter
				(jobPostingDao.findByIsActive(true), JobPostingDto.class),"Aktif İş İlanları Listelendi");
		
	}
	@Override
	public DataResult<List<JobPostingDto>> findByIsActiveOrderByClosedDate() {
		return new SuccessDataResult<List<JobPostingDto>>
		(this.dtoConverterService.dtoConverter(this.jobPostingDao.findByIsActiveOrderByClosedDate(true), JobPostingDto.class),"Data Listelendi");
	}
	@Override
	public DataResult<List<JobPostingDto>> findByIsActiveAndEmployer_CompanyName(String companyName) {
		return new SuccessDataResult<List<JobPostingDto>>
		(this.dtoConverterService.dtoConverter(this.jobPostingDao.findByIsActiveAndEmployer_CompanyName(true, companyName), JobPostingDto.class),"Data Listelendi");
	}
	
	
	
}
