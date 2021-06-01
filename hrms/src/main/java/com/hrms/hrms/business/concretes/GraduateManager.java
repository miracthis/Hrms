package com.hrms.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrms.hrms.business.abstracts.GraduateService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.GraduateDao;
import com.hrms.hrms.entities.concretes.Graduate;

@Service
public class GraduateManager implements GraduateService{

	private GraduateDao graduateDao;
	
	@Autowired
	public GraduateManager(GraduateDao graduateDao) {
		super();
		this.graduateDao = graduateDao;
	}

	@Override
	public DataResult<List<Graduate>> getAll() {
		return new SuccessDataResult<List<Graduate>>(this.graduateDao.findAll(), "Data Listelendi");
				
				
	}

	@Override
	public Result add(Graduate graduate) {
		if (graduateDao.existsByDescription(graduate.getDescription())) {
			return new ErrorResult("Daha önce Eklendi");
		}
		
		this.graduateDao.save(graduate);
		return new SuccessResult("Eklendi");
	}

}
