package com.hrms.hrms.entities.dtos;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrms.hrms.entities.concretes.Candidate;
import com.hrms.hrms.entities.concretes.Education;
import com.hrms.hrms.entities.concretes.JobExperience;
import com.hrms.hrms.entities.concretes.Language;
import com.hrms.hrms.entities.concretes.Technology;

public class ResumeDto {
	
	@JsonIgnore
	private int id;
	private int candidateId;
	private String githubLink;
	private String linkedLink;
	private String photo;
	private String description;
	private Date createdDate;
	private Date updatedDate;
	

}
