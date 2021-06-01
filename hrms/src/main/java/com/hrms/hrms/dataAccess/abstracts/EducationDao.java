package com.hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.hrms.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer> {

}
