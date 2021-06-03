package com.hrms.hrms.entities.dtos;

import java.sql.Date;



import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {
	
	@JsonIgnore
	private int id;
	private int resumeId;
	private String schoolName;
	private int graduateId;
	private String schoolDepartment;
	private Date startedDate;
	private Date endedDate;
	private Date createdDate;
	

}
