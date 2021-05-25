package com.hrms.hrms.business.abstracts;

import java.util.List;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
public interface FieldService<T> {

	Result verifyData(T data);
	
	DataResult<List<T>> getAll();
	
}
