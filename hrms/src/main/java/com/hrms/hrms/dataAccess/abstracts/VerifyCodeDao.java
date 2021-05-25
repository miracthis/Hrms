package com.hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hrms.hrms.entities.concretes.VerifyCode;

public interface VerifyCodeDao extends JpaRepository<VerifyCode, Integer>{

	VerifyCode getByVerifyCode(String Code);

}
